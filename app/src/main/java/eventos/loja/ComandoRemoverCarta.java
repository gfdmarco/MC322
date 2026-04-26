package eventos.loja;

import jogo.EstadoJogo;

/**
 * Representa o comando de pagar para remover carta que a loja precisa intermediar para o jogador.
 */
public class ComandoRemoverCarta implements Comando{
    private EstadoJogo estado;
    private int indiceCarta;
    private int preco;

    /**
     * Construção a partir do estado, para saber como está o saldo do herói, a carta a ser removido e o preço respectivo
     * para remoção
     */
    public ComandoRemoverCarta(EstadoJogo estado, int indiceCarta, int preco){
        this.estado = estado;
        this.indiceCarta = indiceCarta;
        this.preco = preco;
    }

    /**
     * Executa a remoção da carta
     */
    @Override
    public void executar(){
        if (estado.pegaHeroi().qtdOuro() >= preco){
            estado.pegaHeroi().consomeOuro(preco);
            estado.pegaPilhaCompra().remove(indiceCarta);
            System.out.println("==================================================================================");
            System.out.println("                            Carta removida!");
            System.out.println("    Seu saldo agora corresponde a: " + estado.pegaHeroi().qtdOuro() + " de Ouro");
            System.out.println("==================================================================================");
        }
        else {
            System.out.println("==================================================================================");
            System.out.println("                            ERRO: ouro insuficiente!");
            System.out.println("==================================================================================");
        }
    }
}
