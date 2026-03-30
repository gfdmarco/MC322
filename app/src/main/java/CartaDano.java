/**
 * Causa dano na vida ou escudo (se tiver) da entidade adversária
 * 
 * @param nome Nome da carta
 * @param custo Energia necessária para comprar uma carta
 * @param descricao Detalha melhor a ação que a carta realiza
 * @param dano Dano que a carta causa na entidade adversária
 */

public class CartaDano extends Carta{
    private int dano; //atributo extra para saber quanto de dano a carta causa

    public CartaDano(String nome, int custo, String descricao, int dano){
        super(nome, custo, descricao);
        this.dano = dano;
    }
    
    public void usar(Heroi heroi, Inimigo inimigo, Menu menu){
        //método de uso de carta para o herói
        if (heroi.qtdEnergia() - this.custo < 0){
            System.out.println();
            System.out.println("ERRO: Energia insuficiente! Escolha outra!");
            System.out.println();
        }
        else {
            heroi.consomeEnergia(this.custo);
            
            menu.reseta_danoExtra(); //para evitar acumular dano extra quando troca os turnos
            menu.notificar("ATAQUE_HEROI", menu);
            
            int dano_total = this.dano + menu.qtd_danoExtra();
            inimigo.receberDano(dano_total);
            System.out.println();
            System.out.println("O calouro " + heroi.pegaNome() + " causou " + this.dano + " de dano no(a) " 
            + inimigo.pegaNome() + " com " + this.nome);

            //apenas para printar o bonus
            boolean temEfeito = false;
            for (int i = 0; i < heroi.pegaEfeitos().size(); i++){
                if (heroi.pegaEfeitos().get(i).pegaNome().equals("Investimento")){
                    temEfeito = true;
                }
            }
            if (temEfeito == true){
                System.out.println();
                System.out.println("BOOST: voce possui o efeito Investimento, o que causou " + (dano_total - this.dano) + " de dano extra!");
                System.out.println("Total de dano: " + dano_total);
                System.out.println();
            }
            System.out.println();
        }
    }

    public int qtdDano(){
        return dano;
    }
}