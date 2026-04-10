import java.util.ArrayList;

public class Publisher {
     /**
     * Configura a lista de efeitos presentes no jogo, necessário ao padrão de design Observer de aplicação de efeitos.
     */
    private ArrayList<Efeito> subscribers = new ArrayList<>();

    /**
     * Adiciona um efeito à lista de efeitos em vigor no jogo
     */
    public void inscrever(Efeito efeito){
        subscribers.add(efeito);
    }

    /**
     * Remove um efeito da lista de efeitos em vigor no jogo
     */
    public void desinscrever(Efeito efeito){
        subscribers.remove(efeito);
    }

    /**
     * Notifica todos os efeitos em vigor no jogo sobre o estado da batalha para que seja verificado se esses devem agir.
     */
    public void notificar(String evento, Menu menu){
        //iteração em ordem reversa para evitar bug de remoção ao longo da iteração
        for (int i = subscribers.size() - 1; i >= 0; i--){
            subscribers.get(i).serNotificado(evento, menu);
        }
    }

    /**
     * Limpa a lista de subscribers
     */
    public void limpar(){
        subscribers.clear();
    }

    public ArrayList<Efeito> pegaSubscribers(){
        return subscribers;
    }
}
