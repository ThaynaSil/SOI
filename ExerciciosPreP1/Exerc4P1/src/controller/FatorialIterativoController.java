package controller;

public class FatorialIterativoController extends Thread{
	private long numero;

    public FatorialIterativoController(long numero) {
        this.numero = numero;
    }

    public void run() {
        long inicio = System.nanoTime();
        long resultado = calcularFatorialIterativo(numero);
        long fim = System.nanoTime();
        long tempoDecorrido = fim - inicio;

        System.out.println("Fatorial de " + numero + " (Iterativo): " + resultado);
        System.out.println("Tempo decorrido (Iterativo): " + tempoDecorrido + " nanossegundos");
    }

    private long calcularFatorialIterativo(long n) {
        long resultado = 1;
        for (long i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
