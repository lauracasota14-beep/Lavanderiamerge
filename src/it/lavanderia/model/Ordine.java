package it.lavanderia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Un ordine della lavanderia: un cliente consegna uno o piu' capi da lavare.
 */
public class Ordine {

    private final int id;
    private final String cliente;
    private final List<Capo> capi = new ArrayList<>();
    private StatoOrdine stato = StatoOrdine.RICEVUTO;

    public Ordine(int id, String cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public void aggiungiCapo(Capo capo) {
        capi.add(capo);
    }

    public void setStato(StatoOrdine nuovoStato) {
        this.stato = nuovoStato;
        // Persona 4 (Observer): qui si avvisano gli osservatori del cambio di stato
    }

    public double getTotale() {
        double totale = 0;
        for (Capo capo : capi) {
            totale += capo.getPrezzoBase();
        }
        // Persona 3 (Strategy): qui si aggiunge il costo del programma di lavaggio
        return totale;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Capo> getCapi() {
        return capi;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    @Override
    public String toString() {
        return "Ordine #" + id + " di " + cliente + " - " + capi.size() + " capi - stato: " + stato
                + " - totale: " + String.format("%.2f", getTotale()) + " euro";
    }
}
