import java.util.ArrayList;

public abstract class Entidade {
    protected String nome;
    protected int vida;
    protected int escudo;
    protected ArrayList<Efeito> efeitos;

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
        int i;
        for (i = 0; i < efeitos.size(); i++){
            if (efeitos.get(i).pegaNome().equals(efeito)){
                contem = true;
            }
        }
        if (contem){
            efeitos.get(i).somaAcumulo(acumulos);
        }
        else {
            if (efeito.equals("Investimento")){
                Investimento investimento = new Investimento("Investimento", entidade, 1);
                efeitos.add(investimento);
                menu.inscrever(investimento);
            }
            else if (efeito.equals("Metanol")){
                Metanol metanol = new Metanol("Metanol", entidade, 1);
                efeitos.add(metanol);
                menu.inscrever(metanol);
            }
        }
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