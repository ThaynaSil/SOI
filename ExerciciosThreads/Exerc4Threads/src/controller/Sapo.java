package controller;

import java.util.Random;

public class Sapo extends Thread {

	private String nome;
	private int distanciaCorrida = 0;
	private int distanciaTotalCorrida;
	private int pulo = 0;
	private int pulos = 0;
	private static int colocacao = 0;
	private final static int PULO_MAXIMO = 50;

	/* Construtor */
	public Sapo(String nome, int distanciaTotalCorrida) {
	
		/* Chamar o construtor */
		super(nome);
		this.distanciaTotalCorrida = distanciaTotalCorrida;
		this.nome = nome;
	}
		@Override
	    public void run() {
	        Random random = new Random();
	        while (distanciaCorrida < distanciaTotalCorrida) {
	            int pulo = random.nextInt(PULO_MAXIMO + 1);
	            distanciaCorrida += pulo;
	            if (distanciaCorrida > distanciaTotalCorrida) {
	                distanciaCorrida = distanciaTotalCorrida;
	            }
	            System.out.println(nome + " pulou " + pulo + " metros e percorreu " + distanciaCorrida + " metros.");
	        }
	        synchronized (Sapo.class) {
	            colocacao++;
	            System.out.println(nome + " chegou em " + colocacao + "º lugar.");
	        }
	    }
	}