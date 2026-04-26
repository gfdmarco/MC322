package eventos.loja;

import java.util.ArrayList;
import java.util.Scanner;

import cartas.Carta;
import jogo.EstadoJogo;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa o evento de Loja no mapa.
 */
public class Loja extends eventos.Evento{
    /**
     * Utiliza-se uma tabela hash para fazer a associação custo energético -> preço para as cartas
     * Se aplica ao preço de remoção e ao de compra
     */
    private Map<Integer, Integer> tabelaPrecos = new HashMap<>();

    /**
     * Construtor para estabelecer as relações da tabela hash de custo energético -> preço
     * Exemplo: se a carta exige 1 de energia para ser utilizada, custará 400 de ouro para sua compra ou remoção.
     */
    public Loja(){; //de custo para energia
        tabelaPrecos.put(1, 400);
        tabelaPrecos.put(2, 600);
        tabelaPrecos.put(3, 800);
        tabelaPrecos.put(4, 1000);
    }

    /**
     * Calcula o preço da carta a partir de seu custo energético
     */
    public int calcularPreco(Carta carta){
        return tabelaPrecos.get(carta.qtdCusto());
    }

    /**
     * Executa o evento de Loja.
     * @param estado        Estado de Jogo atual, que abrange os elementos imprescindíveis para a execução da loja.
     * @param cartasExtras  Cartas oferecidas para compra na loja. As de remoção são as da própria pilha de compra.
     */
    @Override
    public boolean iniciar(EstadoJogo estado, ArrayList<Carta> cartasExtras){
        ExecutorComando executor = new ExecutorComando();
        System.out.println("=================================================================================="); 
        System.out.println("                          Seja bem-vindo(a) a Loja!");
        System.out.println("=================================================================================="); 
        System.out.println();
        System.out.println("   Aqui voce pode comprar cartas, como tambem remover outras do seu baralho!");
        System.out.println("                  OBS: TODAS essas operacoes custam ouro!");
        System.out.println();

        Scanner entrada = estado.pegaEntrada();
        while (true){
            System.out.println();
            System.out.println("SALDO ATUAL: " + estado.pegaHeroi().qtdOuro());
            System.out.println();
            System.out.println("Escolha como deseja investir seu ouro!");
            System.out.println("1 - Comprar carta(s)");
            System.out.println("2 - Remover carta(s)");
            System.out.println("3 - Sair da loja");
            int leitura;
            leitura = entrada.nextInt();
            if (leitura == 1){
                while (true){
                    System.out.println("**************************************"); 
                    System.out.println("            Cartas a venda");
                    System.out.println("**************************************");
                    for (int i = 0; i < cartasExtras.size(); i++){
                        int preco = calcularPreco(cartasExtras.get(i));
                        System.out.println("[ " + (i + 1) + " ] " + cartasExtras.get(i).pegaNome());
                        System.out.println("DESCRICAO: " + cartasExtras.get(i).pegaDescricao());
                        System.out.println("PRECO: " + preco);
                    }
                    System.out.println("Digite a carta que deseja comprar: ");
                    System.out.println("Caso queira sair, digite 0");
                    int leitura2;
                    leitura2 = entrada.nextInt();
                    if (leitura2 < 0 || leitura2 > cartasExtras.size()){
                        System.out.println("==================================================================================");
                        System.out.println("                    ERRO: numero invalido! Digite novamente");
                        System.out.println("==================================================================================");
                    }
                    else if (leitura2 == 0){
                        break;
                    }
                    else {
                        Comando comando = new ComandoComprarCarta(estado, cartasExtras.get(leitura2 - 1), 
                        calcularPreco(cartasExtras.get(leitura2 - 1)));

                        executor.executar(comando);
                        break;
                    }
                }
            }
            else if (leitura == 2){
                while (true){
                    System.out.println("**************************************"); 
                    System.out.println("     Cartas na pilha de compras");
                    System.out.println("**************************************");
                    for (int i = 0; i < estado.pegaPilhaCompra().size(); i++){
                        int preco = calcularPreco(estado.pegaPilhaCompra().get(i));
                        System.out.println("[ " + (i + 1) + " ] " + estado.pegaPilhaCompra().get(i).pegaNome());
                        System.out.println("DESCRICAO: " + estado.pegaPilhaCompra().get(i).pegaDescricao());
                        System.out.println("PRECO: " + preco);
                    }
                    System.out.println("Digite a carta que deseja remover: ");
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
                        Comando comando = new ComandoRemoverCarta(estado, leitura2 - 1, 
                            calcularPreco(estado.pegaPilhaCompra().get(leitura2 - 1)));
                        
                        executor.executar(comando);
                        break;
                    }
                }
            }
            else if (leitura == 3){
                break;
            }
            else {
                System.out.println("==================================================================================");
                System.out.println("                    ERRO: numero invalido! Digite novamente");
                System.out.println("==================================================================================");
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
