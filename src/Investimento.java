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
        //função vazia pois a força age no momento de ataque a partir do dano
    }
}