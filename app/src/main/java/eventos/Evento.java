package eventos;

import jogo.EstadoJogo;
import java.util.ArrayList;
import cartas.Carta;

/**
 * Representa um evento qualquer no mapa.
 */
public abstract class Evento {
    /**
     * Executa o evento.
     * @param estado        Estado de Jogo atual, que abrange os elementos imprescindíveis para o evento.
     * @param cartasExtras  cartasExtras oferecidas pelo evento, oferecidas conforme for o tipo do evento.
     */
    public abstract boolean iniciar(EstadoJogo estado, ArrayList<Carta> cartasExtras);
}
