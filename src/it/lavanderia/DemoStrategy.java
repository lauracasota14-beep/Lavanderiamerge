package it.lavanderia;

import it.lavanderia.model.Capo;
import it.lavanderia.model.Ordine;
import it.lavanderia.strategy.LavaggioASecco;
import it.lavanderia.strategy.LavaggioDelicato;
import it.lavanderia.strategy.LavaggioIgienizzante;
import it.lavanderia.strategy.LavaggioStandard;
import it.lavanderia.strategy.StrategiaLavaggio;

public class DemoStrategy {

    public static void esegui() {
        System.out.println("--- Strategy ---");

        Ordine ordine = new Ordine(100, "Luca Verdi");
        ordine.aggiungiCapo(new Capo("Camicia di seta", 4.0));
        ordine.aggiungiCapo(new Capo("Pantaloni", 5.0));

        StrategiaLavaggio[] strategie = {
                new LavaggioStandard(),
                new LavaggioDelicato(),
                new LavaggioASecco(),
                new LavaggioIgienizzante()
        };

        for (StrategiaLavaggio strategia : strategie) {
            ordine.setStrategia(strategia);
            System.out.println("Programma " + strategia.getNome()
                    + " -> totale " + String.format("%.2f", ordine.getTotale()) + " euro");
        }

        System.out.println("Il cliente sceglie il programma Delicato:");
        ordine.setStrategia(new LavaggioDelicato());
        ordine.lava();
        System.out.println();
    }
}
