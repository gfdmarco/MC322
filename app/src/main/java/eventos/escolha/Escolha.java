package eventos.escolha;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import cartas.Carta;
import jogo.EstadoJogo;

/**
 * Representa o evento de Escolha, nomeado como Aventura pelo Campus.
 * Aqui, o jogador escolhe uma resposta a uma pequena história e sofre alguma consequência a partir desta resposta.
 * As consequências podem envolver benefícios ou não.
 */
public class Escolha extends eventos.Evento{
    /** 
     * Inicia uma situação de escolha para o usuário como evento no mapa.
     * @param estado        Estado de Jogo atual, que abrange os elementos imprescindíveis para a escolha.
     * @param cartasExtras  Cartas que podem ser concedidas como recompensa de determinada escolha.
    */
    @Override
    public boolean iniciar(EstadoJogo estado, ArrayList<Carta> cartasExtras){
        Scanner entrada = estado.pegaEntrada();
        Random random = new Random();
        int cenario = random.nextInt(2);
        System.out.println("=================================================================================="); 
        System.out.println("                   Seja bem-vindo(a) a Aventura pelo Campus!");
        System.out.println("=================================================================================="); 
        System.out.println();
        System.out.println("    Aqui voce vive uma aventura a partir de ESCOLHAS, que trazem consequencias!");
        System.out.println("                OBS: as consequencias podem ser boas ou nao...");
        System.out.println();
        System.out.println();
        if (cenario == 0){
            while (true){
                System.out.println("O(a) " + estado.pegaHeroi().pegaNome() + " esta saindo de um almoco no RU. No caminho, ");
                System.out.println("encontra veteranos, que comecam a te persuadir para ir em uma festa. Imperdivel!");
                System.out.println("Porem, no dia seguinte da festa, voce tem a P3 de Fisica! Voce nao pode reprovar!");
                System.out.println("1 - Vou a festa! Nao posso perder essa experiencia universitaria!");
                System.out.println("2 - Galera, nao irei! Preciso fugir do exame!");
                System.out.println("3 - Fuga nos veteranos!");
                System.out.println("Como voce responde ao convite? Escolha: ");
                int leitura;
                leitura = entrada.nextInt();
                if (leitura == 1){
                    estado.pegaHeroi().receberDano(5);
                    System.out.println("Voce aproveitou bastante! Mas, como consequencia de nao ter estudado,");
                    System.out.println("voce ficou de exame! Isso te deixou estressado e fez voce perder 5 de sanidade!");
                    break;
                }
                else if (leitura == 2){
                    estado.pegaHeroi().receberVida(5);
                    System.out.println("Voce perdeu uma grande resenha! Mas acalme-se, valeu a pena!");
                    System.out.println("Gracas a sua decisao, voce passou tirando 10 na P3 e sua sanidade aumentou em 5!");
                    System.out.println("Parabens por isso!");
                    break;
                }
                else if (leitura == 3){
                    estado.pegaHeroi().ganhaOuro(400);
                    System.out.println("Voce correu bastante deles! Isso te fez cansar, mas valeu a pena! ");
                    System.out.println("Voce evitou de ir a festa! Portanto, receba 400 de ouro!");
                    break;
                }
                else {
                    System.out.println("==================================================================================");
                    System.out.println("                    ERRO: numero invalido! Digite novamente");
                    System.out.println("==================================================================================");
                }
            }
        }
        else if (cenario == 1){
            while (true){
                System.out.println("Um veterano da atletica do seu curso te encontrou! Ele esta te oferecendo um Kit Bixo.");
                System.out.println("Voce pergunta o preco e ele diz estar de graca! Uau! Mas voce vai acreditar?");
                System.out.println("1 - Pegar o Kit Bixo (caso ja tenha, ganha o de outro ano para ter aquela moral de veterano experiente!)");
                System.out.println("2 - Apenas recusar ('Deve ser trote. Se eu disser que quero ele vai querer me fazer tomar shot, que pode ter metanol')");
                System.out.println("3 - Acusar que isso eh trote!");
                System.out.println("Como voce reage a esse convite maravilhoso? Escolha:");
                int leitura;
                leitura = entrada.nextInt();
                if (leitura == 1){
                    estado.pegaPilhaCompra().add(cartasExtras.get(0));
                    System.out.println();
                    System.out.println("Realmente tava de graca! Voce ganhou a carta de escudo Kit Bixo e ela agora compoe seu baralho!");
                    System.out.println("Informacoes da carta: Kit Bixo (Cortesia) - " + cartasExtras.get(0).pegaDescricao());
                    System.out.println();
                    break;
                }
                else if (leitura == 2){
                    estado.pegaHeroi().receberDano(2);
                    System.out.println();
                    System.out.println("Nao era trote! Voce perdeu a chance de ganhar a carta de escudo Kit Bixo (Cortesia)");
                    System.out.println("Com isso, voce ficou mais exposto, perdendo 2 de sanidade!");
                    System.out.println();
                    break;
                }
                else if (leitura == 3){
                    estado.pegaHeroi().aplicarEfeito("Metanol", 3, estado.pegaHeroi(), estado.pegaMenu());
                    System.out.println();
                    System.out.println("Nem era trote! Mas pela sua audacia o veterano te aplicou um trote e voce teve que tomar shots de Resenhoff!");
                    System.out.println("Com isso, voce foi infectado com o efeito Metanol, com 3 acumulos!");
                    System.out.println();
                    break;
                }
                else {
                    System.out.println("==================================================================================");
                    System.out.println("                    ERRO: numero invalido! Digite novamente");
                    System.out.println("==================================================================================");
                }
            }
        }
    
    try{       
            Thread.sleep(3000);
    }
    catch (InterruptedException e){
        System.err.println("Pausa interrompida");
    }

    return true;
    }
}
