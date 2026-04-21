package eventos.batalha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import cartas.Carta;
import jogo.EstadoJogo;

public class Recompensas {
    public static void aplicar(EstadoJogo estado, ArrayList<Carta> cartasExtras){
        System.out.println("==================================================================================");
        System.out.println("                                    LOOT!");
        System.out.println("==================================================================================");
        System.out.println();
        System.out.println("Como recompensa da sua vitoria magistral, voce pode escolher entre receber duas coisas:");

        Random random1 = new Random();
        int min = 500;
        int max = 2000;
        int qtdOuro = random1.nextInt((max - min) + 1) + min;
        Scanner entrada = estado.pegaEntrada();
        
        System.out.println("1 - " + qtdOuro + " de Ouro");
        System.out.println("2 - Carta (a escolher)");
        int leitura;
        leitura = entrada.nextInt();

        if (leitura == 1){
            estado.pegaHeroi().ganhaOuro(qtdOuro);
            System.out.println(qtdOuro + "de Ouro foram adicionados ao seu bixao!");
        }
        else if (leitura == 2){
            Collections.shuffle(cartasExtras);

            while(true){
                System.out.println("Agora, escolha entre quais dessas cartas voce deseja:");
                System.out.println("1 - " + cartasExtras.get(0).pegaNome() + " - " + cartasExtras.get(0).pegaDescricao());
                System.out.println("2 - " + cartasExtras.get(1).pegaNome() + " - " + cartasExtras.get(1).pegaDescricao());
                System.out.println("3 - " + cartasExtras.get(2).pegaNome() + " - " + cartasExtras.get(2).pegaDescricao());
                System.out.println("4 - Pular escolha (Nenhuma interessa)");
                
                int leitura2;
                leitura2 = entrada.nextInt();
                if (leitura2 >= 1 && leitura2 <= 3){
                    estado.pegaPilhaCompra().add(cartasExtras.get(leitura2 - 1));
                    System.out.println("Carta escolhida adicionada ao baralho!");
                }
                else if (leitura2 == 4){
                    break;
                }
                else {
                    System.out.println("==================================================================================");
                    System.out.println("                    ERRO: numero invalido! Digite novamente");
                    System.out.println("==================================================================================");
                }
            }
        }
    }
}
