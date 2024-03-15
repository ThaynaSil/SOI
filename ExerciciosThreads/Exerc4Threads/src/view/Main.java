package view;

import controller.Sapo;

public class Main {
    public static void main(String[] args) {
        final int DISTANCIA_TOTAL = 100;
        final int NUM_SAPOS = 5;

        for (int i = 1; i <= NUM_SAPOS; i++) {
            Sapo sapo = new Sapo("Sapo " + i, DISTANCIA_TOTAL);
            sapo.start();
        }
    }
}
