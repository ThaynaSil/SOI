package controller;

public class TransacaoThread extends Thread {

	private int id;

	public TransacaoThread(int id) {

		this.id = id;
	}

	@Override
	public void run() {

		if (id % 3 == 1) {

			transacaoTipoA();

		} else if (id % 3 == 2) {

			transacaoTipoB();

		} else {

			transacaoTipoC();
		}
	}

	private void transacaoTipoA() {

		System.out.println("Thread " + id + " iniciou transacao do tipo A");

		realizarCalculos(0.2, 1.0);
		fazerTransacaoBD(1);

		realizarCalculos(0.2, 1.0);
		fazerTransacaoBD(1);

		System.out.println("Thread " + id + " finalizou transacao do tipo A");
	}

	private void transacaoTipoB() {
		System.out.println("Thread " + id + " iniciou transacao do tipo B");

		realizarCalculos(0.5, 1.5);
		fazerTransacaoBD(1.5);

		realizarCalculos(0.5, 1.5);
		fazerTransacaoBD(1.5);

		realizarCalculos(0.5, 1.5);
		fazerTransacaoBD(1.5);

		System.out.println("Thread " + id + " finalizou transacao do tipo B");
	}

	private void transacaoTipoC() {
		System.out.println("Thread " + id + " iniciou transacao do tipo C");

		realizarCalculos(1, 2);
		fazerTransacaoBD(1.5);

		realizarCalculos(1, 2);
		fazerTransacaoBD(1.5);

		realizarCalculos(1, 2);
		fazerTransacaoBD(1.5);

		System.out.println("Thread " + id + " finalizou transacao do tipo C");
	}

	private void realizarCalculos(double tempoMin, double tempoMax) {

		double tempo = tempoMin + Math.random() * (tempoMax - tempoMin);

		try {

			Thread.sleep((long) (tempo * 1000));

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	private void fazerTransacaoBD(double tempo) {

		System.out.println("Thread " + id + " realizando transacao no banco de dados");

		try {

			Thread.sleep((long) (tempo * 1000));

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
