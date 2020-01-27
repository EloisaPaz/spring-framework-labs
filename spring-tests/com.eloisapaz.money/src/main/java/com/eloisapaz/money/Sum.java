package com.eloisapaz.money;

public class Sum implements Expression{

    protected Money firstNum;
    protected Money secondNum;

    public Sum(Money firstNum, Money secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = firstNum.amount + secondNum.amount;
        return new Money(amount, to);
    }
}
