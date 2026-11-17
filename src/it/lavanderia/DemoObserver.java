package it.lavanderia;

import it.lavanderia.model.Capo;
import it.lavanderia.model.Ordine;
import it.lavanderia.model.StatoOrdine;
import it.lavanderia.observer.NotificaEmail;
import it.lavanderia.observer.NotificaSms;

public class DemoObserver {

    public static void esegui() {
        System.out.println("--- Observer ---");

        Ordine ordine = new Ordine(200, "Sara Neri");
        ordine.aggiungiCapo(new Capo("Cappotto", 12.0));

        ordine.aggiungiOsservatore(new NotificaSms("333 1234567"));
        ordine.aggiungiOsservatore(new NotificaEmail("sara.neri@example.com"));

        System.out.println("La lavanderia mette l'ordine in lavaggio:");
        ordine.setStato(StatoOrdine.IN_LAVAGGIO);
        System.out.println("L'ordine e' pronto:");
        ordine.setStato(StatoOrdine.PRONTO);
        System.out.println();
    }
}