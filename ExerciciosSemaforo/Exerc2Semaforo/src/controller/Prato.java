package controller;

public class Prato extends Thread {

	private int id;
	private String nome;
	private double tempoMin;
	private double tempoMax;
	private boolean pronto;

	public Prato(int id, String nome, double tempoMin, double tempoMax) {

		this.id = id;
		this.nome = nome;
		this.tempoMin = tempoMin;
		this.tempoMax = tempoMax;
		this.pronto = false;
	}

	public void run() {

		System.out.println( nome + " (ID -> " + id + ") iniciou o cozimento.");

		double tempoTotal = Math.random() * (tempoMax - tempoMin) + tempoMin;

		double percentual;

		for (double tempo = 0.1; tempo <= tempoTotal; tempo += 0.1) {

			percentual = (tempo / tempoTotal) * 100;

			System.out.println(nome + " (ID -> " + id + ") - Cozinhando: " + String.format("%.1f", percentual) + "%");

			try {

				Thread.sleep(100);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		System.out.println(nome + " (ID -> " + id + ") - Pronto para entrega.");

		this.pronto = true;
	}

	public boolean isPronto() {

		return pronto;
	}

	public int getIdentificador() {

		return id;
	}

	public String getNome() {

		return nome;
	}
}
