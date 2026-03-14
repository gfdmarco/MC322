public abstract class Entidade {
    protected String nome;
    protected int vida;
    protected int escudo;

    public Entidade(String nome, int vida, int escudo){
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

    public void restaurarEscudo(){
        //Método para zerar o escudo da entidade ao trocar turnos
        this.escudo = 0;
    }

    public void ganharEscudo(int escudo){
        this.escudo += escudo;
    }

    public boolean estaVivo(Entidade entidade){
        if (entidade.vida > 0){
            return true;
        }
        return false;
    }

    public String pegaNome(Entidade entidade){
        return nome;
    }

    public int qtdVida(Entidade entidade){
        return vida;
    }

    public int qtdEscudo(Entidade entidade){
        return escudo;
    }
}
