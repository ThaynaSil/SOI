package view;

import java.util.Random;

import controller.ThreadVetor;

public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[1000];
        Random random = new Random();

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100) + 1;
        }

        // iniciar as duas threads
        ThreadVetor threadPar = new ThreadVetor(2, vetor);
        threadPar.start();

        ThreadVetor threadImpar = new ThreadVetor(1, vetor);
        threadImpar.start();
    }
}