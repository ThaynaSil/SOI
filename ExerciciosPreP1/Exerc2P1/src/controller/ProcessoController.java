package controller;

import java.util.concurrent.Semaphore;

public class ProcessoController extends Thread{
	private int id;
    private int duracao;
    private Semaphore semaforo;

    public ProcessoController(int id, int duracao, Semaphore semaforo) {
        this.id = id;
        this.duracao = duracao;
        this.semaforo = semaforo;
    }

    public void run() {
        try {
            semaforo.acquire();
            System.out.println("Processo " + id + " começou a ser executado.");
            Thread.sleep(duracao * 1000);
            System.out.println("Processo " + id + " terminou de executar após " + duracao + " segundos.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
    
    public int getDuracao() {
        return duracao;
    }

    public long getId() {
        return id;
    }
}
