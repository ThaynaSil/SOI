package view;

import java.util.concurrent.Semaphore;

import controller.ProcessoController;

public class Main {
	 public static void main(String[] args) {
	        final int NUM_PROCESSOS = 20;
	        Semaphore semaforo = new Semaphore(1);

	        for (int i = 0; i < NUM_PROCESSOS; i++) {
	            ProcessoController p = new ProcessoController(i + 1, semaforo);
	            p.start();
	        }
	    }
}
