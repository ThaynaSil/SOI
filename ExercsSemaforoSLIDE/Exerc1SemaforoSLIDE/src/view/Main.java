package view;

import controller.Carro;

public class Main{
public static void main(String[] args) {
    for (int i = 0; i < 4; i++) {
        Carro t = new Carro();
        t.start();
    }
}
}