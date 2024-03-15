package view;

import controller.PingThread;

public class Main {
	public static void main(String[] args) {
		PingThread uolThread = new PingThread("www.uol.com.br");
		PingThread terraThread = new PingThread("www.terra.com.br");
		PingThread googleThread = new PingThread("www.google.com.br");

		uolThread.start();
		terraThread.start();
		googleThread.start();
	}
}
