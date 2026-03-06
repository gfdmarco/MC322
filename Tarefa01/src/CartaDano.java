public class CartaDano {
    private String nome;
    private int custo;
    private int dano; //atributo extra para saber quanto de dano a carta causa

    public CartaDano(String nome, int custo, int dano){
        this.nome = nome;
        this.custo = custo;
        this.dano = dano;
    }
    
    public void usar(Inimigo nome, int dano){
        nome.receberDano(dano);
        System.out.println(this.nome + " deu " + dano + " de dano na(o) " + nome);
    }
}
