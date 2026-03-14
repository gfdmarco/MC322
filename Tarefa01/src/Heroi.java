public class Heroi extends Entidade {
    private int energia;

    public Heroi(String nome, int vida, int escudo){
        super(nome, vida, escudo);
        this.energia = 4; //energia máxima (inicial)
    }

    public void restaurarEnergia(){
        this.energia = 4;
    }

    //toda vez que uma carta é utilizada, consome energia
    public void consomeEnergia(int custo_carta){
        this.energia -= custo_carta;
    }

    public int qtdEnergia(Heroi heroi){
        return energia;
    }
}
