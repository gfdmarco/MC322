package jogo;
import java.util.Collections;
import java.util.List;
import cartas.Carta;
import jogo.Baralho;

public abstract class Baralho {
    /**
     * Organiza o baralho apresentado ao jogador, realizando as operações de descarte de cartas, embaralhamento 
     * e restauração quando esgotada a pilha de compra. O baralho é organizado até que se comprem 3 cartas.
     * @param pilha_compra      Baralho total do Herói.
     * @param mao_heroi      Cartas do baralho que compõem a mão de uso em determinado instante do Herói.
     * @param pilha_descarte     Cartas descartadas por uso ou falta deste após o fim do turno.
     */
    public static void organizar(List<Carta> pilha_compra, List<Carta> mao_heroi, List<Carta> pilha_descarte){
        try{
            System.out.println("Recebendo novas cartas e compondo nova mao...");
            System.out.println("OBS: voce recebe sempre 3 cartas por turno!");       
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            System.err.println("Pausa interrompida");
        }
        
        for (int carta_comprar = 0; carta_comprar < 3; carta_comprar++){
            //embaralhar
            if (pilha_compra.size() == 0){
                Collections.shuffle(pilha_descarte);
                for (int k = 0; k < pilha_descarte.size(); k++){
                    pilha_compra.add(0, pilha_descarte.get(k));
                }
                pilha_descarte.clear();
            }
            if (pilha_compra.size() > 0) {
                System.out.println();
                mao_heroi.add(pilha_compra.get(0)); //0 para pegar sempre o topo!
                System.out.println(pilha_compra.get(0).pegaNome() 
                + " foi adicionada a mao!");
                pilha_compra.remove(0);
            }
        }

        try{  
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.err.println("Pausa interrompida");
        }
    }
}
