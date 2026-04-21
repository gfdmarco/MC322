import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;

import cartas.Carta;
import cartas.CartaDano;
import entidades.Heroi;
import entidades.Inimigo;
import sistema.Menu;
import jogo.Baralho;

public class BaralhoTest {

    @Test
    public void descarteMao(){
        ArrayList<Carta> mao_heroi = new ArrayList<>();
        ArrayList<Carta> pilha_descarte = new ArrayList<>();

        CartaDano c1 = new CartaDano("Carta1", 3, "Da dano", 5);
        CartaDano c2 = new CartaDano("Carta2", 1, "Da dano", 2);

        mao_heroi.add(c1);
        mao_heroi.add(c2);

        //acontece o uso... e depois vem o descarte
        for (int i = 0; i < mao_heroi.size(); i++){
            pilha_descarte.add(0, mao_heroi.get(i));
        }
        mao_heroi.clear();

        assertEquals(0, mao_heroi.size());
        assertEquals(2, pilha_descarte.size());
        assertEquals(c2, pilha_descarte.get(0));
        assertEquals(c1, pilha_descarte.get(1));
    }

    @Test 
    public void compraComMaisDe3Cartas(){  
        ArrayList<Carta> pilha_compra = new ArrayList<>();
        ArrayList<Carta> mao_heroi = new ArrayList<>();
        ArrayList<Carta> pilha_descarte = new ArrayList<>();

        CartaDano c1 = new CartaDano("Carta1", 3, "Da dano", 5);
        CartaDano c2 = new CartaDano("Carta2", 2, "Da dano", 4);
        CartaDano c3 = new CartaDano("Carta3", 2, "Da dano", 3);
        CartaDano c4 = new CartaDano("Carta4", 1, "Da dano", 2);

        pilha_compra.add(c1);
        pilha_compra.add(c2);
        pilha_compra.add(c3);
        pilha_compra.add(c4);

        Baralho.organizar(pilha_compra, mao_heroi, pilha_descarte);
        assertEquals(3, mao_heroi.size());
    }

    @Test
    public void compraCom3Cartas(){  
        ArrayList<Carta> pilha_compra = new ArrayList<>();
        ArrayList<Carta> mao_heroi = new ArrayList<>();
        ArrayList<Carta> pilha_descarte = new ArrayList<>();

        CartaDano c1 = new CartaDano("Carta1", 3, "Da dano", 5);
        CartaDano c2 = new CartaDano("Carta2", 2, "Da dano", 4);
        CartaDano c3 = new CartaDano("Carta3", 2, "Da dano", 3);

        pilha_compra.add(c1);
        pilha_compra.add(c2);
        pilha_compra.add(c3);

        Baralho.organizar(pilha_compra, mao_heroi, pilha_descarte);
        assertEquals(3, mao_heroi.size());
    }

    @Test 
    public void reciclagem(){
        ArrayList<Carta> pilha_compra = new ArrayList<>();
        ArrayList<Carta> pilha_descarte = new ArrayList<>();

        CartaDano c1 = new CartaDano("Carta1", 3, "Da dano", 5);
        CartaDano c2 = new CartaDano("Carta2", 2, "Da dano", 4);
        pilha_descarte.add(0, c1);
        pilha_descarte.add(0, c2);

        if (pilha_compra.size() == 0){
            Collections.shuffle(pilha_descarte);
            for (int i = 0; i < pilha_descarte.size(); i++){
                pilha_compra.add(pilha_descarte.get(i));
            }
            pilha_descarte.clear();
        }

        assertEquals(0, pilha_descarte.size());
        assertEquals(2, pilha_compra.size());
    }

    @Test 
    public void descarteUso(){
        ArrayList<Carta> mao_heroi = new ArrayList<>();
        ArrayList<Carta> pilha_descarte = new ArrayList<>();

        CartaDano c = new CartaDano("Carta1", 3, "Da dano", 5);
        Heroi h = new Heroi("Heroi1", 50, 0);
        Inimigo i = new Inimigo("Inimigo1", 8, 0);
        Menu m = new Menu();

        mao_heroi.add(c);
        c.usar(h, i, m);
        pilha_descarte.add(0, mao_heroi.get(0));
        mao_heroi.clear();

        assertEquals(0, mao_heroi.size());
        assertEquals(1, pilha_descarte.size());
    }
}
