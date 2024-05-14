package view;

import java.io.IOException;

import controller.Arquivos;
import controller.Arquivos2;

public class Main {


	public static void main(String[] args) {
		
		Arquivos2 arq = new Arquivos();
		String path = "C:\\TEMP";
		String name = "generic_food.csv";
		
		try {
			arq.checkFile(path, name);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}