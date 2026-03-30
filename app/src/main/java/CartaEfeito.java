/**
 * Representa efeitos, positivos e negativos, que podem ser aplicados em entidades
 * 
 * @param nome Nome do efeito
 * @param custo Custo em energia da carta
 * @param descricao Detalha melhor a ação que a carta realiza
 * @param efeito O efeito que a carta realiza sobre a entidade
 * @param acumulos Total de acúmulos de um efeito
 */

public class CartaEfeito extends Carta {
    private String efeito;
    private int acumulos;

    public CartaEfeito(String nome, int custo, String descricao, String efeito, int acumulos){
        super(nome, custo, descricao);
        this.efeito = efeito;
        this.acumulos = acumulos;
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
            if (efeito.equals("Investimento")){
                heroi.aplicarEfeito(efeito, acumulos, heroi, menu);
            }
            else if (efeito.equals("Metanol")){
                inimigo.aplicarEfeito(efeito, acumulos, inimigo, menu);
            }
            System.out.println();
            System.out.println("O calouro " + heroi.pegaNome() + " aplicou a carta de efeito " + this.nome);
            System.out.println("Efeito: " + efeito + "; Acumulos: " + acumulos);
            System.out.println();
        }
    }

    public String pegaEfeito(){
        return efeito;
    }

    public int qtdAcumulos(){
        return acumulos;
    }
}
