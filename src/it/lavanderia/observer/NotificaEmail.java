package it.lavanderia.observer;

import it.lavanderia.model.Ordine;

public class NotificaEmail implements OrdineObserver {

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
