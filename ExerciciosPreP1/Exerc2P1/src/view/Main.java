package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Semaphore;

import controller.ProcessoController;

public class Main {
    public static void main(String[] args) {
        final int NUM_PROCESSOS = 20;
        Semaphore semaforo = new Semaphore(1);
        ArrayList<ProcessoController> processos = new ArrayList<>();

        for (int i = 0; i < NUM_PROCESSOS; i++) {
            int duracao = (int) (Math.random() * 117) + 4;
            ProcessoController p = new ProcessoController(i + 1, duracao, semaforo);
            processos.add(p);
        }

        Collections.sort(processos, Comparator.comparingInt(ProcessoController::getDuracao));

        for (ProcessoController p : processos) {
            p.start();
        }
    }
}
