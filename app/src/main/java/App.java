import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {

        Menu menu = new Menu();
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
        
        /*Cartas de Efeito */
        CartaEfeito cartaefeito1 =  new CartaEfeito("Investimento", 3, 
        "Para o calouro, recebe uma Bolsa da Fapesp. Para a festa, recebe investimento para Booms. Custo energetico: 3; Acumulo do Efeito: 3", "Investimento", 3);
        CartaEfeito cartaefeito2 = new CartaEfeito("Resenhoff", 2,
        "Fornecer a vodka Resenhoff, contaminada com Metanol. Custo energetico: 2; Acumulo do Efeito: 3", "Metanol", 3);
        
        /*Herói (calouro):
        vida máxima: 50, escudo inicial: 0; */
        Heroi heroi = new Heroi(leitura, 50, 0);
        //cartas do herói:
        CartaDano cartadano1 = new CartaDano("Causar tempestade", 1, 
        "Gera uma grande chuva no local da festa. Custo energetico: 1; Dano: 5", 5);
        CartaDano cartadano2 = new CartaDano("Estudar: Lock-In", 3, 
        "O bixao foca 100% nos estudos e se torna um consumidor a menos. Custo energetico: 3; Dano: 10", 10);
        CartaDano cartadano3 = new CartaDano("Discar 190", 2, 
        "Liga para a policia e eles acabam com a festa. Custo energetico: 2; Dano: 8", 8);
        CartaDano cartadano4 = new CartaDano("Reclamar no Spotted", 2, 
        "Uma reclamacao anonima surge no spotted criticando a festa. Custo energetico: 2; Dano: 6", 6);
        CartaDano cartadano5 = new CartaDano("Hackear a caixa de som", 3, 
        "Usa habilidades computacionais para colocar musicas infantis na caixa de som da festa. Custo energetico: 3; Dano: 9", 9);
        CartaDano cartadano6 = new CartaDano("Boicotar a Cheers", 1, 
        "Um ataque cibernetico faz com que o app fique fora do ar por alguns minutos. Custo energetico: 1; Dano: 4", 4);
        CartaEscudo cartaescudo1 = new CartaEscudo("Kit Bixo", 2, 
        "Nosso calouro adquire o kit de protecao para o mesmo. Custo energetico: 2; Escudo: 5", 5);
        CartaEscudo cartaescudo2 = new CartaEscudo("Sair de um dos grupos do OXXO", 1, 
        "Se retira de onde rola as vendas de ingressos. Custo energetico: 1; Escudo: 3", 3);
        CartaEscudo cartaescudo3 = new CartaEscudo("Passar tempo em alguma entidade", 2, 
        "O bixao se aventura em entidades da computacao, aumentando suas softskills. Custo energetico: 2; Escudo: 4", 4);
        CartaEscudo cartaescudo4 = new CartaEscudo("Jogar Videogame", 1, 
        "Seguindo o estereotipo, o bixao passa a noite jogando Fuga dos Perigos Noturnos. Custo energetico: 1; Escudo: 2", 2);

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
        CartaDano cartadano4_in = new CartaDano("Perder a hora do Bandeco", 3, 
        "O bixao acorda atrasado no outro dia e se depara com o RU fechado. Custo energetico: 3; Dano: 12", 12);
        CartaDano cartadano5_in = new CartaDano("Perder a caneca", 2, 
        "O calouro perde sua caneca de bebidas para as festas. Custo energetico: 2; Dano: 7", 7);
        CartaDano cartadano6_in = new CartaDano("Tontura", 1, 
        "Faz com que o calouro perca o equilibrio pelas proximas horas. Custo energetico: 1; Dano: 6", 6);
        CartaEscudo cartaescudo1_in = new CartaEscudo("Open Bar", 3, 
        "A festa libera todas as bebidas de graca. Custo energetico: 3; Escudo: 5", 5);
        CartaEscudo cartaescudo2_in = new CartaEscudo("Presenca de segurancas", 1, 
        "A festa contrata segurancas para protecao da festa. Custo energetico: 1; Escudo: 3", 3);
        CartaEscudo cartaescudo3_in = new CartaEscudo("Booms/Rotativos", 2, 
        "A festa libera consumiveis exclusivos por um curto periodo de tempo. Custo energetico: 2; Escudo: 4", 4);
        CartaEscudo cartaescudo4_in = new CartaEscudo("C.A. (Comissao Acolhedora)", 1, 
        "A comissao acolhedora protege a festa de embriagados e criminosos sexuais. Custo energetico: 1; Escudo: 2", 2);

        //criação dos arrays que compõem o sistema de baralho
        ArrayList<Carta> pilha_compra = new ArrayList<>();
        ArrayList<Carta> mao_heroi = new ArrayList<>();
        ArrayList<Carta> pilha_descarte = new ArrayList<>();
        //adicionando as cartas criadas na pilha inicial de compra
        pilha_compra.add(cartadano1);
        pilha_compra.add(cartadano2);
        pilha_compra.add(cartadano3);
        pilha_compra.add(cartadano4);
        pilha_compra.add(cartadano5);
        pilha_compra.add(cartadano6);
        pilha_compra.add(cartaescudo1);
        pilha_compra.add(cartaescudo2);
        pilha_compra.add(cartaescudo3);
        pilha_compra.add(cartaescudo4);
        pilha_compra.add(cartaefeito1);
        pilha_compra.add(cartaefeito2);
        Collections.shuffle(pilha_compra);

        while (heroi.estaVivo() && inimigo.estaVivo()){
            //aqui, geramos um menu de visualização para o jogador com os métodos da classe Menu
            menu.menuInicial(heroi, inimigo);

            if (turno_heroi){ //caso seja a vez do heroi
                menu.menuJogador(heroi, inimigo, pilha_compra, mao_heroi, pilha_descarte, entrada, menu);

                //mandar as cartas não utilizadas para a pilha de descarte
                for (int l = 0; l < mao_heroi.size(); l++){
                    pilha_descarte.add(0, mao_heroi.get(l));
                }
                menu.notificar("FIM_TURNO_HEROI", menu);
                mao_heroi.clear();
                inimigo.restaurarEscudo();
                turno_heroi = false;
            }
            else { //turno do inimigo
                //usamos o artifício de random choice para o inimigo realizar uma ação (escolher uma das cartas)
                Random random2 = new Random();
                int numCarta = random2.nextInt( 12);
                if (numCarta == 0){
                    inimigo.atacar(heroi, cartadano1_in, menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 1){
                    inimigo.atacar(heroi, cartadano2_in, menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 2){
                    inimigo.atacar(heroi, cartadano3_in, menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 3){
                    inimigo.ganharEscudo(cartaescudo1_in.qtdEscudo());

                    System.out.println();
                    System.out.println(inimigo.pegaNome() + " se protegeu com " + 
                    cartaescudo1_in.pegaNome() + ", concedendo " + 
                    cartaescudo1_in.qtdEscudo() + " de escudo!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 4){
                    inimigo.ganharEscudo(cartaescudo2_in.qtdEscudo());

                    System.out.println();
                    System.out.println(inimigo.pegaNome() + " se protegeu com " + 
                    cartaescudo2_in.pegaNome() + ", concedendo " + 
                    cartaescudo2_in.qtdEscudo() + " de escudo!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 5){
                    inimigo.atacar(heroi, cartadano4_in, menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 6){
                    inimigo.atacar(heroi, cartadano5_in, menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 7){
                    inimigo.atacar(heroi, cartadano6_in, menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 8){
                    inimigo.ganharEscudo(cartaescudo3_in.qtdEscudo());

                    System.out.println();
                    System.out.println(inimigo.pegaNome() + " se protegeu com " + 
                    cartaescudo3_in.pegaNome() + ", concedendo " + 
                    cartaescudo3_in.qtdEscudo() + " de escudo!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 9){
                    inimigo.ganharEscudo(cartaescudo4_in.qtdEscudo());

                    System.out.println();
                    System.out.println(inimigo.pegaNome() + " se protegeu com " + 
                    cartaescudo4_in.pegaNome() + ", concedendo " + 
                    cartaescudo4_in.qtdEscudo() + " de escudo!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 10){
                    inimigo.aplicarEfeito("Investimento", cartaefeito1.qtdAcumulos(), inimigo, menu);

                    System.out.println();
                    System.out.println(inimigo.pegaNome() + " aplicou o efeito Investimento. Portanto, vai receber uma grana para Booms!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 11){
                    heroi.aplicarEfeito("Metanol", cartaefeito2.qtdAcumulos(), heroi, menu);

                    System.out.println();
                    System.out.println(inimigo.pegaNome() + " aplicou o efeito Metanol, infectando o calouro!");
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                menu.notificar("FIM_TURNO_INIMIGO", menu);
                heroi.restaurarEnergia();
                heroi.restaurarEscudo();
                turno_heroi = true;
            }
        }
        if (!heroi.estaVivo()){
            System.out.println("Voce perdeu! O bixao enlouqueceu! Nao sobrou nada...");
            System.out.println();
        }
        else if (!inimigo.estaVivo()){
            System.out.println("Parabens bixao! Voce conseguiu acabar com o hype da festa e manteve sua sanidade!");
            System.out.println();
        }
        System.out.println();
        System.out.println("JOGO ENCERRADO!");
        System.out.println();
        entrada.close();
    }
}