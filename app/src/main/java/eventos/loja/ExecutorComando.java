package eventos.loja;

/**
 * Representa o Invoker do comando, ou seja, quem utiliza os comandos. Neste caso, representa o intermédio da loja
 */
public class ExecutorComando {
    public void executar(Comando comando){
        comando.executar();
    }
}
