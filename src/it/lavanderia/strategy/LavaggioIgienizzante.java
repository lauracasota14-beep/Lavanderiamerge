package it.lavanderia.strategy;

import it.lavanderia.model.Capo;

public class LavaggioIgienizzante implements StrategiaLavaggio {

    @Override
    public String getNome() {
        return "Igienizzante";
    }

    @Override
    public double getCostoExtra() {
        return 2.5;
    }

    @Override
    public void lava(Capo capo) {
        System.out.println("  " + capo.getNome() + ": lavaggio a 90 gradi con igienizzante");
    }
}
