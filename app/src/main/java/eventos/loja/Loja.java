package eventos.loja;

import java.util.ArrayList;
import java.util.Scanner;

import cartas.Carta;
import jogo.EstadoJogo;

import java.util.HashMap;
import java.util.Map;

public class Loja extends eventos.Evento{
    private Map<Integer, Integer> tabelaPrecos = new HashMap<>();

    public void precos(){;
        tabelaPrecos.put(1, 400);
        tabelaPrecos.put(2, 600);
        tabelaPrecos.put(3, 800);
        tabelaPrecos.put(4, 1000);
    }

    public int calcularPreco(Carta carta){
        return tabelaPrecos.get(carta.qtdCusto());
    }

    @Override
    public boolean iniciar(EstadoJogo estado, ArrayList<Carta> cartasExtras){
        System.out.println("=================================================================================="); 
        System.out.println("                            Seja bem-vindo a loja!");
        System.out.println("=================================================================================="); 
        System.out.println();
        System.out.println("        Aqui voce pode comprar cartas, como tambem remover outras do seu baralho!");
        System.out.println("                      OBS: TODAS essas operacoes custam ouro!");

        Scanner entrada = estado.pegaEntrada();
        while (true){
            System.out.println("Escolha como deseja investir seu ouro!");
            System.out.println("1 - Comprar carta(s)");
            System.out.println("2 - Remover Cartas");
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

                        comando.executar();
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
                        Comando comando = new ComandoRemoverCarta(estado, estado.pegaPilhaCompra().get(leitura2 - 1), 
                        calcularPreco(estado.pegaPilhaCompra().get(leitura2 - 1)));
                        
                        comando.executar();
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
        return true;
    }
}
