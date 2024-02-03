package com.dessert_shoppe;

public class CreditCard implements Card {
    private double balance;
    private final double maxBalance;

    public double getBalance() {
        return balance;
    }

    public double getMaxBalance() {
        return maxBalance;
    }

    public CreditCard(double maxBalance) {
        this.balance = 0.0;
        this.maxBalance = maxBalance;
    }

    @Override
    public void processTransaction(double amount) {
        if (balance + amount <= maxBalance) {
            balance += amount;
        } else {
            System.out.println("Credit limit exceeded on Credit Card.");
        }
    }
}

