import java.util.Scanner;
import java.util.Random;

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
        vida máxima: 80, escudo inicial: 0; */
        Heroi heroi = new Heroi(leitura, 80, 0);
        //cartas do herói:
        CartaDano cartadano1 = new CartaDano("Causar tempestade", 1, 5);
        CartaDano cartadano2 = new CartaDano("Estudar: Lock-In", 3, 10);
        CartaDano cartadano3 = new CartaDano("Discar 190", 2, 8);
        CartaEscudo cartaescudo1 = new CartaEscudo("Kit Bixo", 2, 5);
        CartaEscudo cartaescudo2 = new CartaEscudo("Sair de um dos grupos do OXXO", 1, 3);

        /*Inimigo (festas universitárias):
        vida máxima: 40, escudo inicial: 0 */
        String[] festas = {"Calourada", "Postinho", "Churras a Trois", "Mc Lovin", "After"};
        Random random = new Random();
        Inimigo inimigo = new Inimigo(festas[random.nextInt(festas.length)], 70, 0);
        //cartas do inimigo (marcador _in de inimigo):
        CartaDano cartadano1_in = new CartaDano("Perder pontos de CR", 1, 5);
        CartaDano cartadano2_in = new CartaDano("Ficar de Ressaca", 3, 10);
        CartaDano cartadano3_in = new CartaDano("Reprovar por presenca", 2, 8);
        CartaEscudo cartaescudo1_in = new CartaEscudo("Open Bar", 2, 5);
        CartaEscudo cartaescudo2_in = new CartaEscudo("Presenca de segurancas", 1, 3);


        while (heroi.estaVivo(heroi) && inimigo.estaVivo(inimigo)){
            //aqui, geramos um menu de visualização para o jogador com os métodos da classe Menu
            Menu.menuInicial(heroi, inimigo);

            if (turno_heroi){ //caso seja a vez do heroi

                System.out.println();
                System.out.println("SUA VEZ DE JOGAR!");
                System.out.println();

                int leitura2 = Menu.menuDecisao(heroi, inimigo, entrada);

                if((leitura2 == 1 || leitura2 == 2) && heroi.qtdEnergia(heroi) == 0){
                    System.out.println();
                    System.out.println("ERRO: Energia insuficiente! Encerre o turno!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }

                else if (leitura2 == 1 && heroi.qtdEnergia(heroi) > 0){
                    int leitura3 = Menu.menuDano(heroi, inimigo, entrada, cartadano1, cartadano2, cartadano3);
                    if (leitura3 == 1){
                        cartadano1.usar(heroi, inimigo);
                    }
                    else if (leitura3 == 2){
                        cartadano2.usar(heroi, inimigo);
                    }
                    else if (leitura3 == 3){
                        cartadano3.usar(heroi, inimigo);
                    }
                }
                else if (leitura2 == 2 && heroi.qtdEnergia(heroi) > 0){
                    int leitura4 = Menu.menuEscudo(heroi, inimigo, entrada, cartaescudo1, cartaescudo2);
                    if (leitura4 == 1){
                        cartaescudo1.usar(heroi);
                    }
                    else if (leitura4 == 2){
                        cartaescudo2.usar(heroi);
                    }
                }
                else if (leitura2 == 3){
                    System.out.println("ENCERRANDO TURNO DO CALOURO...");
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                    inimigo.restaurarEscudo();
                    turno_heroi = false;
                }
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
        System.out.println();
        System.out.println("JOGO ENCERRADO!");
        System.out.println();
        entrada.close();
    }
}
