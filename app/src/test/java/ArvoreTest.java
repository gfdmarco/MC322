import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

public class ArvoreTest {
    
    @Test
    public void raizInicializada(){
        Heroi h = new Heroi("Heroi1", 50, 0);
        ArrayList<Inimigo> inimigos = Inicializacoes.iniciaInimigos();
        DefaultMutableTreeNode raiz = Inicializacoes.iniciaMapa(h, inimigos);
        assertNotNull(raiz);
        assertEquals(3, raiz.getChildCount());
    }

    @Test
    public void numeroNos(){
        Heroi h = new Heroi("Heroi1", 50, 0);
        ArrayList<Inimigo> inimigos = Inicializacoes.iniciaInimigos();
        DefaultMutableTreeNode raiz = Inicializacoes.iniciaMapa(h, inimigos);
        int qtdNos = 1; //raiz
        qtdNos += raiz.getChildCount();
        qtdNos += raiz.getChildAt(0).getChildCount();
        qtdNos += raiz.getChildAt(1).getChildCount();
        qtdNos += raiz.getChildAt(2).getChildCount();
        assertEquals(10, qtdNos);
    }
}
