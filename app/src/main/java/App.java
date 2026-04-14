import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.tree.DefaultMutableTreeNode;

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

        /** Array que contém as cartas de ataque (dano) do inimigo. */
        ArrayList<CartaDano> cartas_dano_in = new ArrayList<>();

         /** Array que contém as cartas de defesa (escudo) do inimigo. */
        ArrayList<CartaEscudo> cartas_escudo_in = new ArrayList<>();

         /** Array que contém as cartas de efeito. */
        ArrayList<CartaEfeito> cartas_efeito = new ArrayList<>();

        /*Cartas de Efeito */
        CartaEfeito cartaefeito1 =  new CartaEfeito("Bolsa", 3, 
        "Para o calouro, recebe uma Bolsa da Fapesp. Para a festa, recebe investimento para Booms. Custo energetico: 3; Acumulo do Efeito: 3; Tipo: Investimento", "Investimento", 3);
        CartaEfeito cartaefeito2 = new CartaEfeito("Resenhoff", 2,
        "Fornecer a vodka Resenhoff, contaminada. Custo energetico: 2; Acumulo do Efeito: 3. Tipo: Metanol", "Metanol", 3);
        cartas_efeito.add(cartaefeito1);
        cartas_efeito.add(cartaefeito2);
        
        /*Herói (calouro):
        vida máxima: 50, escudo inicial: 0; */
        Heroi heroi = new Heroi(leitura, 80, 0);
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

        //NOVAS CARTAS (Tarefa 04)
        CartaDano cartadano7 = new CartaDano("Exposed nas redes", 3, 
        "Faz um post em diversas redes sociais difamando a festa e expondo podres! Custo energetico: 3; Dano: 11", 11);
        CartaEscudo cartaescudo5 = new CartaEscudo("Dormir na aula", 2, 
        "Voce descansa e se protege de ser convidado para as festas. Custo energetico: 2; Escudo: 6", 6);
        CartaEscudo cartaescudo6 = new CartaEscudo("Ficar offline", 3, 
        "Desliga Wi-Fi e dados moveis do celular, evitando que receba convites duvidosos!. Custo energetico: 3; Escudo: 10", 10);
        CartaEfeito cartaefeito3 = new CartaEfeito("Trote", 2, 
        "Distribuicao de bebidas duvidosas para o adversario!. Custo energetico: 2; Acumulo do Efeito: 2. Tipo: Metanol", "Metanol", 2);
        CartaEfeito cartaefeito4 = new CartaEfeito("PIX", 2, 
        "Recebe uma transacao financeira anonima como incentivo a batalha Custo energetico: 2; Acumulo do Efeito: 2. Tipo: Investimento", "Investimento", 2);
        cartas_efeito.add(cartaefeito3);
        cartas_efeito.add(cartaefeito4);


        /*Inimigo (festas universitárias):
        vida máxima: 40, escudo inicial: 0 */
        ArrayList<Inimigo> inimigos = Inicializacoes.iniciaInimigos();
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
        cartas_dano_in.add(cartadano1_in);
        cartas_dano_in.add(cartadano2_in);
        cartas_dano_in.add(cartadano3_in);
        cartas_dano_in.add(cartadano4_in);
        cartas_dano_in.add(cartadano5_in);
        cartas_dano_in.add(cartadano6_in);

        CartaEscudo cartaescudo1_in = new CartaEscudo("Open Bar", 3, 
        "A festa libera todas as bebidas de graca. Custo energetico: 3; Escudo: 5", 5);
        CartaEscudo cartaescudo2_in = new CartaEscudo("Presenca de segurancas", 1, 
        "A festa contrata segurancas para protecao da festa. Custo energetico: 1; Escudo: 3", 3);
        CartaEscudo cartaescudo3_in = new CartaEscudo("Booms/Rotativos", 2, 
        "A festa libera consumiveis exclusivos por um curto periodo de tempo. Custo energetico: 2; Escudo: 4", 4);
        CartaEscudo cartaescudo4_in = new CartaEscudo("C.A. (Comissao Acolhedora)", 1, 
        "A comissao acolhedora protege a festa de embriagados e criminosos sexuais. Custo energetico: 1; Escudo: 2", 2);
        cartas_escudo_in.add(cartaescudo1_in);
        cartas_escudo_in.add(cartaescudo2_in);
        cartas_escudo_in.add(cartaescudo3_in);
        cartas_escudo_in.add(cartaescudo4_in);

        //Criação dos arrays que compõem o sistema de baralho

        /** Lista que representa o deck principal, de onde novas cartas são compradas. */
        ArrayList<Carta> pilha_compra = new ArrayList<>();

        /** Lista que contém as cartas que o herói possui atualmente em mãos para jogar. */
        ArrayList<Carta> mao_heroi = new ArrayList<>();

        /** Lista para onde as cartas são enviadas após serem utilizadas ou descartadas. */
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
        //NOVAS CARTAS (Tarefa 04)
        pilha_compra.add(cartadano7);
        pilha_compra.add(cartaescudo5);
        pilha_compra.add(cartaescudo6);
        pilha_compra.add(cartaefeito3);
        pilha_compra.add(cartaefeito4);
        Collections.shuffle(pilha_compra);

        //criacao do mapa
        DefaultMutableTreeNode raiz = Inicializacoes.iniciaMapa(heroi, inimigos);
        //comecar na raiz, realizar a batalha inicial. após isso, perguntar pra onde ele quer ir.
        DefaultMutableTreeNode atual = raiz;
        System.out.println("Vamos ao jogo! Para a primeira fase, voce ira enfrentar o " + inimigos.get(0).pegaNome() + "!");
        System.out.println();
        System.out.println("// MAPA:  |");
        System.out.println("          V");
        System.out.println();
        System.out.println("Nivel 1 - " + inimigos.get(0).pegaNome());
        System.out.println();
        System.out.println("Nivel 2 - " + inimigos.get(1).pegaNome() + " || " + inimigos.get(2).pegaNome() + " || " + inimigos.get(3).pegaNome());
        System.out.println();
        System.out.println("Nivel 3 - " + inimigos.get(4).pegaNome() + " / " + inimigos.get(5).pegaNome() + " || " + inimigos.get(6).pegaNome()+ " / " + inimigos.get(7).pegaNome() + " || " + inimigos.get(8).pegaNome() + " / " + inimigos.get(9).pegaNome());
        System.out.println();
        
        //pausa entre as ações no terminal
        try{       
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.err.println("Pausa interrompida");
        }
        
        while (heroi.estaVivo() && atual != null){
            Batalha batalha = (Batalha) atual.getUserObject();
            if (atual == raiz){
                try {   
                    System.out.println("//////////////////////////");
                    System.out.println();    
                    System.out.println("Vamos ao primeiro combate!");
                    System.out.println();
                    System.out.println("//////////////////////////");
                    Thread.sleep(3000);
                }
                catch (InterruptedException e){
                    System.err.println("Pausa interrompida");
                }
            }
            if (batalha.combate(menu, pilha_compra, mao_heroi, pilha_descarte, entrada, 
                cartas_dano_in, cartas_escudo_in, cartas_efeito) == true){ //herói venceu
                
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
                        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
                        System.out.println("ERRO: numero invalido!");
                        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
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