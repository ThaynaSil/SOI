package main;

import java.util.concurrent.Semaphore;
import controller.Atleta;

public class ProvaTriatlo {
	public static void main(String[] args) {

		Semaphore semaforoArmas = new Semaphore(5); // 5 armas disponíveis
		Semaphore semaforoRanking = new Semaphore(1);

		int[] pontuacaoFinal = new int[25];

		Atleta[] atletas = new Atleta[25];

		for (int i = 0; i < 25; i++) {
			atletas[i] = new Atleta(semaforoArmas, semaforoRanking, pontuacaoFinal);
			atletas[i].start();
		}

		for (Atleta atleta : atletas) {

			try {
				atleta.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		ordenarEExibirRanking(atletas, pontuacaoFinal);
	}

	private static void ordenarEExibirRanking(Atleta[] atletas, int[] pontuacaoFinal) {
		for (int i = 0; i < atletas.length - 1; i++) {
			for (int j = 0; j < atletas.length - 1 - i; j++) {
				
				if (pontuacaoFinal[j] < pontuacaoFinal[j + 1]) {
					
					int tempPontuacao = pontuacaoFinal[j];
					pontuacaoFinal[j] = pontuacaoFinal[j + 1];
					pontuacaoFinal[j + 1] = tempPontuacao;

					Atleta tempAtleta = atletas[j];
					atletas[j] = atletas[j + 1];
					atletas[j + 1] = tempAtleta;
				}
			}
		}

		System.out.println("\nResultado Final:");
	
		for (int i = 0; i < atletas.length; i++) {
		
			System.out.println("Posição " + (i + 1) + ": Atleta " + atletas[i].getId() + " - Pontuação Final: "
					+ pontuacaoFinal[i]);
		}
	}
}
