package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import view.Main;

public class CompetidorController extends Thread{
    private static int competidoresCount = 0;
    private int id;
    private int pontos;

    public CompetidorController() {
        this.id = ++competidoresCount;
        this.pontos = 0;
    }

    public void run() {
        Random random = new Random();

        while (true) {
            int dado1 = random.nextInt(6) + 1;
            int dado2 = random.nextInt(6) + 1;

            synchronized (Main.lock) {
                System.out.println("Competidor " + id + " lancou os dados: " + dado1 + " e " + dado2);

                int soma = dado1 + dado2;
                if (soma == 7 || soma == 11) {
                    pontos++;
                    System.out.println("Competidor " + id + " marcou um ponto. Total de pontos: " + pontos);
                }

                if (pontos >= 5 && !Main.vencedores.contains(this)) {
                    Main.vencedores.add(this);
                }
            }

            if (pontos >= 5) {
                break;
            }
        }
    }

    public int getIdCompetidor() {
        return id;
    }

    public int getPontos() {
        return pontos;
    }
}
