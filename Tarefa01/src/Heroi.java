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

    public void receberDano(int dano, CartaEscudo nome){
        if (this.escudo > 0){
            if (dano >= this.escudo){
                int dano_extra = dano - this.escudo;
                this.vida -= dano_extra;
                System.out.println(nome + "acabou!");
                System.out.println(this.nome + " possui" + vida + "de vida");
            }
            else {
                this.escudo -= dano;
                System.out.println(nome + "possui apenas " + escudo + "pontos de escudo!");
            }
        }
        else {
            this.vida -= dano;
            System.out.println(this.nome + " recebeu " + dano + " de dano");
            System.out.println(this.nome + " possui" + vida + "de vida");
        }
    }

    public void ganharEscudo(int escudo, CartaEscudo nome){
        this.escudo += escudo;
        System.out.println(nome + "acaba de te conceder " + escudo + "pontos de escudo!");
    }

    public void restaurarEscudo(int escudo){
        //Método para zerar o escudo do herói ao trocar turnos
        this.escudo = 0;
        System.out.println("Escudo zerado");
    }

    public boolean estaVivo(Heroi heroi){
        if (heroi.vida > 0){
            return true;
        }
        System.out.println("Vitória do inimigo! Não sobrou nada pro bixão...");
        return false;
    }

    public void restauraEnergia(){
        this.energia = 4;
        System.out.println("Energia restaurada");
    }

    //toda vez que uma carta é utilizada, consome energia
    public void consomeEnergia(int custo_carta){
        this.energia -= custo_carta;
        System.out.println("Energia restante: " + energia);
    }
}
