public class Metanol extends Efeito { //analogo ao veneno
    
    public Metanol(String nome, Entidade dono, int acumulos){
        super(nome, dono, acumulos);
    }
    
    @Override
    public String getString(){
        return ("Efeito: " + nome + ", causa um dano extra da quantidade de acumulos no inimigo e perde um deste por turno" 
        + " ; Acumulos: " + acumulos);
    }

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
