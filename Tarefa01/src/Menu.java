import java.util.Scanner;

public class Menu {
    public static void menuInicial(Heroi heroi, Inimigo inimigo){
        System.out.println("Calouro " + heroi.pegaNome(heroi) + " VS " + inimigo.pegaNome(inimigo));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Calouro '" + heroi.pegaNome(heroi) + "' - Sanidade: " + heroi.qtdVida(heroi) + "/80");
        if (heroi.qtdEscudo(heroi) > 0){
            System.out.println("Protecao:" + heroi.qtdEscudo(heroi));
        }
        System.out.println("Festa do(a) '" + inimigo.pegaNome(inimigo) + "' - Hype: " + inimigo.qtdVida(inimigo) + "/70");
        if (inimigo.qtdEscudo(inimigo) > 0){
            System.out.println("Escudo:" + inimigo.qtdEscudo(inimigo));
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public static int menuDecisao(Heroi heroi, Inimigo inimigo, Scanner entrada){
        System.out.println("O bixao tem " + heroi.qtdEnergia(heroi) + "/4 de Energia para utilizar");
        System.out.println("Como voce deseja reagir ao(a) " + inimigo.pegaNome(inimigo) + "?");
        System.out.println("1 - Atacar (Carta de Dano)");
        System.out.println("2 - Se proteger (Carta de Escudo)");
        System.out.println("3 - Encerrar turno");
        System.out.println("E ai? Como o(a) " + heroi.pegaNome(heroi) + " reage? Digite: ");
        int leitura = entrada.nextInt();
        System.out.println();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        return leitura;
    }

    public static int menuDano(Heroi heroi, Inimigo inimigo, Scanner entrada, CartaDano carta1, CartaDano carta2, CartaDano carta3){
        System.out.println("Como voce deseja atacar a festa e enfraquece-la?");
        System.out.println("1 - " + carta1.pegaNome(carta1) + " (Custo: " + carta1.qtdCusto(carta1) + "; Dano: " + 
        carta1.qtdDano(carta1) + ")");
        System.out.println("2 - " + carta2.pegaNome(carta2) + " (Custo: " + carta2.qtdCusto(carta2) + "; Dano: " + 
        carta2.qtdDano(carta2) + ")");
        System.out.println("3 - " + carta3.pegaNome(carta3) + " (Custo: " + carta3.qtdCusto(carta3) + "; Dano: " + 
        carta3.qtdDano(carta3) + ")");
        System.out.println("Escolha: ");
        int leitura = entrada.nextInt();
        System.out.println();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        return leitura;
    }

    public static int menuEscudo(Heroi heroi, Inimigo inimigo, Scanner entrada, CartaEscudo carta1, CartaEscudo carta2){
        System.out.println("Como voce deseja se proteger da festas (receber escudo)?");
        System.out.println("1 - " + carta1.pegaNome(carta1) + " (Custo: " + carta1.qtdCusto(carta1) + "; Protecao: " + 
        carta1.qtdEscudo(carta1) + ")");
        System.out.println("2 - " + carta2.pegaNome(carta2) + " (Custo: " + carta2.qtdCusto(carta2) + "; Protecao: " + 
        carta2.qtdEscudo(carta2) + ")");
        int leitura = entrada.nextInt();
        System.out.println();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        return leitura;
    }
}
