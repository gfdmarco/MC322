/**
 * Representa efeitos, positivos e negativos, que podem ser aplicados em entidades.
 * 
 * @param nome Nome do efeito
 * @param dono Entidade possuidora deste efeito
 * @param acumulos Total de acúmulos de um efeito
 */

public abstract class Efeito {
    //OBS: pensar em criar novos inimigos - instancias de inimigo ou classes mesmo
    protected String nome;
    protected Entidade dono;
    protected int acumulos;

    public Efeito(String nome, Entidade dono, int acumulos){
        this.nome = nome;
        this.dono = dono;
        this.acumulos = acumulos;
    }

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

    public abstract void serNotificado(String evento, Menu menu); //o efeito deve ser usado
}
