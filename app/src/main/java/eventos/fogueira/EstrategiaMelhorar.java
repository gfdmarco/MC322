package eventos.fogueira;

import cartas.Carta;

/**
 * Representa a estratégia de melhoria de carta. Portanto, representa como utilizar a fogueira para melhorá-la.
 */
public class EstrategiaMelhorar implements Estrategia {
    private Carta carta;
    /**
     * Construção a partir da carta a ser melhorada
     */
    public EstrategiaMelhorar(Carta carta){
        this.carta = carta;
    }

    /**
     * Implementação da execução da estratégia de melhoria de carta.
     */
    @Override
    public void executar(){
        System.out.println("=================================================================================="); 
        System.out.println("                 MELHORANDO CARTA CONFORME SEU CUSTO ENERGETICO...");
        System.out.println("==================================================================================");
        
        carta.melhorar();

        try{       
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            System.err.println("Pausa interrompida");
        }
    }
}
