package jogo;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

import cartas.Carta;
import cartas.CartaDano;
import cartas.CartaEfeito;
import cartas.CartaEscudo;
import entidades.Heroi;
import entidades.Inimigo;
import jogo.Inicializacoes;
import eventos.batalha.Batalha;
import eventos.loja.Loja;
import eventos.escolha.Escolha;
import eventos.fogueira.Fogueira;

public abstract class Inicializacoes {

    /**
     * Constrói a estrutura hierárquica do mapa de batalhas do jogo utilizando uma árvore.
     * <p>O mapa define o caminho que o herói pode seguir, começando por uma batalha raiz 
     * que se ramifica em múltiplas fases e escolhas possíveis.</p>
     */
    public static DefaultMutableTreeNode iniciaMapa(Heroi heroi, ArrayList<Inimigo> inimigos){
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(0)));

        DefaultMutableTreeNode no1_fase1 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(1)));
        DefaultMutableTreeNode no2_fase1 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(2)));
        DefaultMutableTreeNode no3_fase1 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(3)));
        DefaultMutableTreeNode no4_fase1 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(4)));
        raiz.add(no1_fase1);
        raiz.add(no2_fase1);
        raiz.add(no3_fase1);
        raiz.add(no4_fase1);

        DefaultMutableTreeNode no1_fase2 = new DefaultMutableTreeNode(new Loja());
        DefaultMutableTreeNode no2_fase2 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(5)));
        no1_fase1.add(no1_fase2);
        no1_fase1.add(no2_fase2);

        DefaultMutableTreeNode no3_fase2 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(6)));
        DefaultMutableTreeNode no4_fase2 = new DefaultMutableTreeNode(new Fogueira());
        no2_fase1.add(no3_fase2);
        no2_fase1.add(no4_fase2);

        DefaultMutableTreeNode no5_fase2 = new DefaultMutableTreeNode(new Escolha());
        DefaultMutableTreeNode no6_fase2 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(7)));
        no3_fase1.add(no5_fase2);
        no3_fase1.add(no6_fase2);

        DefaultMutableTreeNode no7_fase2 = new DefaultMutableTreeNode(new Loja());
        DefaultMutableTreeNode no8_fase2 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(8)));
        no4_fase1.add(no7_fase2);
        no4_fase1.add(no8_fase2);

        return raiz;
    }

    /**
     * Inicializa e popula a lista principal de inimigos do jogo.
     * Este método cria instâncias específicas de {@link Inimigo} com atributos 
     * pré-definidos de nome, vida e escudo, organizando-os em uma listas para o combate.
     */
    public static ArrayList<Inimigo> iniciaInimigos(ArrayList<CartaDano> cartas_dano_in, ArrayList<CartaEscudo> cartas_escudo_in){
        ArrayList<Inimigo> inimigos = new ArrayList<>();
        Inimigo inimigo1 = new Inimigo("Integras", 25, 0);

        Inimigo inimigo2 = new Inimigo("Postinho", 34, 0);
        Inimigo inimigo3 = new Inimigo("After", 40, 0);
        Inimigo inimigo4 = new Inimigo("Embrev", 30, 0);
        Inimigo inimigo5 = new Inimigo("Metropoly", 32, 0);

        Inimigo inimigo6 = new Inimigo("FEA Fantasy", 60, 0);

        Inimigo inimigo7 = new Inimigo("Churras a Trois", 65, 0);

        Inimigo inimigo8 = new Inimigo("Mc Lovin", 70, 0);

        Inimigo inimigo9 = new Inimigo("Quintas Intencoes", 80, 0);

        Inimigo inimigoFinal = new Inimigo("Calourada", 100, 0);
        inimigos.add(inimigo1);
        inimigos.add(inimigo2);
        inimigos.add(inimigo3);
        inimigos.add(inimigo4);
        inimigos.add(inimigo5);
        inimigos.add(inimigo6);
        inimigos.add(inimigo7);
        inimigos.add(inimigo8);
        inimigos.add(inimigo9);
        inimigos.add(inimigoFinal);

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

        return inimigos;
    }

    public static void iniciaCartas(ArrayList<CartaEfeito> cartas_efeito, ArrayList<CartaDano> cartas_dano, 
        ArrayList<CartaEscudo> cartas_escudo, ArrayList<Carta> cartasExtrasEscolha, ArrayList<Carta> cartasExtrasBatalha, 
        ArrayList<Carta> cartasExtrasLoja) {
        
        /*Cartas de Efeito */
        CartaEfeito cartaefeito1 =  new CartaEfeito("Bolsa IC", 3, 
        "Para o calouro, recebe uma Bolsa da Fapesp. Para a festa, recebe investimento para Booms. Custo energetico: 3; Acumulo do Efeito: 3; Tipo: Investimento", "Investimento", 3);
        CartaEfeito cartaefeito2 = new CartaEfeito("Resenhoff", 2,
        "Fornecer a vodka Resenhoff, contaminada. Custo energetico: 2; Acumulo do Efeito: 3. Tipo: Metanol", "Metanol", 3);
        
        CartaDano cartadano1 = new CartaDano("Causar tempestade", 1, 
        "Gera uma grande chuva no local da festa. Custo energetico: 1; Dano: 5", 5);
        CartaDano cartadano2 = new CartaDano("Estudar: Lock-In", 3, 
        "O bixao foca 100% nos estudos e se torna um consumidor a menos. Custo energetico: 3; Dano: 10", 10);
        CartaDano cartadano3 = new CartaDano("Discar 190", 2, 
        "Liga para a policia e eles acabam com a festa. Custo energetico: 2; Dano: 8", 8);
        CartaDano cartadano4 = new CartaDano("Reclamar no Spotted", 2, 
        "Uma reclamacao anonima surge no spotted criticando a festa. Custo energetico: 2; Dano: 6", 6);
        
        CartaEscudo cartaescudo1 = new CartaEscudo("Ser apadrinhado", 2, 
        "Nosso calouro eh protegido por um veterano. Custo energetico: 2; Escudo: 5", 5);
        CartaEscudo cartaescudo2 = new CartaEscudo("Sair de um dos grupos do OXXO", 1, 
        "Se retira de onde rola as vendas de ingressos. Custo energetico: 1; Escudo: 3", 3);
        CartaEscudo cartaescudo3 = new CartaEscudo("Passar tempo em alguma entidade", 2, 
        "O bixao se aventura em entidades da computacao, aumentando suas softskills. Custo energetico: 2; Escudo: 4", 4);
        CartaEscudo cartaescudo4 = new CartaEscudo("Jogar Videogame", 1, 
        "Seguindo o estereotipo, o bixao passa a noite jogando Fuga dos Perigos Noturnos. Custo energetico: 1; Escudo: 2", 2);

        //NOVAS CARTAS (Tarefa 04) - PASSAMOS TRES DELAS PRA SECAO DE RECOMPENSAS DE BATALHA
        CartaEfeito cartaefeito3 = new CartaEfeito("Trote", 2, 
        "Distribuicao de bebidas duvidosas para o adversario! Custo energetico: 2; Acumulo do Efeito: 2. Tipo: Metanol", "Metanol", 2);
        CartaEfeito cartaefeito4 = new CartaEfeito("PIX", 2, 
        "Recebe uma transacao financeira anonima como incentivo a batalha. Custo energetico: 2; Acumulo do Efeito: 2. Tipo: Investimento", "Investimento", 2);
        
        CartaDano cartadanoExtra1 = new CartaDano("Hackear a caixa de som", 3, 
        "Usa habilidades computacionais para colocar musicas infantis na caixa de som da festa. Custo energetico: 3; Dano: 9", 9);
        CartaDano cartadanoExtra2 = new CartaDano("Boicotar a Cheers", 1, 
        "Um ataque cibernetico faz com que o app fique fora do ar por alguns minutos. Custo energetico: 1; Dano: 4", 4);
        CartaDano cartadanoExtra3 = new CartaDano("Exposed nas redes", 3, 
        "Faz um post em diversas redes sociais difamando a festa e expondo podres! Custo energetico: 3; Dano: 11", 11);
        CartaEscudo cartaescudoExtra1 = new CartaEscudo("Dormir na aula", 2, 
        "Voce descansa e se protege de ser convidado para as festas. Custo energetico: 2; Escudo: 6", 6);
        CartaEscudo cartaescudoExtra2 = new CartaEscudo("Ficar offline", 3, 
        "Desliga Wi-Fi e dados moveis do celular, evitando que receba convites duvidosos!. Custo energetico: 3; Escudo: 10", 10);
        
        CartaEscudo cartaescudoExtra3 = new CartaEscudo("Kit Bixo (Versao Cortesia)", 2,  
        "Nosso calouro veste o kit bixo para se encaixar melhor. Custo energetico: 2; Escudo: 5", 5);
        
        CartaEscudo cartaescudoExtra4 = new CartaEscudo("Kit Bixo (Versao Paga)", 2,  
        "Nosso calouro veste o kit bixo para se encaixar melhor. Custo energetico: 2; Escudo: 5", 5);
        CartaDano cartadanoExtra4 = new CartaDano("Entupir o banheiro", 3, 
        "Voce usa o banheiro de uma forma diferenciada, deixando em um estado horrivel. Custo Energetico: 3; Dano: 10", 10);
        CartaDano cartadanoExtra5 = new CartaDano("Usar spray de flatulencias", 4, 
        "Causa um cheiro intragavel na festa, afastando todos os clientes. Custo energetico: 4, Dano: 15", 15);
        CartaEfeito cartaefeitoExtra1 = new CartaEfeito("Bolsa Intercambio", 4, 
        "Vamos a Europa! Voce ganhara uma bolsa para estudar fora, afastado das festas! Custo energetico: 4; Acumulo do Efeito: 5", "Investimento", 5);
        
        cartasExtrasLoja.add(cartaescudoExtra4);
        cartasExtrasLoja.add(cartadanoExtra4);
        cartasExtrasLoja.add(cartadanoExtra5);
        cartasExtrasLoja.add(cartaefeitoExtra1);
        cartasExtrasEscolha.add(cartaescudoExtra3);
        cartasExtrasBatalha.add(cartadanoExtra1);
        cartasExtrasBatalha.add(cartadanoExtra2);
        cartasExtrasBatalha.add(cartadanoExtra3);
        cartasExtrasBatalha.add(cartaescudoExtra1);
        cartasExtrasBatalha.add(cartaescudoExtra2);
        cartas_efeito.add(cartaefeito1);
        cartas_efeito.add(cartaefeito2);
        cartas_efeito.add(cartaefeito3);
        cartas_efeito.add(cartaefeito4);
        cartas_dano.add(cartadano1);
        cartas_dano.add(cartadano2);
        cartas_dano.add(cartadano3);
        cartas_dano.add(cartadano4);
        cartas_escudo.add(cartaescudo1);
        cartas_escudo.add(cartaescudo2);
        cartas_escudo.add(cartaescudo3);
        cartas_escudo.add(cartaescudo4);
    }
}
