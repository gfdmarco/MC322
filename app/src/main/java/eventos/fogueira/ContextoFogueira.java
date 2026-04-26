package eventos.fogueira;

/**
 * Representa o contexto de ação da fogueira, em que exige determinada estratégia de atividade no evento
 */
public class ContextoFogueira {
    private Estrategia estrategia;

    /**
     * Determina a estratégia que se encaixa em determinado contexto de ação da fogueira.
     * @param estrategia    Estrategia de ação correspondente
     */
    public void setEstrategia(Estrategia estrategia){
        this.estrategia = estrategia;
    }

    /**
     * Executa a estratégia de ação na fogueira.
     */
    public void executar(){
        estrategia.executar();
    }
}
