package view;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import controller.Corredor;
import controller.Cavaleiros;

class Main {

    public static void main(String[] args) {
        Corredor corredor = new Corredor(2000, 500, 1500);
        ArrayList<Cavaleiros> cavaleiros = new ArrayList<>();
        ArrayList<Semaphore> semaforos = new ArrayList<>();

        // Inicializa��o dos sem�foros
        for (int i = 0; i < 4; i++) {
            semaforos.add(new Semaphore(1)); // Um sem�foro para cada cavaleiro
        }

        // Inicializa��o dos cavaleiros
        for (int i = 0; i < 4; i++) {
            cavaleiros.add(new Cavaleiros(i, corredor, semaforos.get(i)));
        }

        // Inicializa��o das threads dos cavaleiros
        for (Cavaleiros cavaleiro : cavaleiros) {
            Thread thread = new Thread(cavaleiro);
            thread.start();
        }
    }
}
