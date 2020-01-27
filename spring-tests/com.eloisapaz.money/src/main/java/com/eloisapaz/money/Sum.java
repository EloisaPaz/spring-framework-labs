package com.eloisapaz.money;

public class Sum implements Expression{

    protected Expression firstNum;
    protected Expression secondNum;

    public Sum(Expression firstNum, Expression secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = firstNum.reduce(bank, to).amount + secondNum.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression secondNum) {
        return new Sum(this, secondNum);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(firstNum.times(multiplier), secondNum.times(multiplier));
    }
}
