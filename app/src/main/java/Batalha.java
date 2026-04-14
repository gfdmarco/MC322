import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Representa um encontro de combate entre o herói e um inimigo específico.
 * Esta classe armazena os participantes e contém a lógica principal para 
 * processar os turnos e interações de cartas durante o duelo.
 */
public class Batalha {
    private Heroi heroi;
    private Inimigo inimigo;

    /**
     * Instancia uma nova batalha definindo os oponentes.
     * @param heroi O protagonista que será controlado pelo jogador.
     * @param inimigo O adversário que o herói deverá enfrentar nesta etapa.
     */
    public Batalha(Heroi heroi, Inimigo inimigo){
        this.heroi = heroi;
        this.inimigo = inimigo;
    }

    public Heroi pegaHeroi(){
        return heroi;
    }

    public Inimigo pegaInimigo(){
        return inimigo;
    }

    /**
     * Executa o ciclo principal de combate entre as entidades.
     * Este método gerencia a organização de turnos, o fluxo de cartas e a aplicação de efeitos e danos.
     * @param menu            Interface de usuário para exibição de opções e eventos.
     * @param pilha_compra    Deck de cartas disponíveis para serem distribuidas.
     * @param mao_heroi       Cartas atualmente disponíveis para uso do jogador.
     * @param pilha_descarte  Local para onde as cartas vão após serem utilizadas.
     * @param entrada         Scanner para leitura das decisões do jogador via terminal.
     * @param cartas_dano_in  Lista de cartas de ataque do inimigo.
     * @param cartas_escudo_in Lista de cartas de defesa do inimigo.
     * @param cartas_efeito   Lista de cartas de efeitos especiais.
     */
    public boolean combate(Menu menu, ArrayList<Carta> pilha_compra, ArrayList<Carta> mao_heroi, 
        ArrayList<Carta> pilha_descarte, Scanner entrada, ArrayList<CartaDano> cartas_dano_in, 
        ArrayList<CartaEscudo> cartas_escudo_in, ArrayList<CartaEfeito> cartas_efeito){
        
        boolean turno_heroi = true; //variável que determina se é a vez do herói jogar

        while (this.heroi.estaVivo() && this.inimigo.estaVivo()){
            //aqui, geramos um menu de visualização para o jogador com os métodos da classe Menu
            menu.menuInicial(this.heroi, this.inimigo);

            if (turno_heroi){ //caso seja a vez do this.heroi
                menu.menuJogador(this.heroi, this.inimigo, pilha_compra, mao_heroi, pilha_descarte, entrada, menu);

                //mandar as cartas não utilizadas para a pilha de descarte
                for (int l = 0; l < mao_heroi.size(); l++){
                    pilha_descarte.add(0, mao_heroi.get(l));
                }
                menu.notificar("FIM_TURNO_HEROI");
                mao_heroi.clear();
                this.inimigo.restaurarEscudo();
                turno_heroi = false;
            }
            else { //turno do inimigo
                //usamos o artifício de random choice para o inimigo realizar uma ação (escolher uma das cartas)
                Random random2 = new Random();
                int numCarta = random2.nextInt(14);
                boolean cartadano = false;
                boolean cartaescudo = false;
                boolean cartaefeito = false;

                if (numCarta >= 0 && numCarta <= 5){
                    cartadano = true;
                }
                else if (numCarta >= 6 && numCarta <= 9){
                    cartaescudo = true;
                }
                else if (numCarta >= 10 && numCarta <= 13){
                    cartaefeito = true;
                }

                if (cartadano){
                    this.inimigo.atacar(this.heroi, cartas_dano_in.get(numCarta), menu);
                    System.out.println();
                    System.out.println();
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (cartaescudo){
                    this.inimigo.ganharEscudo(cartas_escudo_in.get(numCarta - 6).qtdEscudo());

                    try{
                        System.out.println();
                        System.out.println(this.inimigo.pegaNome() + " se protegeu com " + 
                        cartas_escudo_in.get(numCarta - 6).pegaNome() + ", concedendo " + 
                        cartas_escudo_in.get(numCarta - 6).qtdEscudo() + " de escudo!");
                        System.out.println();
                        System.out.println("///////////////////////////////////////////////////////////////////////////////////"); 
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e){
                        System.err.println("Pausa interrompida");
                    }
                }
                else if (cartaefeito){
                    if (numCarta == 10 || numCarta == 13){
                        this.inimigo.aplicarEfeito("Investimento", cartas_efeito.get(numCarta - 10).qtdAcumulos(), this.inimigo, menu);

                        try{
                            System.out.println();
                            System.out.println(this.inimigo.pegaNome() + " aplicou o efeito Investimento. Portanto, vai receber uma forca!");
                            System.out.println();
                            System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                            Thread.sleep(2000);
                        }
                        catch (InterruptedException e){
                            System.err.println("Pausa interrompida");
                        }
                    }
                    else if (numCarta == 11 || numCarta == 12){
                        this.heroi.aplicarEfeito("Metanol", cartas_efeito.get(numCarta - 10).qtdAcumulos(), this.heroi, menu);
                    
                        try{
                            System.out.println();
                            System.out.println(this.inimigo.pegaNome() + " aplicou o efeito Metanol, infectando o calouro!");
                            System.out.println();
                            System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                            Thread.sleep(2000);
                        }
                        catch (InterruptedException e){
                            System.err.println("Pausa interrompida");
                        }
                    }
                    
                }
                menu.notificar("FIM_TURNO_INIMIGO");
                this.heroi.restaurarEnergia();
                this.heroi.restaurarEscudo();
                turno_heroi = true;
            }
        }
        if (!this.heroi.estaVivo()){
            System.out.println("Voce perdeu! O bixao enlouqueceu! Nao sobrou nada...");
            System.out.println("Agora voce esta sob o controle das festas... Cuidado!");
            System.out.println();
        }
        else if (!this.inimigo.estaVivo()){
            System.out.println("Parabens bixao! Voce conseguiu acabar com o hype da festa e manteve sua sanidade!");
            System.out.println();
        }
        System.out.println("**************************");
        System.out.println("    BATALHA ENCERRADA!");
        System.out.println("**************************");

        return this.heroi.estaVivo(); //retorna se o heroi venceu ou perdeu
    }
}
