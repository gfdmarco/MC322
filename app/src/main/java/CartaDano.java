/**
 * Derivada da classe Carta, representa as cartas que causam dano.
 * Causa dano na vida ou escudo, caso exista, da entidade adversária.
 * Além dos atributos padrão de uma carta, possui o dano que a carta causa no adversário.
 * 
 */

public class CartaDano extends Carta{
    private int dano; //atributo extra para saber quanto de dano a carta causa

    public CartaDano(String nome, int custo, String descricao, int dano){
        super(nome, custo, descricao);
        this.dano = dano;
    }

    /**
     * Implementação da ação de usar a carta, para causar dano no adversário.
     */
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
            menu.notificar("ATAQUE_HEROI");
            
            int dano_total = this.dano + menu.qtd_danoExtra();
            inimigo.receberDano(dano_total);
            try{ 
                System.out.println("/////////////////////////////////////////////////////////////////////////");
                System.out.println("O calouro " + heroi.pegaNome() + " causou " + this.dano + " de dano no(a) " 
                + inimigo.pegaNome() + " com " + this.nome);
                System.out.println("/////////////////////////////////////////////////////////////////////////");
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                System.err.println("Pausa interrompida");
            }
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