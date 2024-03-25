package view;

import controller.TransacaoThread;

public class Main {
    public static void main(String[] args) {
        int numThreads = 21;

        for (int i = 1; i <= numThreads; i++) {
            TransacaoThread thread = new TransacaoThread(i);
            thread.start();
        }
    }
}
