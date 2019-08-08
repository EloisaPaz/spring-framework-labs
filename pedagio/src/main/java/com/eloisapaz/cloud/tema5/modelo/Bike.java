package com.eloisapaz.cloud.tema5.modelo;

public class Bike implements Pedagio{

    public static final double PRECO = 0.49;

    @Override
    public double valorPago(double valor) {
        return valor - PRECO;
    }

    public double getPreco() {
        return PRECO;
    }
}