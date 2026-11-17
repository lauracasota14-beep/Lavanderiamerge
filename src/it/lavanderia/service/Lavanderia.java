package it.lavanderia.service;

import it.lavanderia.model.Ordine;
import java.util.ArrayList;
import java.util.List;

public class Lavanderia {

    // Conserva l'unica istanza della lavanderia.
    private static Lavanderia istanza;

    private final String nome = "LavaMerge";
    private final List<Ordine> ordini = new ArrayList<>();
    private int prossimoId = 1;

    // Privato: da fuori non si puo' usare new Lavanderia().
    private Lavanderia() {
        System.out.println(
            "[Lavanderia] Apertura della lavanderia " + nome
        );
    }

    // La prima volta crea l'oggetto, poi restituisce sempre quello.
    public static Lavanderia getInstance() {
        if (istanza == null) {
            istanza = new Lavanderia();
        }
        return istanza;
    }

    // Crea un ordine e gli assegna un numero progressivo.
    public Ordine nuovoOrdine(String cliente) {
        Ordine ordine = new Ordine(prossimoId, cliente);
        prossimoId++;
        ordini.add(ordine);
        return ordine;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public String getNome() {
        return nome;
    }
}