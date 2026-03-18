public abstract class Carta {
    protected String nome;
    protected int custo;
    protected String descricao;

    public Carta(String nome, int custo, String descricao){
        this.nome = nome;
        this.custo = custo;
        this.descricao = descricao;
    }
    
    public abstract void usar(Heroi heroi, Inimigo inimigo);
    
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
