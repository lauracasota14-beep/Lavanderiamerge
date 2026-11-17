package it.lavanderia.model;

/**
 * Le fasi che attraversa un ordine, dalla consegna al ritiro.
 */
public enum StatoOrdine {
    RICEVUTO,
    IN_LAVAGGIO,
    PRONTO,
    RITIRATO
}
