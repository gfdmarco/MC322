public class CartaEscudo {
    private String nome;
    private int custo;
    private int escudo; //atributo extra para saber quanto de escudo a carta fornece

    public CartaEscudo(String nome, int custo, int escudo){
        this.nome = nome;
        this.custo = custo;
        this.escudo = escudo;
    }

    public void usar(Heroi heroi){
        //método de uso de carta para o herói
        if (heroi.qtdEnergia(heroi) - this.custo < 0){
            System.out.println("Energia insuficiente! Escolha outra!");
        }
        else {
            heroi.consomeEnergia(this.custo);
            heroi.ganharEscudo(this.escudo);
        }
    }

    public String pegaNome(CartaEscudo carta){
        return nome;
    }

    public int qtdCusto(CartaEscudo carta){
        return custo;
    }

    public int qtdEscudo(CartaEscudo carta){
        return escudo;
    }
}
