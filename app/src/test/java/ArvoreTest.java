import org.junit.jupiter.api.Test;

import cartas.CartaDano;
import cartas.CartaEscudo;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

import entidades.Heroi;
import entidades.Inimigo;
import jogo.Inicializacoes;

public class ArvoreTest {
    
    @Test
    public void raizInicializada(){
        Heroi h = new Heroi("Heroi1", 50, 0, 50);

        ArrayList<CartaDano> cd_in = new ArrayList<>();
        ArrayList<CartaEscudo> ce_in = new ArrayList<>();

        CartaDano cd1_in = new CartaDano("Perder pontos de CR", 1, 
        "Faz o bixao perder pontos de coeficiente de rendimento. Custo energetico: 1; Dano: 5", 5);
        CartaDano cd2_in = new CartaDano("Ficar de Ressaca", 3, 
        "Nosso calouro acorda mal no dia seguinte. Custo energetico: 3; Dano: 10", 10);
        cd_in.add(cd1_in);
        cd_in.add(cd2_in);
        CartaEscudo ce1_in = new CartaEscudo("Open Bar", 3, 
        "A festa libera todas as bebidas de graca. Custo energetico: 3; Escudo: 5", 5);
        CartaEscudo ce2_in = new CartaEscudo("Presenca de segurancas", 1, 
        "A festa contrata segurancas para protecao da festa. Custo energetico: 1; Escudo: 3", 3);
        ce_in.add(ce1_in);
        ce_in.add(ce2_in);

        ArrayList<Inimigo> inimigos = Inicializacoes.iniciaInimigos(cd_in, ce_in);
        DefaultMutableTreeNode raiz = Inicializacoes.iniciaMapa(h, inimigos);
        assertNotNull(raiz);
        assertEquals(4, raiz.getChildCount());
    }

    @Test
    public void numeroNos(){
        Heroi h = new Heroi("Heroi1", 50, 0, 50);

        ArrayList<CartaDano> cd_in = new ArrayList<>();
        ArrayList<CartaEscudo> ce_in = new ArrayList<>();

        CartaDano cd1_in = new CartaDano("Perder pontos de CR", 1, 
        "Faz o bixao perder pontos de coeficiente de rendimento. Custo energetico: 1; Dano: 5", 5);
        CartaDano cd2_in = new CartaDano("Ficar de Ressaca", 3, 
        "Nosso calouro acorda mal no dia seguinte. Custo energetico: 3; Dano: 10", 10);
        cd_in.add(cd1_in);
        cd_in.add(cd2_in);
        CartaEscudo ce1_in = new CartaEscudo("Open Bar", 3, 
        "A festa libera todas as bebidas de graca. Custo energetico: 3; Escudo: 5", 5);
        CartaEscudo ce2_in = new CartaEscudo("Presenca de segurancas", 1, 
        "A festa contrata segurancas para protecao da festa. Custo energetico: 1; Escudo: 3", 3);
        ce_in.add(ce1_in);
        ce_in.add(ce2_in);

        ArrayList<Inimigo> inimigos = Inicializacoes.iniciaInimigos(cd_in, ce_in);
        DefaultMutableTreeNode raiz = Inicializacoes.iniciaMapa(h, inimigos);
        int qtdNos = 1; //raiz
        qtdNos += raiz.getChildCount();
        qtdNos += raiz.getChildAt(0).getChildCount();
        qtdNos += raiz.getChildAt(1).getChildCount();
        qtdNos += raiz.getChildAt(2).getChildCount();
        qtdNos += raiz.getChildAt(3).getChildCount();
        assertEquals(13, qtdNos);
    }
}
