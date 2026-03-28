import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {
    public ArrayList<Efeito> subscribers = new ArrayList<>();

    public void inscrever(Efeito efeito){
        subscribers.add(efeito);
    }

    public void desinscrever(Efeito efeito){
        subscribers.remove(efeito);
    }

    public void notificar(String evento, Menu menu){
        for (int i = 0; i < subscribers.size(); i++){
            subscribers.get(i).serNotificado(evento, menu);
        }
    }

    public void menuInicial(Heroi heroi, Inimigo inimigo){
        System.out.println("Calouro " + heroi.pegaNome() + " VS " + inimigo.pegaNome());
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Calouro '" + heroi.pegaNome() + "' - Sanidade: " + heroi.qtdVida() + "/50");
        if (heroi.qtdEscudo() > 0){
            System.out.println("**");
            System.out.println("Protecao:" + heroi.qtdEscudo());
        }
        if (heroi.pegaEfeitos().size() > 0){
            System.out.println("**");
            System.out.println("Efeitos: ");
            for (int i = 0; i < heroi.pegaEfeitos().size(); i++){
                System.out.println(heroi.pegaEfeitos().get(i).pegaNome() + 
                " (Acumulos: " + heroi.pegaEfeitos().get(i).qtdAcumulos() + ")");
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("Festa do(a) '" + inimigo.pegaNome() + "' - Hype: " + inimigo.qtdVida() + "/40");
        if (inimigo.qtdEscudo() > 0){
            System.out.println("**");
            System.out.println("Protecao:" + inimigo.qtdEscudo());
        }
        if (inimigo.pegaEfeitos().size() > 0){
            System.out.println("**");
            System.out.println("Efeitos: ");
            for (int i = 0; i < inimigo.pegaEfeitos().size(); i++){
                System.out.println(inimigo.pegaEfeitos().get(i).pegaNome() + 
                " (Acumulos: " + inimigo.pegaEfeitos().get(i).qtdAcumulos() + ")");;
            }
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

   public void menuJogador(Heroi heroi, Inimigo inimigo, List<Carta> pilha_compra, List<Carta> mao_heroi,
    List<Carta> pilha_descarte, Scanner entrada, Menu menu){

        //ETAPA DE COMPRAS
        System.out.println("Recebendo novas cartas e compondo nova mao...");
        System.out.println("OBS: voce recebe sempre 3 cartas por turno!");
        
        for (int carta_comprar = 0; carta_comprar < 3; carta_comprar++){
            //embaralhar
            if (pilha_compra.size() == 0){
                Collections.shuffle(pilha_descarte);
                for (int k = 0; k < pilha_descarte.size(); k++){
                    pilha_compra.add(0, pilha_descarte.get(k));
                }
                pilha_descarte.clear();
            }
            if (pilha_compra.size() > 0) {
                System.out.println();
                mao_heroi.add(pilha_compra.get(0)); //0 para pegar sempre o topo!
                System.out.println(pilha_compra.get(0).pegaNome() 
                + " foi adicionada a mao!");
                pilha_compra.remove(0);
            }
        }

        //INICIO DO TURNO
        System.out.println();
        System.out.println("SUA VEZ DE JOGAR!");
        System.out.println("OBS: caso nao tenha energia suficiente para gastar em uma carta, encerre o turno!");
        System.out.println();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        while (heroi.qtdEnergia() > 0 && heroi.estaVivo() && inimigo.estaVivo()){
            this.menuInicial(heroi, inimigo);
            System.out.println("O bixao tem " + heroi.qtdEnergia() + "/4 de Energia para utilizar");
            System.out.println();
            System.out.println("Mao atual do bixao:");
            if (mao_heroi.size() == 0){
                System.out.println("Voce ja utilizou as tres cartas e sobrou energia! Encerre o turno!");
            }
            for (int i = 0; i < mao_heroi.size(); i++){
                System.out.println(i + " - " + mao_heroi.get(i).pegaNome() + " - " 
                + mao_heroi.get(i).pegaDescricao());
            }
            System.out.println();
            System.out.println("E ai? Como o(a) " + heroi.pegaNome() + " reage?");
            System.out.println("1 - Utilizar carta");
            System.out.println("2 - Encerrar turno");
            System.out.println("Digite: ");
            int leitura2 = entrada.nextInt();
            if (leitura2 == 2){
                System.out.println("ENCERRANDO TURNO DO JOGADOR...");
                break;
            }
            else if (leitura2 == 1){
                System.out.println("Digite qual carta deseja utilizar conforme a numeracao dela:");
                int leitura3 = entrada.nextInt();
                if (leitura3 >= 0 && leitura3 < mao_heroi.size() && (heroi.qtdEnergia() - mao_heroi.get(leitura3).qtdCusto()) < 0){
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                    System.out.println("ERRO: nao foi possivel utilizar esta carta (energia insuficiente)!");
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                    System.out.println();
                }
                else if (leitura3 >= 0 && leitura3 < mao_heroi.size() && (heroi.qtdEnergia() - mao_heroi.get(leitura3).qtdCusto()) >= 0){
                    mao_heroi.get(leitura3).usar(heroi, inimigo, menu);
                    pilha_descarte.add(mao_heroi.get(leitura3));
                    mao_heroi.remove(leitura3);
                }
                else {
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                    System.out.println("ERRO: numero invalido!");
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                    System.out.println();
                }
            }
            else {
                System.out.println();
                System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                System.out.println("ERRO: numero invalido!");
                System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                System.out.println();
            }
        }
        if (heroi.qtdEnergia() == 0){
            System.out.println("///////////////////////////////////////////////////////////////////////////////////");            
            System.out.println("Energia esgotada! Turno se encerrando automaticamente...");
            System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        }

        System.out.println();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
   }
}