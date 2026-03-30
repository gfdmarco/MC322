public class Investimento extends Efeito { //analogo a força
    
    public Investimento(String nome, Entidade dono, int acumulos){
        super(nome, dono, acumulos);
    }
    
    @Override
    public String getString(){
        return ("Efeito: " + nome + ", aumenta o dano de ataque na quantidade de acumulos" 
        + " ; Acumulos: " + acumulos);
    }

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