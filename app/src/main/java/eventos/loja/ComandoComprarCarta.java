package eventos.loja;

import jogo.EstadoJogo;
import cartas.Carta;

public class ComandoComprarCarta implements Comando{
    private EstadoJogo estado;
    private Carta carta;
    private int preco;

    public ComandoComprarCarta(EstadoJogo estado, Carta carta, int preco){
        this.estado = estado;
        this.carta = carta;
        this.preco = preco;
    }

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
