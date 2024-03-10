package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {

		KillController cont = new KillController();
		cont.osPID();

		int mtprocess = 0;

		do {
			mtprocess = Integer.parseInt(JOptionPane.showInputDialog(null,
					("Processos: \n 1 - Exibir Lista de Procesos Ativos \n 2 - Matar processo por PID \n 3 - Matar processo por Nome \n 4 - Nome SO \n 5 - Finalizar")));

			switch (mtprocess) {
			case 1:
				String process = "TASKLIST /FO TABLE";
				cont.readProcess(process);
				System.out.println("\n");

				break;
			case 2:
				String pid = String.valueOf(JOptionPane.showInputDialog(null, "Digite o PID do processo a ser morto:"));
				String process1 = pid;
				cont.killProcess(process1);
				JOptionPane.showMessageDialog(null, "\n O processo foi morto por PID!!");
				break;
			case 3:
				String pid2 = String.valueOf(JOptionPane.showInputDialog(null, "Digite o Nome do processo a ser morto:"));
				String process2 = pid2;
				cont.killProcess(process2);
				JOptionPane.showMessageDialog(null, "\n O processo foi morto por Nome!!");
				break;

			case 4:
				JOptionPane.showMessageDialog(null, cont.getSo());
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"\n Execução finalizada!!");
				break;
			}
		} while ((mtprocess != 5));

	}
}