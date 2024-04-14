package controller;

import java.util.concurrent.Semaphore;

public class ProcessoController extends Thread{
    private int id;
    private Semaphore semaforo;

    public ProcessoController(int id, Semaphore semaforo) {
        this.id = id;
        this.semaforo = semaforo;
    }

    public void run() {
        try {
            semaforo.acquire();
            System.out.println("Processo " + id + " comecou a ser executado.");
            int tempoExecucao = (int) (Math.random() * 117) + 4;
            Thread.sleep(tempoExecucao * 1000);
            System.out.println("Processo " + id + " terminou de executar apos " + tempoExecucao + " segundos.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
}
