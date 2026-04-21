import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import entidades.Inimigo;

public class InimigoTest {
    @Test
    public void danoAbsorvidoPorEscudo(){
        Inimigo i = new Inimigo("Inimigo1", 50, 10);
        i.receberDano(5);
        assertEquals(50, i.qtdVida());
        assertEquals(5, i.qtdEscudo());
    }

    @Test
    public void danoParcialComEscudo(){
        Inimigo i = new Inimigo("Inimigo2", 50, 10);
        i.receberDano(15);
        assertEquals(45, i.qtdVida());
        assertEquals(0, i.qtdEscudo());
    }

    @Test
    public void danoSemEscudo(){
        Inimigo i = new Inimigo("Inimigo3", 50, 0);
        i.receberDano(10);
        assertEquals(40, i.qtdVida());
        assertEquals(0, i.qtdEscudo());
    }

    @Test 
    public void vidaNaoFicaNegativa(){
        Inimigo i = new Inimigo("Inimigo4", 50, 0);
        i.receberDano(70);
        assertEquals(0, i.qtdVida());
    }

    @Test
    public void estaVivoComVida(){
        Inimigo i = new Inimigo("Inimigo5", 50, 0);
        assertEquals(true, i.estaVivo());
    }

    @Test
    public void estaVivoSemVida(){
        Inimigo i = new Inimigo("Inimigo6", 0, 0);
        assertEquals(false, i.estaVivo());
    }

    @Test 
    public void ganhaEscudo(){
        Inimigo i = new Inimigo("Inimigo7", 50, 0);
        i.ganharEscudo(10);
        assertEquals(50, i.qtdVida());
        assertEquals(10, i.qtdEscudo());
    }
}
