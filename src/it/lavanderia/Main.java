package it.lavanderia;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Lavanderia LavaMerge ===");
        System.out.println();

        DemoStrategy.esegui();
        DemoFactory.esegui();

        System.out.println();
        System.out.println("=== Fine ===");
    }
}
