package eventos.fogueira;

import cartas.Carta;

public class EstrategiaMelhorar implements Estrategia {
    private Carta carta;

    public EstrategiaMelhorar(Carta carta){
        this.carta = carta;
    }

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
