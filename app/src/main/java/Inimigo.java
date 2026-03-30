/**
 * Representa as festas universitárias, que farão de tudo para acabar com a sanidade do calouro no jogo Fuga dos Perigos Noturnos - Versao Unicamp
 * 
 * @param nome Nome da festa
 * @param vida Hype da festa
 * @param escudo Representa o quanto de escudo a festa possui
 */

public class Inimigo extends Entidade {
    
    public Inimigo(String nome, int vida, int escudo){
        super(nome, vida, escudo);
    }

    public void atacar(Heroi heroi, CartaDano carta, Menu menu){
        menu.reseta_danoExtra(); //para evitar acumular dano extra quando troca os turnos
        menu.notificar("ATAQUE_INIMIGO", menu);
        int dano_total = carta.qtdDano() + menu.qtd_danoExtra();

        heroi.receberDano(dano_total);
        System.out.println();
        System.out.println();
        System.out.println(this.pegaNome() + " atacou com " + carta.pegaNome() 
        + ", causando " + carta.qtdDano() + " de dano no calouro!");
        System.out.println();

        //apenas para visualização do boost
        boolean temEfeito = false;
        for (int i = 0; i < this.pegaEfeitos().size(); i++){
            if (this.pegaEfeitos().get(i).pegaNome().equals("Investimento")){
                temEfeito = true;
            }
        }
        if (temEfeito == true){
            System.out.println();
            System.out.println("BOOST: o inimigo possui o efeito Investimento, o que causou " + (dano_total - carta.qtdDano()) + " de dano extra!");
            System.out.println("Total de dano: " + dano_total);
            System.out.println();
        }
        System.out.println();
    }
}