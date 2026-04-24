package eventos.fogueira;

public class ContextoFogueira {
    private Estrategia estrategia;

    public void setEstrategia(Estrategia estrategia){
        this.estrategia = estrategia;
    }

    public void executar(){
        estrategia.executar();
    }
}
