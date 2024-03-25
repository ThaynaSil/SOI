package view;

import controller.Prato;

public class MainCozinha {

	public static void main(String[] args) {
		
		Prato[] pratos = new Prato[5];
		
		for (int i = 0; i < 5; i++) {
			
			if ((i + 1) % 2 == 0) {
				
				pratos[i] = new Prato(i + 1, "Lasanha a Bolonhesa", 0.6, 1.2);
				
			} else {
					
				pratos[i] = new Prato(i + 1, "Sopa de Cebola", 0.5, 0.8);
			}
		}

		for (Prato prato : pratos) {
			
			prato.start();
		}

		while (true) {
			
			for (Prato prato : pratos) {
				
				if (prato.isPronto()) 
				{
	       
		System.out.println("Prato " + prato.getNome() + " (ID -> " + prato.getIdentificador() + ") pronto para entrega.");
					
					try {
						
						Thread.sleep(500); 
						
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
					prato.interrupt();
				}
			}
			
			boolean todosProntos = true;
			
			for (Prato prato : pratos) {
				
				if (!prato.isPronto()) {
				
					todosProntos = false;
					
					break;
				}
			}
			
			if (todosProntos) {
			
				break;
			}
		}
		
		System.out.println("\nTodos os pratos foram entregues. Fim do expediente!!");
	}
}
