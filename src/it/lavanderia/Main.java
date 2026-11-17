package it.lavanderia;

import it.lavanderia.factory.CapoFactory;
import it.lavanderia.factory.TipoCapo;
import it.lavanderia.model.Capo;
import it.lavanderia.model.Ordine;
import it.lavanderia.observer.NotificaEmail;
import it.lavanderia.observer.NotificaSms;
import it.lavanderia.service.Lavanderia;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int NUMERO_CAPI = 10;

    public static void main(String[] args) {
        System.out.println("=== Lavanderia LavaMerge ===");
        System.out.println();

        // SINGLETON: l'unica lavanderia del programma.
        Lavanderia lavanderia = Lavanderia.getInstance();

        // FACTORY: 10 capi di tipo casuale, creati dalla factory.
        Random random = new Random();
        TipoCapo[] tipi = TipoCapo.values();
        List<Capo> capi = new ArrayList<>();
        for (int i = 0; i < NUMERO_CAPI; i++) {
            TipoCapo tipo = tipi[random.nextInt(tipi.length)];
            capi.add(CapoFactory.crea(tipo));
        }

        System.out.println("La cliente consegna " + capi.size() + " capi:");
        for (Capo capo : capi) {
            System.out.println("  " + capo);
        }
        System.out.println();

        // STRATEGY + OBSERVER: la lavanderia sceglie il programma per ogni capo
        // e iscrive le notifiche della cliente a tutti gli ordini.
        List<Ordine> ordini = lavanderia.riceviCapi(
            "Anna Gialli",
            capi,
            new NotificaSms("347 7654321"),
            new NotificaEmail("anna.gialli@example.com")
        );
        System.out.println(
            "La lavanderia crea " + ordini.size() + " ordini, uno per ogni programma di lavaggio."
        );
        System.out.println();

        for (Ordine ordine : ordini) {
            lavanderia.lava(ordine);
            System.out.println();
        }

        System.out.println("Riepilogo:");
        double totale = 0;
        for (Ordine ordine : ordini) {
            System.out.println("  " + ordine);
            totale += ordine.getTotale();
        }
        System.out.println("Totale da pagare: " + String.format("%.2f", totale) + " euro");

        System.out.println();
        System.out.println("=== Fine ===");
    }
}
