package controller;

public class FatorialRecursivoController extends Thread{
	   private long numero;

	    public FatorialRecursivoController(long numero) {
	        this.numero = numero;
	    }

	    public void run() {
	        long inicio = System.nanoTime();
	        long resultado = calcularFatorialRecursivo(numero);
	        long fim = System.nanoTime();
	        long tempoDecorrido = fim - inicio;

	        System.out.println("Fatorial de " + numero + " (Recursivo): " + resultado);
	        System.out.println("Tempo decorrido (Recursivo): " + tempoDecorrido + " nanossegundos");
	    }

	    private long calcularFatorialRecursivo(long n) {
	        if (n == 0 || n == 1) {
	            return 1;
	        }
	        return n * calcularFatorialRecursivo(n - 1);
	    }
}
