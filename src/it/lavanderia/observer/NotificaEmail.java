package it.lavanderia.observer;

public class NotificaEmail {

    private final String indirizzo;

    public NotificaEmail(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public void aggiorna(Ordine ordine) {
        System.out.println("  [Email a " + indirizzo + "] Gentile " + ordine.getCliente()
                + ", il tuo ordine #" + ordine.getId() + " ora e' " + ordine.getStato());
    }
}
