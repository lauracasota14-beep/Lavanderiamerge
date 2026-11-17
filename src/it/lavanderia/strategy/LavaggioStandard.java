package it.lavanderia.strategy;

import it.lavanderia.model.Capo;

public class LavaggioStandard implements StrategiaLavaggio {

    @Override
    public String getNome() {
        return "Standard";
    }

    @Override
    public double getCostoExtra() {
        return 0.0;
    }

    @Override
    public void lava(Capo capo) {
        System.out.println("  " + capo.getNome() + ": lavaggio in lavatrice a 40 gradi");
    }
}
