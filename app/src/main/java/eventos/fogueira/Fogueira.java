package eventos.fogueira;

import java.util.ArrayList;
import java.util.Scanner;

import cartas.Carta;
import jogo.EstadoJogo;

/**
 * Representa o evento da Fogueira no mapa. Implementado com padrão de design Strategy.
 * Strategy foi utilizado em razão da situação de poder utilizar a mesma fogueira de diferentes maneiras (estratégias)
 */
public class Fogueira extends eventos.Evento{
    /**
     * Executa o evento de Fogueira, denominado como Bandeco.
     * @param estado        Estado de Jogo atual, que abrange os elementos imprescindíveis para a utilização da fogueira.
     * @param cartasExtras  Aqui, não são utilizadas. Apenas compõem a função padrão que possui dois parâmetros.
     */
    @Override
    public boolean iniciar(EstadoJogo estado, ArrayList<Carta> cartasExtras){
        System.out.println("=================================================================================="); 
        System.out.println("                        Seja bem-vindo(a) ao Bandeco!");
        System.out.println("=================================================================================="); 
        System.out.println();
        System.out.println("   Aqui voce pode regenerar parte da sua sanidade, ou melhorar uma de suas cartas");
        System.out.println("         OBS: caso a regeneracao passe da vida maxima, ocorre um truncamento!");
        System.out.println("OBS2: as melhorias acontecem com um bonus da quantidade de custo energetico da carta!");
        System.out.println();

        Scanner entrada = estado.pegaEntrada();
        ContextoFogueira contexto = new ContextoFogueira();
        
        while (true){
            System.out.println();
            System.out.println("Escolha como deseja usar o bandeco!");
            System.out.println("1 - Regenerar 20% da sanidade maxima");
            System.out.println("2 - Melhorar carta");

            int leitura;
            leitura = entrada.nextInt();

            if (leitura != 1 && leitura != 2){
                System.out.println("==================================================================================");
                System.out.println("                    ERRO: numero invalido! Digite novamente");
                System.out.println("==================================================================================");
            }
            else if (leitura == 1){
                contexto.setEstrategia(new EstrategiaRegenerar(estado));
                contexto.executar();
                break;
            }
            else if (leitura == 2){
                System.out.println("**************************************"); 
                System.out.println("     Cartas na pilha de compras");
                System.out.println("**************************************");
                for (int i = 0; i < estado.pegaPilhaCompra().size(); i++){
                    System.out.println("[ " + (i + 1) + " ] " + estado.pegaPilhaCompra().get(i).pegaNome());
                    System.out.println("DESCRICAO: " + estado.pegaPilhaCompra().get(i).pegaDescricao());
                }
                System.out.println("Digite a carta que deseja melhorar: ");
                System.out.println("Caso queira sair, digite 0");
                int leitura2;
                leitura2 = entrada.nextInt();
                if (leitura2 < 0 || leitura2 > estado.pegaPilhaCompra().size()){
                    System.out.println("==================================================================================");
                    System.out.println("                    ERRO: numero invalido! Digite novamente");
                    System.out.println("==================================================================================");
                }
                else if (leitura2 == 0){
                    break;
                }
                else {
                    contexto.setEstrategia(new EstrategiaMelhorar(estado.pegaPilhaCompra().get(leitura2 - 1)));
                    contexto.executar();
                    break;
                }
            }
        }



        try{       
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.err.println("Pausa interrompida");
        }
        return true;
    }
}
