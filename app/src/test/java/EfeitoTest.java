import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EfeitoTest {

    @Test
    public void metanolNoHeroiNotificando(){
        Heroi h = new Heroi("Heroi1", 50, 0);
        Menu m = new Menu();

        h.aplicarEfeito("Metanol", 3, h, m);
        m.notificar("FIM_TURNO_INIMIGO");

        assertEquals(47, h.qtdVida());
    }

    @Test
    public void metanolNoInimigoNotificando(){
        Inimigo i = new Inimigo("Inimigo1", 50, 0);
        Menu m = new Menu();

        i.aplicarEfeito("Metanol", 3, i, m);
        m.notificar("FIM_TURNO_HEROI");

        assertEquals(47, i.qtdVida());
    }

    @Test
    public void investimentoNoHeroiNotificando(){
        Heroi h = new Heroi("Heroi2", 50, 0);
        Menu m = new Menu();

        h.aplicarEfeito("Investimento", 3, h, m);
        m.notificar("ATAQUE_HEROI");
        assertEquals(3, m.qtd_danoExtra());
    }

    @Test
    public void investimentoNoInimigoNotificando(){
        Inimigo i = new Inimigo("Inimigo1", 50, 0);
        Menu m = new Menu();

        i.aplicarEfeito("Investimento", 3, i, m);
        m.notificar("ATAQUE_INIMIGO");
        assertEquals(3, m.qtd_danoExtra());
    }

    @Test 
    public void naoAtacaNoMomentoErrado(){
        Heroi h = new Heroi("Heroi2", 50, 0);
        Menu m = new Menu();

        h.aplicarEfeito("Investimento", 3, h, m);
        m.notificar("FIM_TURNO_HEROI");
        m.notificar("ATAQUE_INIMIGO");
        assertEquals(0, m.qtd_danoExtra());
    }

    @Test
    public void remocaoEfeito(){
        Heroi h = new Heroi("Heroi3", 50, 0);
        Menu m = new Menu();

        h.aplicarEfeito("Metanol", 1, h, m);
        m.notificar("FIM_TURNO_INIMIGO");
        assertEquals(0, m.pegaSubscribers().size());
    }
}
