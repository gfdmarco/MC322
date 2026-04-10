import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

public abstract class Inicializacoes {
    public static DefaultMutableTreeNode iniciaMapa(Heroi heroi, ArrayList<Inimigo> inimigos){
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(0)));

        DefaultMutableTreeNode no1_fase1 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(1)));
        DefaultMutableTreeNode no2_fase1 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(2)));
        DefaultMutableTreeNode no3_fase1 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(3)));
        raiz.add(no1_fase1);
        raiz.add(no2_fase1);
        raiz.add(no3_fase1);

        DefaultMutableTreeNode no1_fase2 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(4)));
        DefaultMutableTreeNode no2_fase2 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(5)));
        no1_fase1.add(no1_fase2);
        no1_fase1.add(no2_fase2);

        DefaultMutableTreeNode no3_fase2 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(6)));
        DefaultMutableTreeNode no4_fase2 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(7)));
        no2_fase1.add(no3_fase2);
        no2_fase1.add(no4_fase2);

        DefaultMutableTreeNode no5_fase2 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(8)));
        DefaultMutableTreeNode no6_fase2 = new DefaultMutableTreeNode(new Batalha(heroi, inimigos.get(9)));
        no3_fase1.add(no5_fase2);
        no3_fase1.add(no6_fase2);

        return raiz;
    }

    public static ArrayList<Inimigo> iniciaInimigos(){
        ArrayList<Inimigo> inimigos = new ArrayList<>();
        Inimigo inimigo1 = new Inimigo("Integras", 25, 0);

        Inimigo inimigo2 = new Inimigo("Postinho", 34, 0);
        Inimigo inimigo3 = new Inimigo("After", 32, 0);
        Inimigo inimigo4 = new Inimigo("Embrev", 30, 0);

        Inimigo inimigo5 = new Inimigo("Cachaca as Bruxas", 60, 0);
        Inimigo inimigo6 = new Inimigo("FEA Fantasy", 75, 0);

        Inimigo inimigo7 = new Inimigo("Churras a Trois", 70, 0);
        Inimigo inimigo8 = new Inimigo("Mc Lovin", 80, 0);

        Inimigo inimigo9 = new Inimigo("Quintas Intencoes", 90, 0);
        Inimigo inimigo10 = new Inimigo("Calourada", 100, 0);
        inimigos.add(inimigo1);
        inimigos.add(inimigo2);
        inimigos.add(inimigo3);
        inimigos.add(inimigo4);
        inimigos.add(inimigo5);
        inimigos.add(inimigo6);
        inimigos.add(inimigo7);
        inimigos.add(inimigo8);
        inimigos.add(inimigo9);
        inimigos.add(inimigo10);

        return inimigos;
    }
}
