package controller;

import java.util.Random;

public class Corrida extends Thread {
	private static Random random = new Random();
	private static Object semaforo = new Object();
	private int corredor = 200;
	private int velocidade;

	public Corrida() {
		this.velocidade = random.nextInt(3) + 4;
	}

	private static void porta(int id) {
		System.out.println("Corredor " + id + " está cruzando a porta");
		try {
			Thread.sleep(random.nextInt(2) + 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void correr() {
		for (int i = 0; i < 200; i++) {
			System.out.println("Corredor " + this.getId() + ", falta " + this.corredor + " metros");
			this.corredor -= this.velocidade;
			if (this.corredor <= 0) {
				break;
			}
		}
	}

	public void run() {
		try {
			correr();
			synchronized (semaforo) {
				porta((int) this.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
