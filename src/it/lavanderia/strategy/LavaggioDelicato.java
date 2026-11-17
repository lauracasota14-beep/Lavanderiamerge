package it.lavanderia.strategy;

import it.lavanderia.model.Capo;

public class LavaggioDelicato implements StrategiaLavaggio {

    @Override
    public String getNome() {
        return "Delicato";
    }

    @Override
    public double getCostoExtra() {
        return 1.5;
    }

    @Override
    public void lava(Capo capo) {
        System.out.println("  " + capo.getNome() + ": lavaggio a mano in acqua fredda");
    }
}
