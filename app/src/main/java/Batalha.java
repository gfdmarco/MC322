import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Batalha {
    private Heroi heroi;
    private Inimigo inimigo;

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
                menu.notificar("FIM_TURNO_HEROI", menu);
                mao_heroi.clear();
                this.inimigo.restaurarEscudo();
                turno_heroi = false;
            }
            else { //turno do this.inimigo
                //usamos o artifício de random choice para o this.inimigo realizar uma ação (escolher uma das cartas)
                Random random2 = new Random();
                int numCarta = random2.nextInt(14);
                if (numCarta == 0){
                    this.inimigo.atacar(this.heroi, cartas_dano_in.get(0), menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 1){
                    this.inimigo.atacar(this.heroi, cartas_dano_in.get(1), menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 2){
                    this.inimigo.atacar(this.heroi, cartas_dano_in.get(2), menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 3){
                    this.inimigo.ganharEscudo(cartas_escudo_in.get(0).qtdEscudo());

                    try{
                        System.out.println();
                        System.out.println(this.inimigo.pegaNome() + " se protegeu com " + 
                        cartas_escudo_in.get(0).pegaNome() + ", concedendo " + 
                        cartas_escudo_in.get(0).qtdEscudo() + " de escudo!");
                        System.out.println();
                        System.out.println("///////////////////////////////////////////////////////////////////////////////////"); 
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e){
                        System.err.println("Pausa interrompida");
                    }
                }
                else if (numCarta == 4){
                    this.inimigo.ganharEscudo(cartas_escudo_in.get(1).qtdEscudo());

                    try{
                        System.out.println();
                        System.out.println(this.inimigo.pegaNome() + " se protegeu com " + 
                        cartas_escudo_in.get(1).pegaNome() + ", concedendo " + 
                        cartas_escudo_in.get(1).qtdEscudo() + " de escudo!");
                        System.out.println();
                        System.out.println("///////////////////////////////////////////////////////////////////////////////////"); 
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e){
                        System.err.println("Pausa interrompida");
                    }
                }
                else if (numCarta == 5){
                    this.inimigo.atacar(this.heroi, cartas_dano_in.get(3), menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 6){
                    this.inimigo.atacar(this.heroi, cartas_dano_in.get(4), menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 7){
                    this.inimigo.atacar(this.heroi, cartas_dano_in.get(5), menu);
                    System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                }
                else if (numCarta == 8){
                    this.inimigo.ganharEscudo(cartas_escudo_in.get(2).qtdEscudo());

                    try{
                        System.out.println();
                        System.out.println(this.inimigo.pegaNome() + " se protegeu com " + 
                        cartas_escudo_in.get(2).pegaNome() + ", concedendo " + 
                        cartas_escudo_in.get(2).qtdEscudo() + " de escudo!");
                        System.out.println();
                        System.out.println("///////////////////////////////////////////////////////////////////////////////////"); 
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e){
                        System.err.println("Pausa interrompida");
                    }
                }
                else if (numCarta == 9){
                    this.inimigo.ganharEscudo(cartas_escudo_in.get(3).qtdEscudo());

                    try{
                        System.out.println();
                        System.out.println(this.inimigo.pegaNome() + " se protegeu com " + 
                        cartas_escudo_in.get(3).pegaNome() + ", concedendo " + 
                        cartas_escudo_in.get(3).qtdEscudo() + " de escudo!");
                        System.out.println();
                        System.out.println("///////////////////////////////////////////////////////////////////////////////////"); 
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e){
                        System.err.println("Pausa interrompida");
                    }
                }
                else if (numCarta == 10){
                    this.inimigo.aplicarEfeito("Investimento", cartas_efeito.get(0).qtdAcumulos(), this.inimigo, menu);

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
                else if (numCarta == 11){
                    this.heroi.aplicarEfeito("Metanol", cartas_efeito.get(1).qtdAcumulos(), this.heroi, menu);
                    
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
                else if (numCarta == 12){
                    this.heroi.aplicarEfeito("Metanol", cartas_efeito.get(3).qtdAcumulos(), this.heroi, menu);
                    
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
                else if (numCarta == 13){
                    this.heroi.aplicarEfeito("Investimento", cartas_efeito.get(4).qtdAcumulos(), this.heroi, menu);
                    
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
                menu.notificar("FIM_TURNO_INIMIGO", menu);
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
