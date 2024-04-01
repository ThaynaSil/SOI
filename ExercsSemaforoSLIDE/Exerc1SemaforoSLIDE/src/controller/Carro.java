package controller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;
import view.Main;

public class Carro extends Thread {
    private static Lock semaforo = new ReentrantLock();

    public static void andar(long l) {
        String[] sentido = {"frente", "esquerda", "direita"};
        Random rand = new Random();
        String direcao = sentido[rand.nextInt(3)];
        System.out.println("O carro " + l + " está indo para a " + direcao);
    }

    public void run() {
        try {
            semaforo.lock();
            Thread.sleep(1000);
            andar(this.getId());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            semaforo.unlock();
        }
    }


}
