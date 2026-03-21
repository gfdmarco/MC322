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
    public void serNotificado(String evento){
        if (evento.equals("FIM_TURNO")){
            this.dono.receberDano(this.acumulos);
            this.acumulos--;
        }
        if (this.acumulos == 0){
            //Menu.desinscrever(this)
            this.dono.efeitos.remove(this);
        }
    }
}
