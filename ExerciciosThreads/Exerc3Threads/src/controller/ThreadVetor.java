package controller;

public class ThreadVetor extends Thread {
	
    private int valor;
    private int[] vetor;

    public ThreadVetor(int valor, int[] vetor) {
        this.valor = valor;
        this.vetor = vetor;
    }

    @Override
    public void run() {
    	//  tempo inicial
        long inicio = System.currentTimeMillis(); 

        // Verificar se é par ou ímpar 
        if (valor % 2 == 0) {
            for (int i = 0; i < vetor.length; i++) {
            }
        } else {
            for (int elemento : vetor) {
            }
        }

        // tempo final
        long fim = System.currentTimeMillis(); 
        
        double tempoSegundos = (fim - inicio) / 1000.0; 
        System.out.println("Tempo para percorrer o vetor: " + tempoSegundos + " segundos");
    }
}