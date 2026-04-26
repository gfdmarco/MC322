package eventos.loja;

import jogo.EstadoJogo;
import cartas.Carta;

/**
 * Representa o comando de comprar carta que a loja precisa intermediar para o jogador.
 */
public class ComandoComprarCarta implements Comando{
    private EstadoJogo estado;
    private Carta carta;
    private int preco;

    /**
     * Construção a partir do estado, para saber como está o saldo do herói, a carta a ser comprada e o preço respectivo
     * para compra
     */
    public ComandoComprarCarta(EstadoJogo estado, Carta carta, int preco){
        this.estado = estado;
        this.carta = carta;
        this.preco = preco;
    }

    /**
     * Executa a compra de carta
     */
    @Override
    public void executar(){
        if (estado.pegaHeroi().qtdOuro() >= preco){
            estado.pegaHeroi().consomeOuro(preco);
            estado.pegaPilhaCompra().add(carta);
            System.out.println("==================================================================================");
            System.out.println("                            Carta comprada!");
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
