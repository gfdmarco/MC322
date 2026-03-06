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
        if (this.escudo > 0){
            if (dano >= this.escudo){
                this.vida -= (dano - this.escudo);
                this.escudo = 0;
            }
            else {
                this.escudo -= dano;
            }
        }
        else {
            this.vida -= dano;
        }
    }

    public void ganharEscudo(int escudo){
        this.escudo += escudo;
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

    public String pegaNome(Inimigo inimigo){
        return nome;
    }

    public int qtdVida(Inimigo inimigo){
        return vida;
    }

    public int qtdEscudo(Inimigo inimigo){
        return escudo;
    }
}
