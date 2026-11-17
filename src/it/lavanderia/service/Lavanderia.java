package it.lavanderia.service;

import it.lavanderia.model.Capo;
import it.lavanderia.model.Ordine;
import it.lavanderia.model.StatoOrdine;
import it.lavanderia.model.capi.Camicia;
import it.lavanderia.model.capi.Cappotto;
import it.lavanderia.model.capi.Jeans;
import it.lavanderia.model.capi.Piumone;
import it.lavanderia.observer.OrdineObserver;
import it.lavanderia.strategy.LavaggioASecco;
import it.lavanderia.strategy.LavaggioDelicato;
import it.lavanderia.strategy.LavaggioIgienizzante;
import it.lavanderia.strategy.LavaggioStandard;
import it.lavanderia.strategy.StrategiaLavaggio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// SINGLETON che usa anche STRATEGY (sceglie il programma di lavaggio)
// e OBSERVER (iscrive le notifiche agli ordini ed e' lei stessa un osservatore).
public class Lavanderia implements OrdineObserver {

    // Conserva l'unica istanza della lavanderia.
    private static Lavanderia istanza;

    private final String nome = "LavaMerge";
    private final List<Ordine> ordini = new ArrayList<>();
    private int prossimoId = 1;

    // STRATEGY: per ogni tipo di capo, il programma di lavaggio da usare.
    private final StrategiaLavaggio programmaPredefinito = new LavaggioStandard();
    private final Map<Class<? extends Capo>, StrategiaLavaggio> programmi = new HashMap<>();

    // Privato: da fuori non si puo' usare new Lavanderia().
    private Lavanderia() {
        System.out.println(
            "[Lavanderia] Apertura della lavanderia " + nome
        );
        programmi.put(Camicia.class, new LavaggioDelicato());
        programmi.put(Jeans.class, programmaPredefinito);
        programmi.put(Cappotto.class, new LavaggioASecco());
        programmi.put(Piumone.class, new LavaggioIgienizzante());
    }

    // La prima volta crea l'oggetto, poi restituisce sempre quello.
    public static Lavanderia getInstance() {
        if (istanza == null) {
            istanza = new Lavanderia();
        }
        return istanza;
    }

    // Crea un ordine e gli assegna un numero progressivo.
    // OBSERVER: la lavanderia si iscrive a ogni suo ordine per sapere quando e' pronto.
    public Ordine nuovoOrdine(String cliente) {
        Ordine ordine = new Ordine(prossimoId, cliente);
        prossimoId++;
        ordine.aggiungiOsservatore(this);
        ordini.add(ordine);
        return ordine;
    }

    // STRATEGY: la lavanderia sceglie il programma in base al tipo di capo.
    public StrategiaLavaggio scegliProgramma(Capo capo) {
        return programmi.getOrDefault(capo.getClass(), programmaPredefinito);
    }

    // Riceve i capi di un cliente e crea un ordine per ogni programma di lavaggio.
    // OBSERVER: le notifiche del cliente vengono iscritte a tutti i suoi ordini.
    public List<Ordine> riceviCapi(String cliente, List<Capo> capi, OrdineObserver... notifiche) {
        Map<StrategiaLavaggio, Ordine> ordiniPerProgramma = new LinkedHashMap<>();

        for (Capo capo : capi) {
            StrategiaLavaggio programma = scegliProgramma(capo);
            Ordine ordine = ordiniPerProgramma.get(programma);

            if (ordine == null) {
                ordine = nuovoOrdine(cliente);
                ordine.setStrategia(programma);
                for (OrdineObserver notifica : notifiche) {
                    ordine.aggiungiOsservatore(notifica);
                }
                ordiniPerProgramma.put(programma, ordine);
            }

            ordine.aggiungiCapo(capo);
        }

        return new ArrayList<>(ordiniPerProgramma.values());
    }

    // Lava un ordine con il suo programma: ogni cambio di stato avvisa gli osservatori.
    public void lava(Ordine ordine) {
        System.out.println(
            "Lavaggio ordine #" + ordine.getId() + " - programma " + ordine.getStrategia().getNome() + ":"
        );
        ordine.setStato(StatoOrdine.IN_LAVAGGIO);
        ordine.lava();
        ordine.setStato(StatoOrdine.PRONTO);
    }

    // OBSERVER: chiamato dagli ordini della lavanderia a ogni cambio di stato.
    @Override
    public void aggiorna(Ordine ordine) {
        if (ordine.getStato() == StatoOrdine.PRONTO) {
            System.out.println(
                "  [Lavanderia] Ordine #" + ordine.getId() + " pronto: va sul bancone del ritiro"
            );
        }
    }

    public List<Ordine> getOrdini() {
        return Collections.unmodifiableList(ordini);
    }

    public String getNome() {
        return nome;
    }
}
