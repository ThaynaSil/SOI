package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

import controller.Corredor;

public class Cavaleiros implements Runnable {
    private int id;
    private int posicao;
    private int velocidade;
    private Corredor corredor;
    private Semaphore semaforo;

    public Cavaleiros(int id, Corredor corredor, Semaphore semaforo) {
        this.id = id;
        this.posicao = 0;
        this.velocidade = 2;
        this.corredor = corredor;
        this.semaforo = semaforo;
    }

    public void run() {
        try {
            while (posicao < corredor.getComprimento()) {
                Thread.sleep(50); // Aguarda 50 ms para simular movimento

                if (posicao == corredor.getTochaPosicao()) {
                    // Se o cavaleiro alcan�ar a tocha, aumenta velocidade
                    velocidade += 2;
                    System.out.println("Cavaleiro " + id + " pegou a tocha!");
                }

                if (posicao == corredor.getPedraPosicao()) {
                    // Se o cavaleiro alcan�ar a pedra, aumenta velocidade
                    velocidade += 2;
                    System.out.println("Cavaleiro " + id + " pegou a pedra!");
                }

                // Atualiza posi��o do cavaleiro
                posicao += velocidade;

                if (posicao >= corredor.getPortaPosicao()) {
                    // Se o cavaleiro alcan�ar as portas, tenta escolher uma porta
                    escolherPorta();
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void escolherPorta() throws InterruptedException {
        Random rand = new Random();
        int portaEscolhida = rand.nextInt(4) + 1; // Escolhe uma porta aleat�ria de 1 a 4

        semaforo.acquire(); // Adquire o sem�foro para acessar a se��o cr�tica
        System.out.println("Cavaleiro " + id + " escolheu a porta " + portaEscolhida);
        semaforo.release(); // Libera o sem�foro ap�s acessar a se��o cr�tica

        // Aqui voc� pode implementar a l�gica para verificar se a porta escolhida � a correta
        // e tomar as a��es necess�rias
    }
}