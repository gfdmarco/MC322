/**
 * Interface que define um observador no padrão Subscriber.
 * Qualquer classe que reaja a eventos do sistema implementa esta interface.
 */

public interface Subscriber {
    
    /**
     * Método chamado quando um evento ocorre no objeto monitorado.
     */
    public void serNotificado(String evento, Menu menu);
}
