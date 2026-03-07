public class CartaDano {
    private String nome;
    private int custo;
    private int dano; //atributo extra para saber quanto de dano a carta causa

    public CartaDano(String nome, int custo, int dano){
        this.nome = nome;
        this.custo = custo;
        this.dano = dano;
    }
    
    public void usar(Heroi heroi, Inimigo inimigo){
        //método de uso de carta para o herói
        if (heroi.qtdEnergia(heroi) - this.custo < 0){
            System.out.println();
            System.out.println("ERRO: Energia insuficiente! Escolha outra!");
            System.out.println();
        }
        else {
            heroi.consomeEnergia(this.custo);
            inimigo.receberDano(this.dano);
            System.out.println();
            System.out.println("O calouro " + heroi.pegaNome(heroi) + " causou " + this.dano + " de dano no(a) " 
            + inimigo.pegaNome(inimigo) + " com " + this.nome);
            System.out.println();
        }
    }
    
    public String pegaNome(CartaDano carta){
        return nome;
    }

    public int qtdCusto(CartaDano carta){
        return custo;
    }

    public int qtdDano(CartaDano carta){
        return dano;
    }
}
