package view;

import controller.ThreadMatriz;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matriz = new int[3][5];
        Random random = new Random();

        // números aleatórios
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = random.nextInt(100); 
            }
        }

        // calc a soma de cada linha
        for (int i = 0; i < 3; i++) {
            ThreadMatriz thread = new ThreadMatriz(matriz[i], i);
            thread.start();
        }
    }
}
