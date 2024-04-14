package view;

import java.util.ArrayList;
import java.util.List;

import controller.CompetidorController;

public class Main {
    public static final Object lock = new Object();
    public static List<CompetidorController> vencedores = new ArrayList();

    public static void main(String[] args) {
        final int NUM_COMPETIDORES = 10;
        CompetidorController[] competidores = new CompetidorController[NUM_COMPETIDORES];

        for (int i = 0; i < NUM_COMPETIDORES; i++) {
            competidores[i] = new CompetidorController();
            competidores[i].start();
        }

        for (CompetidorController competidor : competidores) {
            try {
                competidor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        vencedores.sort((c1, c2) -> c2.getPontos() - c1.getPontos());

        System.out.println("Vencedores:");
        for (int i = 0; i < Math.min(3, vencedores.size()); i++) {
            CompetidorController vencedor = vencedores.get(i);
            int premio = (5 - i) * 1000;
            System.out.println("Posicao " + (i + 1) + ": Competidor " + vencedor.getIdCompetidor() + " - Premio: R$" + premio);
        }
    }
}
