import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import entidades.Heroi;

public class HeroiTest {
    @Test
    public void danoAbsorvidoPorEscudo(){
        Heroi h = new Heroi("Heroi1", 50, 10);
        h.receberDano(5);
        assertEquals(50, h.qtdVida());
        assertEquals(5, h.qtdEscudo());
    }

    @Test
    public void danoParcialComEscudo(){
        Heroi h = new Heroi("Heroi2", 50, 10);
        h.receberDano(15);
        assertEquals(45, h.qtdVida());
        assertEquals(0, h.qtdEscudo());
    }

    @Test
    public void danoSemEscudo(){
        Heroi h = new Heroi("Heroi3", 50, 0);
        h.receberDano(10);
        assertEquals(40, h.qtdVida());
        assertEquals(0, h.qtdEscudo());
    }

    @Test 
    public void vidaNaoFicaNegativa(){
        Heroi h = new Heroi("Heroi4", 50, 0);
        h.receberDano(70);
        assertEquals(0, h.qtdVida());
    }

    @Test
    public void estaVivoComVida(){
        Heroi h = new Heroi("Heroi5", 50, 0);
        assertEquals(true, h.estaVivo());
    }

    @Test
    public void estaVivoSemVida(){
        Heroi h = new Heroi("Heroi6", 0, 0);
        assertEquals(false, h.estaVivo());
    }

    @Test 
    public void ganhaEscudo(){
        Heroi h = new Heroi("Heroi7", 50, 0);
        h.ganharEscudo(10);
        assertEquals(50, h.qtdVida());
        assertEquals(10, h.qtdEscudo());
    }

    @Test
    public void restauraEnergia(){
        Heroi h = new Heroi("Heroi8", 50, 0);
        h.consomeEnergia(2);
        h.restaurarEnergia();
        assertEquals(4, h.qtdEnergia());
    }

    @Test
    public void consumoEnergia(){
        Heroi h = new Heroi("Heroi1", 50, 0);
        h.consomeEnergia(3);
        assertEquals(1, h.qtdEnergia());
    }
}
