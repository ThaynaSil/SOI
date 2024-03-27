package controller;

import java.util.Random;

public class Aeroporto {
    private static final int NUMERO_AVIOES_POR_CICLO = 12;
    private static final int NUMERO_MAXIMO_AVIOES_POR_PISTA = 1;
    private static final int TEMPO_MIN_MANOBRA = 300;
    private static final int TEMPO_MAX_MANOBRA = 700;
    private static final int TEMPO_MIN_TAXIAR = 500;
    private static final int TEMPO_MAX_TAXIAR = 1000;
    private static final int TEMPO_MIN_DECOLAGEM = 600;
    private static final int TEMPO_MAX_DECOLAGEM = 800;
    private static final int TEMPO_MIN_AFASTAMENTO = 300;
    private static final int TEMPO_MAX_AFASTAMENTO = 800;

    private int numeroAvioesPistaNorte;
    private int numeroAvioesPistaSul;

    public Aeroporto() {
        this.numeroAvioesPistaNorte = 0;
        this.numeroAvioesPistaSul = 0;
    }

    public synchronized void agendarDecolagem() {
        Random rand = new Random();
        for (int i = 0; i < NUMERO_AVIOES_POR_CICLO; i++) {
            try {
                Thread.sleep(rand.nextInt(TEMPO_MAX_MANOBRA - TEMPO_MIN_MANOBRA + 1) + TEMPO_MIN_MANOBRA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int pista = rand.nextInt(2); // 0 para pista norte, 1 para pista sul
            if (pista == 0) {
                while (numeroAvioesPistaNorte >= NUMERO_MAXIMO_AVIOES_POR_PISTA) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                numeroAvioesPistaNorte++;
            } else {
                while (numeroAvioesPistaSul >= NUMERO_MAXIMO_AVIOES_POR_PISTA) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                numeroAvioesPistaSul++;
            }

            // Simulação das fases de decolagem
            System.out.println("Avião decolando da pista " + (pista == 0 ? "norte" : "sul"));
            try {
                Thread.sleep(rand.nextInt(TEMPO_MAX_TAXIAR - TEMPO_MIN_TAXIAR + 1) + TEMPO_MIN_TAXIAR);
                Thread.sleep(rand.nextInt(TEMPO_MAX_DECOLAGEM - TEMPO_MIN_DECOLAGEM + 1) + TEMPO_MIN_DECOLAGEM);
                Thread.sleep(rand.nextInt(TEMPO_MAX_AFASTAMENTO - TEMPO_MIN_AFASTAMENTO + 1) + TEMPO_MIN_AFASTAMENTO);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (pista == 0) {
                numeroAvioesPistaNorte--;
            } else {
                numeroAvioesPistaSul--;
            }

            notifyAll();
        }
    }
}