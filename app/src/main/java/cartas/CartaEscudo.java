package cartas;

import cartas.CartaEscudo;
import entidades.Heroi;
import entidades.Inimigo;
import sistema.Menu;

/**
 * Derivada da classe Carta, representa as cartas que aplicam escudo.
 * Concede escudo (vida adicional) ao herói.
 * Além dos atributos padrão, possui o escudo que a carta concede à entidade utilizadora.
 *
 */

public class CartaEscudo extends Carta{
    private int escudo; //atributo extra para saber quanto de escudo a carta fornece

    public CartaEscudo(String nome, int custo, String descricao, int escudo){
        super(nome, custo, descricao);
        this.escudo = escudo;
    }

    /**
     * Implementação da ação de usar a carta, para ganho próprio de escudo.
     */
    public void usar(Heroi heroi, Inimigo inimigo, Menu menu){
        //método de uso de carta para o herói
        if (heroi.qtdEnergia() - this.custo < 0){
            System.out.println("==================================================================================");
            System.out.println("                    Energia insuficiente! Escolha outra!");
            System.out.println("==================================================================================");
        }
        else {
            heroi.consomeEnergia(this.custo);
            heroi.ganharEscudo(this.escudo);
            try{ 
                System.out.println("==================================================================================");
                System.out.println("O calouro " + heroi.pegaNome() + " ganhou " + this.escudo + " de escudo com " 
                + this.nome);
                System.out.println("==================================================================================");
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                System.err.println("Pausa interrompida");
            }
        }
    }

    public int qtdEscudo(){
        return escudo;
    }

    @Override
    public void melhorar(){
        this.escudo += this.custo;
        this.descricao += "(MELHORIA: +" + this.custo + " de escudo)";
    }
}