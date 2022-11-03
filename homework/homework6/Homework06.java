package com.tian.homework.homework6;

public class Homework06 {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(10000);
//        checkingAccount.deposit(10);
//        System.out.println(checkingAccount.getBalance());
//        checkingAccount.withdraw(20);
//        System.out.println(checkingAccount.getBalance());

        SavingAccount savingAccount = new SavingAccount(1000);
        savingAccount.deposit(100);
        savingAccount.deposit(100);
        savingAccount.deposit(100);
        savingAccount.deposit(100);
        System.out.println(savingAccount.getBalance());
    }
}
