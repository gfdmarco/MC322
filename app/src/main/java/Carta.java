/**
 * Representa o conceito geral de uma carta jogável.
 * 
 * @param nome Título da carta
 * @param custo Custo em energia da carta
 * @param descricao Detalha melhor a ação que a carta realiza
 */

public abstract class Carta {
    protected String nome;
    protected int custo;
    protected String descricao;

    public Carta(String nome, int custo, String descricao){
        this.nome = nome;
        this.custo = custo;
        this.descricao = descricao;
    }
    
    public abstract void usar(Heroi heroi, Inimigo inimigo, Menu menu);
    
    public String pegaNome(){
        return nome;
    }

    public String pegaDescricao(){
        return descricao;
    }

    public int qtdCusto(){
        return custo;
    }
}