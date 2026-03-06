public class Heroi {
    private String nome;
    private int vida;
    private int escudo;
    private int energia;

    public Heroi(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
        this.energia = 4; //energia máxima (inicial)
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

    public void restaurarEscudo(){
        //Método para zerar o escudo do herói ao trocar turnos
        this.escudo = 0;
        System.out.println("Escudo zerado");
    }

    public boolean estaVivo(Heroi heroi){
        if (heroi.vida > 0){
            return true;
        }
        System.out.println("Vitória do inimigo! Não sobrou nada pro 'bixão'...");
        return false;
    }

    public void restaurarEnergia(){
        this.energia = 4;
        System.out.println("Energia restaurada");
    }

    //toda vez que uma carta é utilizada, consome energia
    public void consomeEnergia(int custo_carta){
        this.energia -= custo_carta;
        System.out.println("Energia restante: " + energia);
    }

    public String pegaNome(Heroi heroi){
        return nome;
    }

    public int qtdEnergia(Heroi heroi){
        return energia;
    }

    public int qtdVida(Heroi heroi){
        return vida;
    }

    public int qtdEscudo(Heroi heroi){
        return escudo;
    }
}
