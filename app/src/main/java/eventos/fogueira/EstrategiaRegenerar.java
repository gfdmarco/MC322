package eventos.fogueira;

import jogo.EstadoJogo;

public class EstrategiaRegenerar implements Estrategia {
    private EstadoJogo estado;

    public EstrategiaRegenerar(EstadoJogo estado){
        this.estado = estado;
    } 

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
