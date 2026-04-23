package app;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.tree.DefaultMutableTreeNode;

import cartas.Carta;
import cartas.CartaDano;
import cartas.CartaEscudo;
import cartas.CartaEfeito;
import entidades.Heroi;
import entidades.Inimigo;
import eventos.batalha.Batalha;
import jogo.EstadoJogo;
import jogo.Inicializacoes;
import sistema.Menu;

/**
 * Representa a classe principal do jogo, a qual contém o método main, as instanciações dos objetos e o controle do jogo.
 */
public class App {
    
    /* OBS: muitas vezes neste jogo são utilizados trechos com Thread.sleep(x) para apenas acontecer uma pausa e espera
    durante as informações impressas ao jogador durante o uso do terminal */

    /**
     * A principal função do jogo, onde instancia-se os objetos e controla o que acontece na batalha.
     */
    public static void main(String[] args) {

        Menu menu = new Menu();
        String leitura;
        Scanner entrada = new Scanner(System.in);
        System.out.println();
        System.out.println("Seja bem vindo ao Fuga dos Perigos Noturnos - Versao Unicamp!");
        System.out.println("Aqui, sua missao eh enfrentar os perigos das festas universitarias! Se proteja!");
        System.out.println("Vamos criar o seu calouro! Para isso, crie um nome para o bixao: ");
        System.out.println();
        leitura = entrada.nextLine();
        System.out.println("------------------------------------------------------------------------------------");

        //INICIALIZAÇÃO

        /** Array que contém as cartas de ataque (dano) do heroi. */
        ArrayList<CartaDano> cartas_dano = new ArrayList<>();

         /** Array que contém as cartas de defesa (escudo) do heroi. */
        ArrayList<CartaEscudo> cartas_escudo = new ArrayList<>();

        /** Array que contém as cartas de efeito, compartilhada por heroi e inimigos. */
        ArrayList<CartaEfeito> cartas_efeito = new ArrayList<>();

        /** Array que contém as cartas de ataque (dano) dos inimigos. */
        ArrayList<CartaDano> cartas_dano_in = new ArrayList<>();

        /** Array que contém as cartas de defesa (escudo) dos inimigos. */
        ArrayList<CartaEscudo> cartas_escudo_in = new ArrayList<>();

        ArrayList<Carta> cartasExtrasEscolha = new ArrayList<>();
        ArrayList<Carta> cartasExtrasBatalha = new ArrayList<>();
        ArrayList<Carta> cartasExtrasLoja = new ArrayList<>();
        
        /*Herói (calouro):
        vida máxima: 50, escudo inicial: 0; */
        Heroi heroi = new Heroi(leitura, 80, 0);
        Inicializacoes.iniciaCartas(cartas_efeito, cartas_dano, cartas_escudo, cartasExtrasEscolha, 
            cartasExtrasBatalha, cartasExtrasLoja);

        /*Inimigo (festas universitárias):
        vida máxima: 40, escudo inicial: 0 */
        ArrayList<Inimigo> inimigos = Inicializacoes.iniciaInimigos(cartas_dano_in, cartas_escudo_in);

        //Criação dos arrays que compõem o sistema de baralho

        /** Lista que representa o deck principal, de onde novas cartas são compradas. */
        ArrayList<Carta> pilha_compra = new ArrayList<>();

        /** Lista que contém as cartas que o herói possui atualmente em mãos para jogar. */
        ArrayList<Carta> mao_heroi = new ArrayList<>();

        /** Lista para onde as cartas são enviadas após serem utilizadas ou descartadas. */
        ArrayList<Carta> pilha_descarte = new ArrayList<>();

        //adicionando as cartas criadas na pilha inicial de compra
        pilha_compra.add(cartas_dano.get(0));
        pilha_compra.add(cartas_dano.get(1));
        pilha_compra.add(cartas_dano.get(2));
        pilha_compra.add(cartas_dano.get(3));
        pilha_compra.add(cartas_escudo.get(0));
        pilha_compra.add(cartas_escudo.get(1));
        pilha_compra.add(cartas_escudo.get(2));
        pilha_compra.add(cartas_escudo.get(3));
        pilha_compra.add(cartas_efeito.get(0));
        pilha_compra.add(cartas_efeito.get(1));
        //NOVAS CARTAS (Tarefa 04) - PASSAMOS TRES DELAS PRA SECAO DE RECOMPENSAS DE BATALHA
        pilha_compra.add(cartas_efeito.get(2));
        pilha_compra.add(cartas_efeito.get(3));
        Collections.shuffle(pilha_compra);

        //criacao do mapa
        DefaultMutableTreeNode raiz = Inicializacoes.iniciaMapa(heroi, inimigos);
        //comecar na raiz, realizar a batalha inicial. após isso, perguntar pra onde ele quer ir.
        DefaultMutableTreeNode atual = raiz;
        System.out.println("Vamos ao jogo! Para a primeira fase, voce ira enfrentar o " + inimigos.get(0).pegaNome() + "!");
        System.out.println();
        System.out.println("==================================================================================");
        System.out.println("==================================================================================");
        System.out.println();
        System.out.println("                                   MAPA");
        System.out.println();
        System.out.println("==================================================================================");
        System.out.println("==================================================================================");
        System.out.println();
        System.out.println("                                     |");
        System.out.println("                                     V");
        System.out.println();
        System.out.println("Nivel 1 - " + inimigos.get(0).pegaNome());
        System.out.println();
        System.out.println("Nivel 2 - " + inimigos.get(1).pegaNome() + " || " + inimigos.get(2).pegaNome() + " || " + inimigos.get(3).pegaNome());
        System.out.println();
        System.out.println("Nivel 3 - " + inimigos.get(4).pegaNome() + " / " + inimigos.get(5).pegaNome() + " || " + inimigos.get(6).pegaNome()+ " / " + inimigos.get(7).pegaNome() + " || " + inimigos.get(8).pegaNome() + " / " + inimigos.get(9).pegaNome());
        System.out.println();
        System.out.println("==================================================================================");
        
        //pausa entre as ações no terminal
        try{       
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.err.println("Pausa interrompida");
        }

        EstadoJogo estado = new EstadoJogo(heroi, menu, pilha_compra, mao_heroi, pilha_descarte, cartas_dano_in,
            cartas_escudo_in, cartas_efeito, entrada);
        
        while (heroi.estaVivo() && atual != null){
            Batalha batalha = (Batalha) atual.getUserObject();
            if (atual == raiz){
                try {   
                    System.out.println("==================================================================================");
                    System.out.println();    
                    System.out.println("                            Vamos ao primeiro combate!");
                    System.out.println();
                    System.out.println("==================================================================================");
                    Thread.sleep(3000);
                }
                catch (InterruptedException e){
                    System.err.println("Pausa interrompida");
                }
            }
            if (batalha.iniciar(estado, cartasExtrasBatalha) == true){ //herói venceu
                
                //resetar energia e efeitos
                heroi.restaurarEnergia();
                heroi.pegaEfeitos().clear();
                batalha.pegaInimigo().pegaEfeitos().clear();
                menu.limpaEfeitos();

                if (atual.getChildCount() == 0){
                    atual = null;
                    break;
                }
                System.out.println("Agora, vamos a proxima fase! Escolha qual a proxima festa que queira enfrentar");
                for (int i = 0; i < atual.getChildCount(); i++){
                    System.out.println("Caminho " + (i + 1) + ": " + ((Batalha) ((DefaultMutableTreeNode) atual.getChildAt(i)).getUserObject()).pegaInimigo().pegaNome() +
                    ". Vida: " + ((Batalha) ((DefaultMutableTreeNode) atual.getChildAt(i)).getUserObject()).pegaInimigo().pegaVidaMax());
                }
                int leitura2;
                while (true){
                    System.out.println("Digite o numero do caminho: ");
                    leitura2 = entrada.nextInt();
                    if (leitura2 > 0 && leitura2 <= atual.getChildCount()){
                        atual = (DefaultMutableTreeNode) atual.getChildAt(leitura2 - 1);
                        break;
                    }
                    try{
                        System.out.println();
                        System.out.println("==================================================================================");
                        System.out.println("                               ERRO: numero invalido!");
                        System.out.println("==================================================================================");
                        System.out.println();
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e){
                        System.err.println("Pausa interrompida");
                    }
                }
            }
            else {
                break;
            }
        }
        if (heroi.estaVivo() && atual == null){
            System.out.println("Parabens, " + heroi.pegaNome() + "! Voce chegou ao fim do mapa e venceu o jogo!");
            System.out.println("Voce resistiu a todos os perigos das festas e agora consegue ter um semestre tranquilo!");
            System.out.println("Nem tao tranquilo assim, rs... agora voce tem que passar nas materias...");
        }

        System.out.println("**************************");
        System.out.println("    JOGO ENCERRADO!");
        System.out.println("**************************");
        entrada.close();
    }
}