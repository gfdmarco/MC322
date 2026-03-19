public class CartaDano extends Carta{
    private int dano; //atributo extra para saber quanto de dano a carta causa

    public CartaDano(String nome, int custo, String descricao, int dano){
        super(nome, custo, descricao);
        this.dano = dano;
    }
    
    public void usar(Heroi heroi, Inimigo inimigo){
        //método de uso de carta para o herói
        if (heroi.qtdEnergia() - this.custo < 0){
            System.out.println();
            System.out.println("ERRO: Energia insuficiente! Escolha outra!");
            System.out.println();
        }
        else {
            heroi.consomeEnergia(this.custo);
            inimigo.receberDano(this.dano);
            System.out.println();
            System.out.println("O calouro " + heroi.pegaNome() + " causou " + this.dano + " de dano no(a) " 
            + inimigo.pegaNome() + " com " + this.nome);
            System.out.println();
        }
    }

    public int qtdDano(){
        return dano;
    }
}