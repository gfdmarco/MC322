import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaDano;
import cartas.CartaEfeito;
import cartas.CartaEscudo;
import entidades.Heroi;
import entidades.Inimigo;
import eventos.batalha.Batalha;
import jogo.EstadoJogo;
import sistema.Menu;

public class BatalhaTest {
    
    @Test 
    public void vitoriaHeroi(){
        ArrayList<Carta> pilha_compra = new ArrayList<>();
        ArrayList<Carta> mao_heroi = new ArrayList<>();
        ArrayList<Carta> pilha_descarte = new ArrayList<>();

        CartaDano c = new CartaDano("Ataque", 3, "Mata de uma vez", 10);
        Heroi h = new Heroi("Heroi1", 50, 0, 50);
        Inimigo i = new Inimigo("Inimigo1", 8, 0, 8);
        Menu m = new Menu();
        Batalha b = new Batalha(h, i);

        pilha_compra.add(c);

        Scanner entrada = new Scanner("1\n0\n2\n1\n"); 

        ArrayList<CartaDano> cd_in = new ArrayList<>();
        ArrayList<CartaEscudo> ce_in = new ArrayList<>();
        ArrayList<CartaEfeito> cef = new ArrayList<>();

        EstadoJogo estado = new EstadoJogo(h, m, pilha_compra, mao_heroi, pilha_descarte, cd_in, ce_in, cef, entrada);

        ArrayList<Carta> cExtraB = new ArrayList<>();
        cExtraB.add(new CartaDano("A",1,"",5));
        cExtraB.add(new CartaDano("B",1,"",5));
        cExtraB.add(new CartaDano("C",1,"",5));

        boolean vitoria_heroi = b.iniciar(estado, cExtraB);

        assertEquals(true, vitoria_heroi);
    }
    @Test 
    public void vitoriaInimigo(){
        CartaDano c = new CartaDano("Ataque", 3, "Mata de uma vez", 10);
        Heroi h = new Heroi("Heroi1", 8, 0, 8);
        Inimigo i = new Inimigo("Inimigo1", 50, 0, 50);
        Menu m = new Menu();

        i.atacar(h, c, m);

        assertEquals(false, h.estaVivo());
    }
}
