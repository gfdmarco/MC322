/**
 * Representa efeitos gerais que podem ser aplicados em entidades.
 * Possui nome, um dono que representa a entidade possuidora do efeito e a quantidade de acúmulos (intensidade) do efeito.
 * 
 */

public abstract class Efeito implements Subscriber{
    //OBS: pensar em criar novos inimigos - instancias de inimigo ou classes mesmo
    protected String nome;
    protected Entidade dono;
    /**
     * Representa a quantidade de intensidade do efeito acumulada.
     */
    protected int acumulos;

    public Efeito(String nome, Entidade dono, int acumulos){
        this.nome = nome;
        this.dono = dono;
        this.acumulos = acumulos;
    }

    /**
     * Método que oferece o nome, uma descrição breve e os acúmulos do efeito..
     */
    public abstract String getString();

    public String pegaNome(){
        return nome;
    }

    public Entidade pegaDono(){
        return dono;
    }

    public int qtdAcumulos(){
        return acumulos;
    }

    public void somaAcumulo(int soma){
        acumulos += soma;
    }

    public void subtraiAcumulo(){
        acumulos--;
    }

    /**
     * Método utilizado no padrão de design Observer para os efeitos receberem informação sobre o estado de batalha.
     * Com isso, age conforme necessário e exerce a função do efeito.
     * Para isso, recebe uma string que informa o estado de batalha (evento).
     */
    @Override
    public abstract void serNotificado(String evento, Menu menu);
}
