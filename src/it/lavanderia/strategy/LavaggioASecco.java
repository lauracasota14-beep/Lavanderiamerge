package it.lavanderia.strategy;

import it.lavanderia.model.Capo;

public class LavaggioASecco implements StrategiaLavaggio {

    @Override
    public String getNome() {
        return "A secco";
    }

    @Override
    public double getCostoExtra() {
        return 4.0;
    }

    @Override
    public void lava(Capo capo) {
        System.out.println("  " + capo.getNome() + ": lavaggio a secco con solvente");
    }
}
