import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import cartas.CartaEfeito;
import entidades.Heroi;
import entidades.Inimigo;
import sistema.Menu;

public class CartaEfeitoTest {

    @Test 
    public void aplicaInvestimento(){
        CartaEfeito c = new CartaEfeito("CartaEfeito1", 2, "Carta de efeito", 
        "Investimento", 2);
        Heroi h = new Heroi("Heroi1", 50, 0, 50);
        Inimigo i = new Inimigo("Inimigo1", 30, 0, 30);
        Menu m = new Menu();
        c.usar(h, i, m);
        assertEquals(1, h.pegaEfeitos().size());
        assertEquals("Investimento", h.pegaEfeitos().get(0).pegaNome());
        assertEquals(2, h.pegaEfeitos().get(0).qtdAcumulos());
    }

    @Test 
    public void aplicaMetanol(){
        CartaEfeito c = new CartaEfeito("CartaEfeito2", 2, "Carta de efeito", 
        "Metanol", 2);
        Heroi h = new Heroi("Heroi2", 50, 0, 50);
        Inimigo i = new Inimigo("Inimigo2", 30, 0, 30);
        Menu m = new Menu();
        c.usar(h, i, m);
        assertEquals(1, i.pegaEfeitos().size());
        assertEquals("Metanol", i.pegaEfeitos().get(0).pegaNome());
        assertEquals(2, i.pegaEfeitos().get(0).qtdAcumulos());
    }

    @Test
    public void acumulaEfeito(){
        CartaEfeito c1 = new CartaEfeito("CartaEfeito1", 2, "Carta de efeito", 
        "Investimento", 2);
        CartaEfeito c2 = new CartaEfeito("CartaEfeito2", 2, "Carta de efeito", 
        "Investimento", 3);
        Heroi h = new Heroi("Heroi1", 50, 0, 50);
        Inimigo i = new Inimigo("Inimigo1", 30, 0, 30);
        Menu m = new Menu();
        c1.usar(h, i, m);
        c2.usar(h, i, m);
        assertEquals(5, h.pegaEfeitos().get(0).qtdAcumulos());
    }
}
