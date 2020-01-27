package com.eloisapaz.money;

public interface Expression {

    Money reduce(Bank bank, String to);

    Expression plus(Expression secondNum);

    Expression times(int multiplier);
}
