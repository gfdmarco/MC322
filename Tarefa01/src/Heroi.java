public class Heroi {
    private String nome;
    private int vida;
    private int escudo;
    private int energia;

    public Heroi(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
    }

    public void receberDano(int dano){
        if (this.escudo > 0){
            if (dano >= this.escudo){
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

    public void restaurarEscudo(int escudo){
        //Método para zerar o escudo do herói ao trocar turnos
        this.escudo = 0;
    }

    public boolean estaVivo(Heroi heroi){
        if (heroi.vida > 0){
            return true;
        }
        System.out.println("Vitória do inimigo! Não sobrou nada...");
        return false;
    }

    public void restauraEnergia(){
        this.energia = 4;
    }

    //toda vez que uma carta é utilizada, consome energia
    public void consomeEnergia(int custo_carta){
        this.energia -= custo_carta;
    }
}
