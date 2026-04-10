import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartaDanoTest {

    @Test
    public void consumoEnergia(){
        CartaDano c = new CartaDano("CartaDano1", 3, "Carta que causa dano", 10);
        Heroi h = new Heroi("Heroi1", 50, 0);
        Inimigo i = new Inimigo("Inimigo1", 30, 0);
        Menu m = new Menu();
        c.usar(h, i, m);
        assertEquals(1, h.qtdEnergia());
    }

    @Test 
    public void cartaReduzVida(){
        CartaDano c = new CartaDano("CartaDano2", 3, "Carta que causa dano", 10);
        Heroi h = new Heroi("Heroi2", 50, 0);
        Inimigo i = new Inimigo("Inimigo2", 30, 0);
        Menu m = new Menu();
        c.usar(h, i, m);
        assertEquals(20, i.qtdVida());
    }

    @Test 
    public void energiaInsuficiente(){
        CartaDano c = new CartaDano("CartaDano3", 3, "Carta que causa dano", 10);
        Heroi h = new Heroi("Heroi3", 50, 0);
        Inimigo i = new Inimigo("Inimigo3", 30, 0);
        Menu m = new Menu();
        h.consomeEnergia(2);
        c.usar(h, i, m);
        assertEquals(2, h.qtdEnergia());
        assertEquals(50, h.qtdVida());
    }

}
