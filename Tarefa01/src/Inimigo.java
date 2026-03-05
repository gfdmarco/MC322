public class Inimigo {
    private String nome;
    private int vida;
    private int escudo;

    public Inimigo(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
    }

    public void receberDano(int dano){
        this.vida -= dano;
    }

    public void atacar(Heroi heroi, int dano){
        heroi.receberDano(dano);
    }

    public boolean estaVivo(Inimigo inimigo){
        if (inimigo.vida > 0){
            return true;
        }
        System.out.println("Vitória do herói! Parabéns!");
        return false;
    }
}
