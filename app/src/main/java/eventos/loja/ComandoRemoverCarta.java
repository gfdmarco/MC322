package eventos.loja;

import jogo.EstadoJogo;

public class ComandoRemoverCarta implements Comando{
    private EstadoJogo estado;
    private int indiceCarta;
    private int preco;

    public ComandoRemoverCarta(EstadoJogo estado, int indiceCarta, int preco){
        this.estado = estado;
        this.indiceCarta = indiceCarta;
        this.preco = preco;
    }

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
