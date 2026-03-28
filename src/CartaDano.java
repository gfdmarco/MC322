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
            int dano_total = this.dano;
            menu.notificar("ATAQUE", menu);
            boolean temEfeito = false;
            for (int i = 0; i < heroi.pegaEfeitos().size(); i++){
                if (heroi.pegaEfeitos().get(i).pegaNome().equals("Investimento")){
                    dano_total += heroi.pegaEfeitos().get(i).acumulos;
                    temEfeito = true;
                }
            }
            inimigo.receberDano(dano_total);
            System.out.println();
            System.out.println("O calouro " + heroi.pegaNome() + " causou " + this.dano + " de dano no(a) " 
            + inimigo.pegaNome() + " com " + this.nome);
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