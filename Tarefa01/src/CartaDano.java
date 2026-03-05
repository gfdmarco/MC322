public class CartaDano {
    private String nome;
    private int custo;
    private int dano; //atributo extra para saber quanto de dano a carta causa

    public CartaDano(String nome, int custo, int dano){
        this.nome = nome;
        this.custo = custo;
        this.dano = dano;
    }
    
    public void usar(Inimigo inimigo, int dano){
        inimigo.receberDano(dano);
    }
}
