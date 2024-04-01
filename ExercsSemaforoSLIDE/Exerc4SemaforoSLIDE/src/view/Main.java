package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controller.F1;

public class Main {
	public static void main(String[] args) {

		int[] escudeira = { 1, 3, 2, 1, 3, 2, 7, 4, 5, 6, 5, 6, 4, 7 };
		List<F1> f1List = new ArrayList<>();
		List<Double> colocados = new ArrayList<>();

		for (int i : escudeira) {

			F1 f1 = new F1(i);
			f1List.add(f1);
			f1.start();
		}

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (F1 f1 : f1List) {
			colocados.addAll(f1.getTempos());
		}

		Collections.sort(colocados);

		for (int i = 0; i < colocados.size() / 3; i++) {

			int index = colocados.indexOf(colocados.get(i * 3));
			System.out.println((i + 1) + "° colocado, escudeira " + f1List.get(index).getEscudeira() + " - Tempo: "
					+ colocados.get(i * 3));
		}
	}
}
