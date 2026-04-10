import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CartaEscudoTest {

    @Test
    public void cartaForneceEscudo(){
        CartaEscudo c = new CartaEscudo("CartaEscudo1", 3, "Carta que da escudo", 10);
        Heroi h = new Heroi("Heroi1", 50, 0);
        Inimigo i = new Inimigo("Inimigo1", 30, 0);
        Menu m = new Menu();
        c.usar(h, i, m);
        assertEquals(50, h.qtdVida());
        assertEquals(10, h.qtdEscudo());
    }
}
