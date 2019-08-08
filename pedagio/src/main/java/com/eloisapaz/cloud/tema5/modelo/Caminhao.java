package com.eloisapaz.cloud.tema5.modelo;

public class Caminhao implements Pedagio {

    public static final double PRECO = 3.95;
    public static final double EXTRA = 0.50;
    public int numEixos;

    public void setNumEixos(int numEixos){
        this.numEixos = numEixos;
    }

    @Override
    public double valorPago(double valor) {
        return valor - (PRECO + numEixos * EXTRA);
    }

    @Override
    public double getPreco() {
        return PRECO + numEixos * EXTRA;
    }
}