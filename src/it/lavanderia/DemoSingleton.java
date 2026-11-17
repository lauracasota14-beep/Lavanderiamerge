package it.lavanderia;

import it.lavanderia.model.Capo;
import it.lavanderia.model.Ordine;
import it.lavanderia.service.Lavanderia;

public class DemoSingleton {

    public static void esegui() {
        System.out.println("--- Singleton ---");

        // Chiedo due volte la lavanderia.
        Lavanderia l1 = Lavanderia.getInstance();
        Lavanderia l2 = Lavanderia.getInstance();

        // Verifico che i due riferimenti puntino allo stesso oggetto.
        System.out.println(
            "l1 e l2 sono lo stesso oggetto? " + (l1 == l2)
        );

        // Creo un ordine tramite il primo riferimento.
        Ordine primo = l1.nuovoOrdine("Mario Rossi");
        primo.aggiungiCapo(new Capo("Maglione", 6.0));

        // Creo un altro ordine tramite il secondo riferimento.
        Ordine secondo = l2.nuovoOrdine("Giulia Bianchi");
        secondo.aggiungiCapo(new Capo("Gonna", 5.0));

        // Entrambi gli ordini sono nella stessa lavanderia.
        System.out.println(
            "Ordini registrati: " + l1.getOrdini().size()
        );

        for (Ordine ordine : l1.getOrdini()) {
            System.out.println("  " + ordine);
        }

        System.out.println();
    }
}