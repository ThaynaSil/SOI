package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class F1 extends Thread {
	private static final Semaphore SEMAFORO = new Semaphore(5);
	private static final Semaphore SEMAFORO_CARRO = new Semaphore(1);

	private int escudeira;
	private List<Double> tempos = new ArrayList<>();

	public F1(int escudeira) {
		this.escudeira = escudeira;
	}

	@Override
	public void run() {
		try {
			SEMAFORO.acquire();
			SEMAFORO_CARRO.acquire();
			for (int i = 0; i < 3; i++) {
				volta();
			}
			SEMAFORO_CARRO.release();
			SEMAFORO.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void volta() {
		try {
			System.out.println(Thread.currentThread().getId() + " da escudeira " + escudeira + " começou uma volta");
			Thread.sleep(5000); 
			System.out.println(Thread.currentThread().getId() + " da escudeira " + escudeira + " terminou uma volta");
			tempos.add((double) System.currentTimeMillis()); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<Double> getTempos() {
		return tempos;
	}

	public int getEscudeira() {
		return escudeira;
	}
}
