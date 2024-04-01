package view;

import java.util.Random;

import controller.ContaBancaria;

public class SimuladorTransacoes {
	public static void main(String[] args) {
	    
	     ContaBancaria conta1 = new ContaBancaria(1, 1000);
	     ContaBancaria conta2 = new ContaBancaria(2, 500);
	     ContaBancaria conta3 = new ContaBancaria(3, 2000);
	     ContaBancaria conta4 = new ContaBancaria(4, 1500);
	     ContaBancaria conta5 = new ContaBancaria(5, 300);

	    
	     ContaBancaria[] contas = {conta1, conta2, conta3, conta4, conta5};

	     Random rand = new Random();
	     for (int i = 0; i < 20; i++) {
	         int randomIndex = rand.nextInt(contas.length);
	         ContaBancaria contaSelecionada = contas[randomIndex];
	         boolean isSaque = rand.nextBoolean();
	         double valorTransacao = rand.nextDouble() * 500; // Valor aleatório entre 0 e 500

	         if (isSaque) {
	             contaSelecionada.sacar(valorTransacao);
	         } else {
	             contaSelecionada.depositar(valorTransacao);
	         }
	     }
	 }
}