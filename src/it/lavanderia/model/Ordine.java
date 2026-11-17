package it.lavanderia.model;

import it.lavanderia.strategy.LavaggioStandard;
import it.lavanderia.strategy.StrategiaLavaggio;

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
    private StrategiaLavaggio strategia = new LavaggioStandard();

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
        totale += strategia.getCostoExtra() * capi.size();
        return totale;
    }

    public void setStrategia(StrategiaLavaggio strategia) {
        this.strategia = strategia;
    }

    public StrategiaLavaggio getStrategia() {
        return strategia;
    }

    public void lava() {
        for (Capo capo : capi) {
            strategia.lava(capo);
        }
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
