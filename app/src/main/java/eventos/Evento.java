package eventos;

import jogo.EstadoJogo;
import java.util.ArrayList;
import cartas.Carta;

public abstract class Evento {
    public abstract boolean iniciar(EstadoJogo estado, ArrayList<Carta> cartasExtras);
}
