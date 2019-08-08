package com.eloisapaz.cloud.tema5.modelo;

public class Carro implements Pedagio {

    public static final double PRECO = 2.11;

    @Override
    public double valorPago(double valor) {
        return valor - PRECO;
    }

    @Override
    public double getPreco() {
        return PRECO;
    }
}