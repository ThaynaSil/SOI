package view;

import controller.FatorialIterativoController;
import controller.FatorialRecursivoController;

public class Main {
    public static void main(String[] args) {
        long numero = 10;

        FatorialRecursivoController threadRecursiva = new FatorialRecursivoController(numero);
        FatorialIterativoController threadIterativa = new FatorialIterativoController(numero);

        threadRecursiva.start();
        threadIterativa.start();
    }
}
