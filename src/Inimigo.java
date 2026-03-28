public class Inimigo extends Entidade {
    
    public Inimigo(String nome, int vida, int escudo){
        super(nome, vida, escudo);
    }

    public void atacar(Heroi heroi, CartaDano carta, Menu menu){
        int dano_total = carta.qtdDano();
        menu.notificar("ATAQUE", menu);
        boolean temEfeito = false;
        for (int i = 0; i < this.pegaEfeitos().size(); i++){
            if (this.pegaEfeitos().get(i).pegaNome().equals("Investimento")){
                dano_total += this.pegaEfeitos().get(i).acumulos;
                temEfeito = true;
            }
        }
        heroi.receberDano(dano_total);
        System.out.println();
        System.out.println();
        System.out.println(this.pegaNome() + " atacou com " + carta.pegaNome() 
        + ", causando " + carta.qtdDano() + " de dano no calouro!");
        System.out.println();
        if (temEfeito == true){
            System.out.println();
            System.out.println("BOOST: o inimigo possui o efeito Investimento, o que causou " + (dano_total - carta.qtdDano()) + " de dano extra!");
            System.out.println("Total de dano: " + dano_total);
            System.out.println();
        }
        System.out.println();
    }
}