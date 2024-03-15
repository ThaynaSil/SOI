package view;

import controller.ThreadTID;

public class Principal {
	
	public static void main(String[] args) {
			
		for (int IDThread = 0; IDThread < 5; IDThread++) {
			
			Thread threadTID = new ThreadTID (IDThread);
			long threadId = Thread.currentThread().getId();
			threadTID.start();
			
		}
	}

}
