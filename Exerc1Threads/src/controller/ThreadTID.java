package controller;

import javax.swing.JOptionPane;

// Herdar caracteríscas de thread (extends Thread)
// Parametros pelo construtor
// metodo run (só é executado o que está dentro do método run)

public class ThreadTID extends Thread{
	
	private int IDThread;
	
	public ThreadTID(int IDThread) {
		this.IDThread = IDThread;
	}
	
	@Override
		public void run() {
			
		System.out.println(IDThread);
	    }
}
