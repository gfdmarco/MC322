public class Inimigo extends Entidade {
    
    public Inimigo(String nome, int vida, int escudo){
        super(nome, vida, escudo);
    }

    public void atacar(Heroi heroi, int dano){
        heroi.receberDano(dano);
    }
}