import java.util.Scanner;
import java.util.Random;

public class App {
    //revisar o que precisa ser feito na tarefa a partir do pdf e chamar as classes. depois disso, testar
    //DÚVIDA: compra das cartas: em que momento? obrigatória?
    public static void main(String[] args) {

        String leitura;
        boolean turno_heroi = true; //variável que determina se é a vez do herói jogar
        Scanner entrada = new Scanner(System.in);
        System.out.println("Seja bem vindo ao Fuga dos Perigos Noturnos - Versão Unicamp!");
        System.out.println("Aqui, sua missão é enfrentar os perigos das festas universitárias! Se proteja!");
        System.out.println("Vamos criar o seu calouro! Para isso, crie um nome para o 'bixão': ");
        leitura = entrada.next();
        System.out.println("------------------------------------------------------------------------------------");

        //INICIALIZAÇÃO - falta descrever as cartas na interface e arrumar a estética (nomes etc)

        /*Herói (calouro):
        vida máxima: 80, escudo inicial: 0; */
        Heroi heroi = new Heroi(leitura, 80, 0);
        //cartas do herói:
        CartaDano cartadano1 = new CartaDano("Tempestade", 1, 5);
        CartaDano cartadano2 = new CartaDano("Estudar: Lock-In", 3, 10);
        CartaDano cartadano3 = new CartaDano("Discar 190", 2, 8);
        CartaEscudo cartaescudo1 = new CartaEscudo("Ajuda de Veterano", 2, 5);
        CartaEscudo cartaescudo2 = new CartaEscudo("Sair de um dos grupos do OXXO", 1, 3);

        /*Inimigo (festas universitárias):
        vida máxima: 40, escudo inicial: 0 */
        String[] festas = {"Calourada", "Postinho", "Churras a Trois"};
        Random random = new Random();
        Inimigo inimigo = new Inimigo(festas[random.nextInt(festas.length)], 40, 0);
        //cartas do inimigo (marcador _in de inimigo):
        CartaDano cartadano1_in = new CartaDano("Queda no CR", 1, 5);
        CartaDano cartadano2_in = new CartaDano("Ressaca", 3, 10);
        CartaDano cartadano3_in = new CartaDano("Reprovação por presença", 2, 8);
        CartaEscudo cartaescudo1_in = new CartaEscudo("Open Bar", 2, 5);
        CartaEscudo cartaescudo2_in = new CartaEscudo("Presença de seguranças", 1, 3);

        /*falta codar os consumos de energia com os ataques, além de restaurar o escudo a cada turno e 
        fazer a própria troca de turnos*/

        while (heroi.estaVivo(heroi) && inimigo.estaVivo(inimigo)){
            //nao posso esquecer de descartar o escudo depois e de reiniciar a energia quando termina o turno
            //aqui, geramos um menu de visualização para o jogador

            Menu.menuInicial(heroi, inimigo);

            if (turno_heroi){ //caso seja a vez do heroi
                int leitura2 = Menu.menuDecisao(heroi, inimigo, entrada);

                if((leitura2 == 1 || leitura2 == 2) && heroi.qtdEnergia(heroi) == 0){
                    System.out.println("ERRO: Energia insuficiente! Encerre o turno!");
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
                    System.out.println("Encerrando turno do calouro...");
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                    turno_heroi = false;
                }
            }
            else { //turno do inimigo
                //usamos o artifício de random choice para o inimigo realizar uma ação (escolher uma das cinco cartas)
                Random random2 = new Random();
                int numCarta = random2.nextInt(5);
                if (numCarta == 0){
                    inimigo.atacar(heroi, cartadano1_in.qtdDano(cartadano1_in));

                    System.out.println(inimigo.pegaNome(inimigo) + " atacou causando " + 
                    cartadano1_in.qtdDano(cartadano1_in) + " no calouro!");
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 1){
                    inimigo.atacar(heroi, cartadano2_in.qtdDano(cartadano2_in));

                    System.out.println(inimigo.pegaNome(inimigo) + " atacou causando " + 
                    cartadano2_in.qtdDano(cartadano2_in) + " no calouro!");
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 2){
                    inimigo.atacar(heroi, cartadano3_in.qtdDano(cartadano3_in));

                    System.out.println(inimigo.pegaNome(inimigo) + " atacou causando " + 
                    cartadano3_in.qtdDano(cartadano3_in) + " no calouro!");
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 3){
                    inimigo.ganharEscudo(cartaescudo1_in.qtdEscudo(cartaescudo1_in));

                    System.out.println(inimigo.pegaNome(inimigo) + " se protegeu com " + 
                    cartaescudo1_in.qtdEscudo(cartaescudo1_in) + " de escudo!");
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 4){
                    inimigo.ganharEscudo(cartaescudo2_in.qtdEscudo(cartaescudo2_in));

                    System.out.println(inimigo.pegaNome(inimigo) + " se protegeu com " + 
                    cartaescudo2_in.qtdEscudo(cartaescudo2_in) + " de escudo!");
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                heroi.restaurarEnergia();
                heroi.restaurarEscudo();
                turno_heroi = true;
            }
        }
        entrada.close();
    }
}
