package eventos.loja;

import cartas.Carta;
import jogo.EstadoJogo;

public class ComandoRemoverCarta implements Comando{
    private EstadoJogo estado;
    private Carta carta;
    private int preco;

    public ComandoRemoverCarta(EstadoJogo estado, Carta carta, int preco){
        this.estado = estado;
        this.carta = carta;
        this.preco = preco;
    }

    @Override
    public void executar(){
        if (estado.pegaHeroi().qtdOuro() >= preco){
            estado.pegaHeroi().consomeOuro(preco);
            estado.pegaPilhaCompra().remove(carta);
        }
        else {
            System.out.println("==================================================================================");
            System.out.println("                            ERRO: ouro insuficiente!");
            System.out.println("==================================================================================");
        }
    }
}
