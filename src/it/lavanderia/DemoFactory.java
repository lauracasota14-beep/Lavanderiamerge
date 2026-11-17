package it.lavanderia;

import it.lavanderia.factory.CapoFactory;
import it.lavanderia.factory.TipoCapo;
import it.lavanderia.model.Capo;

public class DemoFactory {

    public static void esegui() {
        System.out.println("--- Factory ---");

        for (TipoCapo tipo : TipoCapo.values()) {
            Capo capo = CapoFactory.crea(tipo);
            System.out.println("Creato " + capo + " -> classe " + capo.getClass().getSimpleName());
        }
        System.out.println();
    }
}
