package cartas;
import cartas.Carta;
import entidades.Heroi;
import entidades.Inimigo;
import sistema.Menu;
/**
 * Representa uma carta jogável geral do jogo. 
 * Possui nome, custo e descrição e uma forma de uso de acordo com seu tipo.
 * 
 */

public abstract class Carta {
    protected String nome;
    protected int custo;
    protected String descricao;

    public Carta(String nome, int custo, String descricao){
        this.nome = nome;
        this.custo = custo;
        this.descricao = descricao;
    }

    /**
     * Determina a ação de usar uma carta conforme sua especificação, gastando energia.
     * Cada extensão que herda esta classe implementa este método.
     */
    public abstract void usar(Heroi heroi, Inimigo inimigo, Menu menu);
    
    public String pegaNome(){
        return nome;
    }

    public String pegaDescricao(){
        return descricao;
    }

    public int qtdCusto(){
        return custo;
    }

    /**
     * Executa a ação de melhorar uma carta que invocar o método.
     * A melhoria consiste em aumentar o dano, escudo ou efeito da carta na quantidade de seu custo energético.
     */
    public abstract void melhorar();
}