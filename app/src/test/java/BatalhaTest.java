import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.ArrayList;

public class BatalhaTest {
    
    @Test 
    public void vitoriaHeroi(){
        ArrayList<Carta> pilha_compra = new ArrayList<>();
        ArrayList<Carta> mao_heroi = new ArrayList<>();
        ArrayList<Carta> pilha_descarte = new ArrayList<>();

        CartaDano c = new CartaDano("Ataque", 3, "Mata de uma vez", 10);
        Heroi h = new Heroi("Heroi1", 50, 0);
        Inimigo i = new Inimigo("Inimigo1", 8, 0);
        Menu m = new Menu();
        Batalha b = new Batalha(h, i);

        pilha_compra.add(c);
        //leitura de 1 para decidir utilizar a carta e 0 para utilizar a primeira carta da mao
        Scanner entrada = new Scanner("1\n0\n");

        boolean vitoria_heroi = b.combate(m, pilha_compra, mao_heroi, pilha_descarte, entrada, new ArrayList<>(), 
        new ArrayList<>(), new ArrayList<>());

        assertEquals(true, vitoria_heroi);
    }

    @Test 
    public void vitoriaInimigo(){
        CartaDano c = new CartaDano("Ataque", 3, "Mata de uma vez", 10);
        Heroi h = new Heroi("Heroi1", 8, 0);
        Inimigo i = new Inimigo("Inimigo1", 50, 0);
        Menu m = new Menu();

        i.atacar(h, c, m);

        assertEquals(false, h.estaVivo());
    }
}
