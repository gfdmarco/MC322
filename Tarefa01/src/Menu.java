import java.util.Scanner;
import java.util.Collections;
import java.util.List;

public class Menu {
    public static void menuInicial(Heroi heroi, Inimigo inimigo){
        System.out.println("Calouro " + heroi.pegaNome(heroi) + " VS " + inimigo.pegaNome(inimigo));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Calouro '" + heroi.pegaNome(heroi) + "' - Sanidade: " + heroi.qtdVida(heroi) + "/50");
        if (heroi.qtdEscudo(heroi) > 0){
            System.out.println("Protecao:" + heroi.qtdEscudo(heroi));
        }
        System.out.println("Festa do(a) '" + inimigo.pegaNome(inimigo) + "' - Hype: " + inimigo.qtdVida(inimigo) + "/40");
        if (inimigo.qtdEscudo(inimigo) > 0){
            System.out.println("Protecao:" + inimigo.qtdEscudo(inimigo));
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

   public static void menuJogador(Heroi heroi, Inimigo inimigo, List<Carta> pilha_compra, List<Carta> mao_heroi,
    List<Carta> pilha_descarte, Scanner entrada){
    
        System.out.println();
        System.out.println("SUA VEZ DE JOGAR!");
        System.out.println();
        System.out.println("ETAPA DE COMPRAS! Voce pode comprar 3 cartas por turno!");
        System.out.println();

        int cartas_compradas = 0;
        while (cartas_compradas < 3){
            System.out.println("Escolha qual(is) carta(s) deseja comprar!");
            System.out.println("OBS: limite de 3 cartas por turno!");
            System.out.println("0 - Encerrar compras (Ignorar)");
            if (pilha_compra.size() == 0){
                //embaralhar
                Collections.shuffle(pilha_descarte);
                for (int k = 0; k < pilha_descarte.size(); k++){
                    pilha_compra.add(pilha_descarte.get(k));
                }
                pilha_descarte.clear();
            }
            else {
                for (int w = 0; w < pilha_compra.size(); w++){
                System.out.println((w + 1) + " - " + pilha_compra.get(w).pegaNome(pilha_compra.get(w)) + 
                " - " + pilha_compra.get(w).pegaDescricao(pilha_compra.get(w)));
                }
            }

            int leitura2 = entrada.nextInt();

            if (leitura2 == 0){
                if (mao_heroi.size() == 0){
                    System.out.println();
                    System.out.println("ERRO: voce ainda nao tem cartas! Compre pelo menos uma!");
                    System.out.println();
                }
                else{
                    break;
                }
            }
            else if (leitura2 <= pilha_compra.size()){
                mao_heroi.add(pilha_compra.get(leitura2 - 1));
                System.out.println();
                System.out.println(pilha_compra.get(leitura2 - 1).pegaNome(pilha_compra.get(leitura2 - 1)) 
                + " foi adicionada a mao!");
                System.out.println();
                pilha_compra.remove(pilha_compra.get(leitura2 - 1));
                //embaralhar
                if (pilha_compra.size() == 0){
                    Collections.shuffle(pilha_descarte);
                    for (int k = 0; k < pilha_descarte.size(); k++){
                        pilha_compra.add(pilha_descarte.get(k));
                    }
                    pilha_descarte.clear();
                }
                cartas_compradas++;
            }
            else {
                System.out.println();
                System.out.println("ERRO: numero invalido!");
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("ETAPA DE COMPRAS ENCERRADA! VAMOS AO TURNO DO CONFRONTO!");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        while (heroi.qtdEnergia(heroi) > 0){
            Menu.menuInicial(heroi, inimigo);
            System.out.println("O bixao tem " + heroi.qtdEnergia(heroi) + "/4 de Energia para utilizar");
            System.out.println();
            System.out.println("Mao atual do bixao:");
            for (int i = 0; i < mao_heroi.size(); i++){
                System.out.println(i + " - " + mao_heroi.get(i).pegaNome(mao_heroi.get(i)) + " - " 
                + mao_heroi.get(i).pegaDescricao(mao_heroi.get(i)));
            }
            System.out.println();
            System.out.println("E ai? Como o(a) " + heroi.pegaNome(heroi) + " reage?");
            System.out.println("1 - Utilizar carta");
            System.out.println("2 - Encerrar turno");
            System.out.println("Digite: ");
            int leitura3 = entrada.nextInt();
            if (leitura3 == 2){
                System.out.println("ENCERRANDO TURNO DO JOGADOR...");
                break;
            }
            if (leitura3 == 1){
                System.out.println("Digite qual carta deseja utilizar:");
                int leitura4 = entrada.nextInt();
                if (leitura4 < mao_heroi.size() && (heroi.qtdEnergia(heroi) - mao_heroi.get(leitura4).qtdCusto(mao_heroi.get(leitura4))) < 0){
                    System.out.println();
                    System.out.println("ERRO: nao foi possivel utilizar esta carta (energia insuficiente)!");
                    System.out.println();
                }
                if (leitura4 < mao_heroi.size() && (heroi.qtdEnergia(heroi) - mao_heroi.get(leitura4).qtdCusto(mao_heroi.get(leitura4))) > 0){
                    mao_heroi.get(leitura4).usar(heroi, inimigo);
                    pilha_descarte.add(mao_heroi.get(leitura4));
                    mao_heroi.remove(mao_heroi.get(leitura4));
                }
                else {
                    System.out.println();
                    System.out.println("ERRO: numero invalido!");
                    System.out.println();
                }
            }
            else {
                System.out.println();
                System.out.println("ERRO: numero invalido!");
                System.out.println();
            }
        }
        if (heroi.qtdEnergia(heroi) == 0){
            System.out.println("///////////////////////////////////////////////////////////////////////////////////");            
            System.out.println("Energia esgotada! Turno se encerrando automaticamente...");
            System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        }

        System.out.println();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
   }
}
