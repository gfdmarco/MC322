import java.util.ArrayList;

/**
 * Representa qualquer personagem presente na batalha, calouros e festas universitárias
 * 
 * @param nome Nome da entidade
 * @param vida Vida atual da entidade
 * @param escudo Escudo atual da entidade
 */

public abstract class Entidade {
    protected String nome;
    protected int vida;
    protected int escudo;
    private ArrayList<Efeito> efeitos = new ArrayList<>();

    public Entidade(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
    }

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
    }

    public void restaurarEscudo(){
        //Método para zerar o escudo da entidade ao trocar turnos
        this.escudo = 0;
    }

    public void ganharEscudo(int escudo){
        this.escudo += escudo;
    }

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