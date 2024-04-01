package view;

import controller.Corrida;

public class Main {

	public static void main(String[] args) {
		for (int i = 1; i <= 4; i++) {
			Corrida t = new Corrida();
			t.start();
		}
	}
}
