/**
 * Representa um calouro, o qual batalha para acabar com o hype das festas universitárias.
 * Possui nome, vida (sanidade) e a quantidade de escudo que possui.
 *
 */

public class Heroi extends Entidade {
    /**
     * Representa a quantidade que se pode gastar para consumir cartas, realizando ações de jogo.
     */
    private int energia;

    public Heroi(String nome, int vida, int escudo){
        super(nome, vida, escudo);
        this.energia = 4; //energia máxima (inicial)
    }

    /**
     * Garante que nas trocas de turno a energia seja restaurada ao seu valor máximo.
     */
    public void restaurarEnergia(){
        this.energia = 4;
    }

    /**
     * Consome a energia toda vez que uma carta é utilizada.
     */
    public void consomeEnergia(int custo_carta){
        this.energia -= custo_carta;
    }

    public int qtdEnergia(){
        return energia;
    }
}