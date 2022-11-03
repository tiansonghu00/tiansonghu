package com.tian.homework.homework6;

public class CheckingAccount extends BankAccount{
    //每次存钱取钱都是一美元手续费

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}
