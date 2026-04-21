import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import entidades.Heroi;
import efeitos.Investimento;
import efeitos.Metanol;
import sistema.Menu;

public class MenuTest {
    
    @Test
    public void inscricao(){
        Heroi h = new Heroi("Heroi1", 50, 0);
        Menu m = new Menu();

        Investimento i = new Investimento("Investimento1", h, 3);
        m.inscrever(i);
        assertEquals(i, m.pegaSubscribers().get(0));
    }

    @Test
    public void remocao(){
        Heroi h = new Heroi("Heroi2", 50, 0);
        Menu m = new Menu();

        Metanol mt = new Metanol("Metanol1", h, 1);
        m.inscrever(mt);
        m.desinscrever(mt);
        assertEquals(0, m.pegaSubscribers().size());
    }

    @Test 
    public void notificacao(){
        Heroi h = new Heroi("Heroi2", 50, 0);
        Menu m = new Menu();

        h.aplicarEfeito("Investimento", 3, h, m);
        m.notificar("ATAQUE_HEROI");
        assertEquals(3, m.qtd_danoExtra());
    }
}
