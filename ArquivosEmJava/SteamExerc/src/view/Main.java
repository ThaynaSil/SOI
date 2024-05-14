package view;

import javax.swing.JOptionPane;
import controller.Steam;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Steam controller = new Steam();
		
		int control = 0;
		while(control != 9) {
			control = Integer.parseInt(JOptionPane.showInputDialog("Menu \n\n"
																	+ "1- Pesquisar \n"
																	+ "2- Criar csv"));
			switch(control) {
			case 1:
				String dados = JOptionPane.showInputDialog(null, "Digite o mês, ano e média de jogadores ativos que deseja filtrar \n(Separe-os por virgula)", "Entrada de dados", JOptionPane.INFORMATION_MESSAGE);
				String[] separar = dados.split(", ");
				String mes = separar[0];
				String ano = separar[1];
				int media = Integer.parseInt(separar[2]);
				System.out.println("Jogos com média de jogadores ativos >= " + media + " em " + mes + " de " + ano + ":");
				controller.filtrarJogos(ano, mes, media);
				break;
			case 2:
				dados = JOptionPane.showInputDialog(null, "Digite o mês, ano e o nome do arquivo que deseja ser criado \n(Separe-os por virgula)", "Entrada de dados", JOptionPane.INFORMATION_MESSAGE);
				separar = dados.split(", ");
				mes = separar[0];
				ano = separar[1];
				String nome = separar[2];
				System.out.println("Gerando arquivo filtrado para " + mes + " de " + ano + "...");
				controller.gerarArquivoFiltrado(ano, mes, "C:\\TEMP", nome + ".csv");
				System.out.println("Arquivo gerado com sucesso.");
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado.");
				break;
			default: JOptionPane.showMessageDialog(null, "Comando inválido.");
			}
		}
	}

}