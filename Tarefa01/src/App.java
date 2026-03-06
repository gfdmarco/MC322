import java.util.Scanner;

public class App {
    //revisar o que precisa ser feito na tarefa a partir do pdf e chamar as classes. depois disso, testar
    public static void main(String[] args) {
        String leitura;
        boolean turno_heroi = true; //variável que determina se é a vez do herói jogar
        Scanner entrada = new Scanner(System.in);
        System.out.println("Seja bem vindo ao 'Fuga dos Perigos Noturnos' - Versão Unicamp!");
        System.out.println("Aqui, sua missão é enfrentar a tentação das festas universitárias! Se proteja!")
        System.out.println("Vamos criar o seu calouro! Para isso, dê um nome ao bixão: ");
        leitura = entrada.next();

        //INICIALIZAÇÃO
        //vida máxima: 80, escudo inicial: 0;
        Heroi heroi = new Heroi(leitura, 80, 0);
        //vida máxima: 40, escudo: 0 (inimigos não possuem escudo por enquanto)
        Inimigo inimigo = new Inimigo("Calourada", 40, 0);

        int versao = 1; //versão do grupo do OXXO, a ser incrementada a cada turno
        CartaDano cartadano1 = new CartaDano("Tempestade", 1, 5);
        CartaDano cartadano2 = new CartaDano("Estudar: Lock-In", 3, 10);
        CartaDano cartadano3 = new CartaDano("Discar 190", 2, 8);

        CartaEscudo cartaescudo1 = new CartaEscudo("Ajuda de Veterano", 2, 5);
        CartaEscudo cartaescudo2 = new CartaEscudo("Sair do grupo do OXXO" + versao, 1, 3);

        /*falta codar os consumos de energia com os ataques, além de restaurar o escudo a cada turno e 
        fazer a própria troca de turnos*/
    }
}
