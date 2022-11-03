package com.tian.homework.homework6;

public class SavingAccount extends BankAccount{
    //每个月都有利息，earnMonthlyInterest方法，每月有三次免手续费，在方法中重置交易次数
    private int count = 3;
    private double rate = 2.15;//利率

    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void deposit(double amount) {
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + 1);
        }
        count--;
    }
    public void earnMonthlyInterest() {//每月重置,统计利息
        count = 3;
        super.deposit(getBalance() * rate);
    }
}
