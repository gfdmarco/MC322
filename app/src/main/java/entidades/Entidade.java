package entidades;

import java.util.ArrayList;
import efeitos.Efeito;
import efeitos.Investimento;
import efeitos.Metanol;
import entidades.Entidade;
import sistema.Menu;

/**
 * Representa um personagem genérico presente na batalha (calouros e festas universitárias)
 * Possui nome, vida e escudo.
 *
 */

public abstract class Entidade {
    protected String nome;
    protected int vida;
    protected int escudo;
    /**
     * Representa a lista de efeitos aplicados à entidade.
     */
    private ArrayList<Efeito> efeitos = new ArrayList<>();

    public Entidade(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
    }

    /** 
     * Realiza a ação de perder vida devido a um ataque adversário. 
     * Para isso, verifica se a entidade possui escudo ou não e recebe o dano repassado.
     * 
     * @param dano Representa o dano repassado, que pode vir de uma carta de herói ou ataque do inimigo.
    */
    public void receberDano(int dano){
        if (this.escudo > 0){
            if (dano >= this.escudo){
                this.vida -= (dano - this.escudo);
                this.escudo = 0;
            }
            else {
                this.escudo -= dano;
            }
        }
        else {
            this.vida -= dano;
        }
        if (this.vida < 0){
            this.vida = 0;
        }
    }

    public void receberVida(int bonus){
        this.vida += bonus;
    }

    /**
     * Método para zerar o escudo da entidade ao trocar turnos, garantindo o fluxo de batalha.
     */
    public void restaurarEscudo(){
        this.escudo = 0;
    }

    public void ganharEscudo(int escudo){
        this.escudo += escudo;
    }

    /**
     * Aplica um efeito a partir do nome correspondente ao efeito, seus acúmulos e a entidade que o contém.
     * Assim como muitos outros métodos, recebe o Game Manager "Menu" para aplicar o design Observer.
     */
    public void aplicarEfeito(String efeito, int acumulos, Entidade entidade, Menu menu){
        boolean contem = false;
        if (entidade.efeitos != null){
            for (int i = 0; i < entidade.efeitos.size(); i++){
                if (entidade.efeitos.get(i).pegaNome().equals(efeito)){
                    contem = true;
                    entidade.efeitos.get(i).somaAcumulo(acumulos);
                    break;
                }
            }
        }
        if(!contem) {
            if (efeito.equals("Investimento")){
                Investimento investimento = new Investimento("Investimento", entidade, acumulos);
                entidade.efeitos.add(investimento);
                menu.inscrever(investimento);
            }
            else if (efeito.equals("Metanol")){
                Metanol metanol = new Metanol("Metanol", entidade, acumulos);
                entidade.efeitos.add(metanol);
                menu.inscrever(metanol);
            }
        }
    }

    public ArrayList<Efeito> pegaEfeitos(){
        return efeitos;
    }

    /**
     * Essencial para o fluxo de batalha, serve para verificar se a entidade está viva.
     * Necessário, pois o combate se encerra quando um dos lados deixa de estar vivo.
     */
    public boolean estaVivo(){
        if (vida > 0){
            return true;
        }
        return false;
    }

    public String pegaNome(){
        return nome;
    }

    public int qtdVida(){
        return vida;
    }

    public int qtdEscudo(){
        return escudo;
    }
}