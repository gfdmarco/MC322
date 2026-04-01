/**
 * Derivada da classe Efeito, representa o efeito de Investimento.
 * Exerce uma função de dano extra, tal qual uma força, no momento de ataque.
 * O efeito perdura até o final do combate.
 * 
 */

public class Investimento extends Efeito { //analogo a força
    
    public Investimento(String nome, Entidade dono, int acumulos){
        super(nome, dono, acumulos);
    }
    
    @Override
    public String getString(){
        return ("Efeito: " + nome + ", aumenta o dano de ataque na quantidade de acumulos" 
        + " ; Acumulos: " + acumulos);
    }

    /**
     * A partir do evento informado, o Investimento decide se deve agir ou não.
     * Depende se o evento/estado de batalha é de ataque e se o dono do efeito é o herói ou o inimigo.
     */
    @Override
    public void serNotificado(String evento, Menu menu){
        if (evento.equals("ATAQUE_HEROI") && dono instanceof Heroi){
            menu.soma_danoExtra(this.acumulos);
        }
        if (evento.equals("ATAQUE_INIMIGO") && dono instanceof Inimigo){
            menu.soma_danoExtra(this.acumulos);
        }
    }
}