/**
 * Concede escudo (vida adicional) à entidade que utilizar a carta
 * 
 * @param nome Nome da carta
 * @param custo Energia necessária para comprar uma carta
 * @param descricao Detalha melhor a ação que a carta realiza
 * @param escudo Escudo que a carta é capaz de conceder à entidade
 */

public class CartaEscudo extends Carta{
    private int escudo; //atributo extra para saber quanto de escudo a carta fornece

    public CartaEscudo(String nome, int custo, String descricao, int escudo){
        super(nome, custo, descricao);
        this.escudo = escudo;
    }

    public void usar(Heroi heroi, Inimigo inimigo, Menu menu){
        //método de uso de carta para o herói
        if (heroi.qtdEnergia() - this.custo < 0){
            System.out.println("Energia insuficiente! Escolha outra!");
        }
        else {
            heroi.consomeEnergia(this.custo);
            heroi.ganharEscudo(this.escudo);
            System.out.println();
            System.out.println("O calouro " + heroi.pegaNome() + " ganhou " + this.escudo + " de escudo com " 
            + this.nome);
            System.out.println();
        }
    }

    public int qtdEscudo(){
        return escudo;
    }
}