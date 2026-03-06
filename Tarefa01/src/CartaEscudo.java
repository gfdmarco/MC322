public class CartaEscudo {
    private String nome;
    private int custo;
    private int escudo; //atributo extra para saber quanto de escudo a carta fornece

    public CartaEscudo(String nome, int custo, int escudo){
        this.nome = nome;
        this.custo = custo;
        this.escudo = escudo;
    }

    public void usar(Heroi heroi, int escudo, Heroi nome){
        heroi.ganharEscudo(escudo);
        System.out.println(this.nome + " deu " + escudo + " de escudo para o(a) " + nome);
    }
}
