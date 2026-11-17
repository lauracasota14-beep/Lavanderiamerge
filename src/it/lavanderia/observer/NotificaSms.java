package it.lavanderia.observer;

import it.lavanderia.model.Ordine;

public class NotificaSms implements OrdineObserver {

    private final String numero;

    public NotificaSms(String numero) {
        this.numero = numero;
    }

    @Override
    public void aggiorna(Ordine ordine) {
        System.out.println("  [SMS a " + numero + "] Ordine #" + ordine.getId()
                + ": nuovo stato " + ordine.getStato());
    }
}
