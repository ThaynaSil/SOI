package controller;


public class ThreadMatriz extends Thread {
	
    private int[] linha;
    private int identificacao;

    public ThreadMatriz(int[] linha, int identificacao) {
        this.linha = linha;
        this.identificacao = identificacao;
    }

    @Override
    public void run() {
        int soma = 0;
        for (int valor : linha) {
            soma += valor;
        }
        System.out.println("Linha " + identificacao + ": Soma = " + soma);
    }
}
