package com.eloisapaz.cloud.tema5.modelo;

public class Moto implements Pedagio{

    public static final double PRECO = 1.0;

    @Override
    public double valorPago(double valor) {
        return valor - PRECO;
    }

    @Override
    public double getPreco() {
        return PRECO;
    }
}