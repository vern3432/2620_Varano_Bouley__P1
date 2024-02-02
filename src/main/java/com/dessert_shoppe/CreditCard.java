package com.dessert_shoppe;

public class CreditCard implements Card {

    double balance;

    public CreditCard(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void proccessTranscation() {

    }

    @Override
    public String toString() {
        return "";
    }
}
