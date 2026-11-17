package it.lavanderia.strategy;

import it.lavanderia.model.Capo;

/**
 * STRATEGY: ogni programma di lavaggio e' una "strategia" diversa.
 * L'ordine non sa come si lava: lo chiede alla strategia che gli e' stata
 * assegnata,
 * e la strategia si puo' cambiare in qualsiasi momento.
 */
public interface StrategiaLavaggio {

    String getNome();

    double getCostoExtra();

    void lava(Capo capo);
}