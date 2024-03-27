package controller;

import java.util.concurrent.Semaphore;

public class Atleta extends Thread {
	
	private static int numAtletas = 0;
	private static Semaphore semaforoArmas;
	private static Semaphore semaforoRanking;
	private static int[] pontuacaoFinal;
	private int id;
	private int pontuacaoTiro;
	private int posicaoCorrida;
	private int posicaoCiclismo;
	private int posicaoFinal;

	public Atleta(Semaphore semaforoArmas, Semaphore semaforoRanking, int[] pontuacaoFinal) {
		
		this.semaforoArmas = semaforoArmas;
		this.semaforoRanking = semaforoRanking;
		this.pontuacaoFinal = pontuacaoFinal;
		this.id = ++numAtletas;
	}

	@Override
	public void run() {
		
		try {
			correr();
			atirar();
			pedalar();
			calcularPontuacao();
			definirPosicaoFinal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void correr() throws InterruptedException {
		
		System.out.println("Atleta " + id + " está correndo.");
		
		Thread.sleep((long) (Math.random() * 3000 + 2000)); // Entre 20 e 25 ms
		posicaoCorrida = numAtletas;
	}

	private void atirar() throws InterruptedException {
		
		semaforoArmas.acquire();
		
		System.out.println("Atleta " + id + " está atirando.");
		
		Thread.sleep((long) (Math.random() * 2500 + 500)); // De 0,5 a 3 segundos por tiro
		pontuacaoTiro = (int) (Math.random() * 11); // Pontuação de 0 a 10
		semaforoArmas.release();
	}

	private void pedalar() throws InterruptedException {
		
		System.out.println("Atleta " + id + " está pedalando.");
		Thread.sleep((long) (Math.random() * 5000 + 3000)); // Entre 30 e 40 ms
		posicaoCiclismo = numAtletas;
	}

	private void calcularPontuacao() {
		pontuacaoFinal[id - 1] = 250 - (id - 1) * 10 + pontuacaoTiro;
	}

	private void definirPosicaoFinal() throws InterruptedException {
		semaforoRanking.acquire();
		posicaoFinal = numAtletas;
		semaforoRanking.release();
	}

	public int getPosicaoFinal() {
		return posicaoFinal;
	}
}
