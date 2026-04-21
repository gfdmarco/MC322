package efeitos;

import efeitos.Metanol;
import entidades.Heroi;
import entidades.Inimigo;
import entidades.Entidade;
import sistema.Menu;
/**
 * Derivada da classe Efeito, representa o efeito de Metanol.
 * Exerce uma função de dano extra ao final do turno da entidade, descontando um de acúmulo após isso.
 * O efeito perdura até que se esgote após os descontos sucessivos.
 * 
 */

public class Metanol extends Efeito { //analogo ao veneno
    
    public Metanol(String nome, Entidade dono, int acumulos){
        super(nome, dono, acumulos);
    }
    
    @Override
    public String getString(){
        return ("Efeito: " + nome + ", causa um dano extra da quantidade de acumulos no inimigo e perde um deste por turno" 
        + " ; Acumulos: " + acumulos);
    }

    /**
     * A partir do evento informado, o Metanol decide se deve agir ou não.
     * Depende se o evento/estado de batalha é de fim de turno e se o dono do efeito é o herói ou o inimigo.
     */
    @Override
    public void serNotificado(String evento, Menu menu){
        if (evento.equals("FIM_TURNO_HEROI") && dono instanceof Inimigo){
            this.dono.receberDano(this.acumulos);
            this.subtraiAcumulo();
        }
        if (evento.equals("FIM_TURNO_INIMIGO") && dono instanceof Heroi){
            this.dono.receberDano(this.acumulos);
            this.subtraiAcumulo();
        }
        if (this.acumulos == 0){
            menu.desinscrever(this);
            this.dono.pegaEfeitos().remove(this);
        }
    }
}
