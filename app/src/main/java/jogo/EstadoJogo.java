package jogo;

import java.util.Scanner;
import java.util.ArrayList;

import entidades.Heroi;
import sistema.Menu;
import cartas.Carta;
import cartas.CartaDano;
import cartas.CartaEscudo;
import cartas.CartaEfeito;

/**
 * Representa o estado do jogo em dado momento.
 * O estado representa como está o herói, o menu de jogo, o baralho, as cartas do inimigo e a entrada para leituras.
 */
public class EstadoJogo {
    private Heroi heroi;
    private Menu menu;
    private ArrayList<Carta> pilhaCompra;
    private ArrayList<Carta> maoHeroi;
    private ArrayList<Carta> pilhaDescarte;
    private ArrayList<CartaDano> cartasDanoIn;
    private ArrayList<CartaEscudo> cartasEscudoIn;
    private ArrayList<CartaEfeito> cartasEfeito;
    private Scanner entrada;

    public EstadoJogo(Heroi heroi, Menu menu, ArrayList<Carta> pilhaCompra, ArrayList<Carta> maoHeroi, 
        ArrayList<Carta> pilhaDescarte, ArrayList<CartaDano> cartasDanoIn, ArrayList<CartaEscudo> cartasEscudoIn,
        ArrayList<CartaEfeito> cartasEfeito, Scanner entrada) {

        this.heroi = heroi;
        this.menu = menu;
        this.pilhaCompra = pilhaCompra;
        this.maoHeroi = maoHeroi;
        this.pilhaDescarte = pilhaDescarte;
        this.cartasDanoIn = cartasDanoIn;
        this.cartasEscudoIn = cartasEscudoIn;
        this.cartasEfeito = cartasEfeito;
        this.entrada = entrada;
    }

    public Heroi pegaHeroi() { 
        return heroi; 
    }
    public Menu pegaMenu() { 
        return menu; 
    }
    public ArrayList<Carta> pegaPilhaCompra() { 
        return pilhaCompra;
    }
    public ArrayList<Carta> pegaMaoHeroi() { 
        return maoHeroi; 
    }
    public ArrayList<Carta> pegaPilhaDescarte() { 
        return pilhaDescarte; 
    }
    public ArrayList<CartaDano> pegaCartasDanoIn() { 
        return cartasDanoIn; 
    }
    public ArrayList<CartaEscudo> pegaCartasEscudoIn() { 
        return cartasEscudoIn; 
    }
    public ArrayList<CartaEfeito> pegaCartasEfeito() { 
        return cartasEfeito; 
    }
    public Scanner pegaEntrada() { 
        return entrada; 
    }
}
