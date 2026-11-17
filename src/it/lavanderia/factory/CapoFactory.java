package it.lavanderia.factory;

import it.lavanderia.model.Capo;
import it.lavanderia.model.capi.Camicia;
import it.lavanderia.model.capi.Cappotto;
import it.lavanderia.model.capi.Jeans;
import it.lavanderia.model.capi.Piumone;

/**
 * FACTORY: chi usa la factory chiede "dammi un capo di questo tipo"
 * e non deve sapere quale classe concreta viene creata.
 */
public class CapoFactory {

    private CapoFactory() {
        // classe di sola utilita': non si istanzia
    }

    public static Capo crea(TipoCapo tipo) {
        switch (tipo) {
            case CAMICIA:
                return new Camicia();
            case JEANS:
                return new Jeans();
            case CAPPOTTO:
                return new Cappotto();
            case PIUMONE:
                return new Piumone();
            default:
                throw new IllegalArgumentException("Tipo di capo sconosciuto: " + tipo);
        }
    }
}
