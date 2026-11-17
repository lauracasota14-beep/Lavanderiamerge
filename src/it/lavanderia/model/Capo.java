package it.lavanderia.model;

/**
 * Un capo di abbigliamento portato in lavanderia.
 */
public class Capo {

    private final String nome;
    private final double prezzoBase;

    public Capo(String nome, double prezzoBase) {
        this.nome = nome;
        this.prezzoBase = prezzoBase;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzoBase() {
        return prezzoBase;
    }

    @Override
    public String toString() {
        return nome + " (" + String.format("%.2f", prezzoBase) + " euro)";
    }
}
