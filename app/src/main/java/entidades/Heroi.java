package entidades;
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
    private int ouro;

    public Heroi(String nome, int vida, int escudo, int vidaMax){
        super(nome, vida, escudo, vidaMax);
        this.energia = 4; //energia máxima (inicial)
        this.ouro = 0;
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

    /**
     * Consome uma certa quantidade de ouro do Herói, passada como parâmetro
     * @param gasto     representa a quantidade de ouro que será consumida
     */
    public void consomeOuro(int gasto){
        this.ouro -= gasto;
    }

    /**
     * Aumenta o ouro do Herói em certa quantidade, passada como parâmetro
     * @param ganho     repesenta a quantidade de aumento do ouro do Herói
     */
    public void ganhaOuro(int ganho){
        this.ouro += ganho;
    }

    public int qtdOuro(){
        return ouro;
    }

    /**
     * Regenera a vida do Herói. Para tal, ele recebe 20% da vida máxima (16 em relação aos 80 máximos)
     * Caso possua vida que somada a 16 ultrapasse 80, trunca-se a vida no valor máximo
     */
    public void regenerar(){
        this.receberVida((int)(0.2 * this.pegaVidaMax()));
    }

}