import java.util.Scanner;

public class Menu {
    public static void menuInicial(Heroi heroi, Inimigo inimigo){
        System.out.println("Calouro " + heroi.pegaNome(heroi) + " VS " + inimigo.pegaNome(inimigo));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Calouro '" + heroi.pegaNome(heroi) + "' - Vida: " + heroi.qtdVida(heroi) + "/80");
        if (heroi.qtdEscudo(heroi) > 0){
            System.out.println("Escudo:" + heroi.qtdEscudo(heroi));
        }
        System.out.println("Festa do(a) '" + inimigo.pegaNome(inimigo) + "' - Vida: " + inimigo.qtdVida(inimigo) + "/40");
        if (inimigo.qtdEscudo(inimigo) > 0){
            System.out.println("Escudo:" + inimigo.qtdEscudo(inimigo));
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public static int menuDecisao(Heroi heroi, Inimigo inimigo, Scanner entrada){
        System.out.println("O 'bixão' tem " + heroi.qtdEnergia(heroi) + "/4 de Energia para utilizar");
        System.out.println("Como você deseja reagir ao(à) " + inimigo.pegaNome(inimigo) + "?");
        System.out.println("1 - Usar Carta de Dano (Atacar)");
        System.out.println("2 - Usar Carta de Escudo (Proteger)");
        System.out.println("3 - Encerrar turno");
        System.out.println("E aí? Como o 'bixão' reage? Digite: ");
        int leitura = entrada.nextInt();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        return leitura;
    }

    public static int menuDano(Heroi heroi, Inimigo inimigo, Scanner entrada, CartaDano carta1, CartaDano carta2, CartaDano carta3){
        System.out.println("Qual das cartas de dano deseja utilizar?");
        System.out.println("1 - " + carta1.pegaNome(carta1));
        System.out.println("2 - " + carta2.pegaNome(carta2));
        System.out.println("3 - " + carta3.pegaNome(carta3));
        System.out.println("Escolha: ");
        int leitura = entrada.nextInt();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        return leitura;
    }

    public static int menuEscudo(Heroi heroi, Inimigo inimigo, Scanner entrada, CartaEscudo carta1, CartaEscudo carta2){
        System.out.println("Qual das cartas de escudo deseja utilizar?");
        System.out.println("1 - " + carta1.pegaNome(carta1));
        System.out.println("2 - " + carta2.pegaNome(carta2));
        int leitura = entrada.nextInt();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        return leitura;
    }
}
