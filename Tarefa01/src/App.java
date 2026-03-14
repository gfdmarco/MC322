import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {

        String leitura;
        boolean turno_heroi = true; //variável que determina se é a vez do herói jogar
        Scanner entrada = new Scanner(System.in);
        System.out.println();
        System.out.println("Seja bem vindo ao Fuga dos Perigos Noturnos - Versao Unicamp!");
        System.out.println("Aqui, sua missao eh enfrentar os perigos das festas universitarias! Se proteja!");
        System.out.println("Vamos criar o seu calouro! Para isso, crie um nome para o bixao: ");
        System.out.println();
        leitura = entrada.nextLine();
        System.out.println("------------------------------------------------------------------------------------");

        //INICIALIZAÇÃO

        /*Herói (calouro):
        vida máxima: 50, escudo inicial: 0; */
        Heroi heroi = new Heroi(leitura, 50, 0);
        //cartas do herói:
        CartaDano cartadano1 = new CartaDano("Causar tempestade", 1, 
        "Gera uma grande chuva no local da festa. Custo energetico: 1; Dano: 5", 5);
        CartaDano cartadano2 = new CartaDano("Estudar: Lock-In", 3, 
        "O bixao foca 100% nos estudos e se torna -1 consumidor. Custo energetico: 3; Dano: 10", 10);
        CartaDano cartadano3 = new CartaDano("Discar 190", 2, 
        "Liga para a policia e eles acabam com a festa. Custo energetico: 2; Dano: 8", 8);
        CartaEscudo cartaescudo1 = new CartaEscudo("Kit Bixo", 2, 
        "Nosso calouro adquire o kit de protecao para o mesmo. Custo energetico: 2; Escudo: 5", 5);
        CartaEscudo cartaescudo2 = new CartaEscudo("Sair de um dos grupos do OXXO", 1, 
        "Se retira de onde rola as vendas de ingressos. Custo energetico: 1; Escudo: 3", 3);

        /*Inimigo (festas universitárias):
        vida máxima: 40, escudo inicial: 0 */
        String[] festas = {"Calourada", "Postinho", "Churras a Trois", "Mc Lovin", "After", "FEA Fantasy"};
        Random random = new Random();
        Inimigo inimigo = new Inimigo(festas[random.nextInt(festas.length)], 40, 0);
        //cartas do inimigo (marcador _in de inimigo):
        CartaDano cartadano1_in = new CartaDano("Perder pontos de CR", 1, 
        "Faz o bixao perder pontos de coeficiente de rendimento. Custo energetico: 1; Dano: 5", 5);
        CartaDano cartadano2_in = new CartaDano("Ficar de Ressaca", 3, 
        "Nosso calouro acorda mal no dia seguinte. Custo energetico: 3; Dano: 10", 10);
        CartaDano cartadano3_in = new CartaDano("Reprovar por presenca", 2, 
        "Reprova por ter comparecido em menos de 75% das aulas. Custo energetico: 2; Dano: 8", 8);
        CartaEscudo cartaescudo1_in = new CartaEscudo("Open Bar", 2, 
        "A festa libera todas as bebidas de graça. Custo energetico: 2; Escudo: 5", 5);
        CartaEscudo cartaescudo2_in = new CartaEscudo("Presenca de segurancas", 1, 
        "A festa contrata segurancas para protecao da festa. Custo energetico: 1; Escudo: 3", 3);

        //criação dos arrays que compõem o sistema de baralho
        ArrayList<Carta> pilha_compra = new ArrayList<>();
        ArrayList<Carta> mao_heroi = new ArrayList<>();
        ArrayList<Carta> pilha_descarte = new ArrayList<>();
        //adicionando as cartas criadas na pilha inicial de compra
        pilha_compra.add(cartadano1);
        pilha_compra.add(cartadano2);
        pilha_compra.add(cartadano3);
        pilha_compra.add(cartaescudo1);
        pilha_compra.add(cartaescudo2);
        Collections.shuffle(pilha_compra);

        while (heroi.estaVivo(heroi) && inimigo.estaVivo(inimigo)){
            //aqui, geramos um menu de visualização para o jogador com os métodos da classe Menu
            Menu.menuInicial(heroi, inimigo);

            if (turno_heroi){ //caso seja a vez do heroi
                Menu.menuJogador(heroi, inimigo, pilha_compra, mao_heroi, pilha_descarte, entrada);

                //mandar as cartas não utilizadas para a pilha de descarte
                for (int l = 0; l < mao_heroi.size(); l++){
                    pilha_descarte.add(mao_heroi.get(l));
                }
                mao_heroi.clear();
                inimigo.restaurarEscudo();
                turno_heroi = false;
            }
            else { //turno do inimigo
                //usamos o artifício de random choice para o inimigo realizar uma ação (escolher uma das cinco cartas)
                Random random2 = new Random();
                int numCarta = random2.nextInt(5);
                if (numCarta == 0){
                    inimigo.atacar(heroi, cartadano1_in.qtdDano(cartadano1_in));

                    System.out.println();
                    System.out.println(inimigo.pegaNome(inimigo) + " atacou com " + cartadano1_in.pegaNome(cartadano1_in) 
                    + ", causando " + cartadano1_in.qtdDano(cartadano1_in) + " de dano no calouro!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 1){
                    inimigo.atacar(heroi, cartadano2_in.qtdDano(cartadano2_in));

                    System.out.println();
                    System.out.println(inimigo.pegaNome(inimigo) + " atacou com " + cartadano2_in.pegaNome(cartadano2_in) 
                    + ", causando " + cartadano2_in.qtdDano(cartadano2_in) + " de dano no calouro!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 2){
                    inimigo.atacar(heroi, cartadano3_in.qtdDano(cartadano3_in));

                    System.out.println();
                    System.out.println(inimigo.pegaNome(inimigo) + " atacou com " + cartadano3_in.pegaNome(cartadano3_in) 
                    + ", causando " + cartadano3_in.qtdDano(cartadano3_in) + " de dano no calouro!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 3){
                    inimigo.ganharEscudo(cartaescudo1_in.qtdEscudo(cartaescudo1_in));

                    System.out.println();
                    System.out.println(inimigo.pegaNome(inimigo) + " se protegeu com " + 
                    cartaescudo1_in.pegaNome(cartaescudo1_in) + ", concedendo " + 
                    cartaescudo1_in.qtdEscudo(cartaescudo1_in) + " de escudo!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 4){
                    inimigo.ganharEscudo(cartaescudo2_in.qtdEscudo(cartaescudo2_in));

                    System.out.println();
                    System.out.println(inimigo.pegaNome(inimigo) + " se protegeu com " + 
                    cartaescudo2_in.pegaNome(cartaescudo2_in) + ", concedendo " + 
                    cartaescudo2_in.qtdEscudo(cartaescudo2_in) + " de escudo!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                heroi.restaurarEnergia();
                heroi.restaurarEscudo();
                turno_heroi = true;
            }
        }
        if (!heroi.estaVivo(heroi)){
            System.out.println("Voce perdeu! O bixao enlouqueceu! Nao sobrou nada...");
            System.out.println();
        }
        else if (!inimigo.estaVivo(inimigo)){
            System.out.println("Parabens bixao! Voce conseguiu acabar com o hype da festa e manteve sua sanidade!");
            System.out.println();
        }
        System.out.println();
        System.out.println("JOGO ENCERRADO!");
        System.out.println();
        entrada.close();
    }
}
