package controller;

import controller.Cavaleiros;
import java.util.ArrayList;

public class Corredor {
    private int comprimento;
    private int tochaPosicao;
    private int pedraPosicao;
    private int portaPosicao;

    public Corredor(int comprimento, int tochaPosicao, int pedraPosicao) {
        this.comprimento = comprimento;
        this.tochaPosicao = tochaPosicao;
        this.pedraPosicao = pedraPosicao;
        this.portaPosicao = comprimento;
    }

    public int getComprimento() {
        return comprimento;
    }

    public int getTochaPosicao() {
        return tochaPosicao;
    }

    public int getPedraPosicao() {
        return pedraPosicao;
    }

    public int getPortaPosicao() {
        return portaPosicao;
    }
}