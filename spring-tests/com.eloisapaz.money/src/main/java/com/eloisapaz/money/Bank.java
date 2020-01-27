package com.eloisapaz.money;

public class Bank {

    Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency);
    }

    public int rate(String from, String to) {
        return (from.equals("CHF") && to.equals("USD")) ? 2 : 1;
    }
}
