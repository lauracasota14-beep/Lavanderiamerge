package it.lavanderia.observer;

import it.lavanderia.model.Ordine;

/**
 * OBSERVER: chi vuole essere avvisato quando un ordine cambia stato
 * implementa questa interfaccia e si iscrive all'ordine.
 */
public interface OrdineObserver {

    void aggiorna(Ordine ordine);
}
