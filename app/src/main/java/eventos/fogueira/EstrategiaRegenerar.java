package eventos.fogueira;

import jogo.EstadoJogo;

/**
 * Representa a estratégia de regeneração do Herói. Portanto, representa como utilizar a fogueira para regenerá-lo.
 */
public class EstrategiaRegenerar implements Estrategia {
    private EstadoJogo estado;

    /**
     * Construção a partir do estado de jogo, para consultar a situação do herói e alterar sua vida.
     */
    public EstrategiaRegenerar(EstadoJogo estado){
        this.estado = estado;
    } 

    /**
     * Implementação da estratégia de regeneração do Herói.
     */
    @Override
    public void executar(){
        System.out.println("=================================================================================="); 
        System.out.println("                     REGENERANDO 20% DA SANIDADE MAXIMA...");
        System.out.println("==================================================================================");
        
        int vidaAntes = estado.pegaHeroi().qtdVida();
        estado.pegaHeroi().regenerar();
        int vidaDepois = estado.pegaHeroi().qtdVida();

        System.out.println("                Sanidade:" + vidaAntes + "  -->  " + vidaDepois);
        System.out.println("==================================================================================");
        
        try{       
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            System.err.println("Pausa interrompida");
        }
    }
}
