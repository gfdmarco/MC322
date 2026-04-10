/**
 * Derivada da classe Carta, representa as cartas que aplicam efeitos.
 * Representa cartas de efeitos que podem ser aplicados em entidades.
 * Além dos atribútos padrão, possui o nome do efeito contido na carta e os acúmulos que a carta oferece para esse efeito.
 * 
 */

public class CartaEfeito extends Carta {
    private String efeito;
    private int acumulos;

    public CartaEfeito(String nome, int custo, String descricao, String efeito, int acumulos){
        super(nome, custo, descricao);
        this.efeito = efeito;
        this.acumulos = acumulos;
    }
    
    /**
     * Implementação da ação de usar a carta, para aplicar efeito em si ou no adversário.
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
            if (efeito.equals("Investimento")){
                heroi.aplicarEfeito(efeito, acumulos, heroi, menu);
            }
            else if (efeito.equals("Metanol")){
                inimigo.aplicarEfeito(efeito, acumulos, inimigo, menu);
            }
            try{ 
                System.out.println();
                System.out.println("O calouro " + heroi.pegaNome() + " aplicou a carta de efeito " + this.nome);
                System.out.println("Efeito: " + efeito + "; Acumulos: " + acumulos);
                System.out.println();
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                System.err.println("Pausa interrompida");
            }
        }
    }

    public String pegaEfeito(){
        return efeito;
    }

    public int qtdAcumulos(){
        return acumulos;
    }
}
