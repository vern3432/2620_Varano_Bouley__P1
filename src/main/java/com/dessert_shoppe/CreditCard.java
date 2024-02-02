package com.dessert_shoppe;

public class CreditCard implements Card {

    double maxBalance;

    public CreditCard(double maxBalalance) {
        this.maxBalance = maxBalalance;
    }

    public double getBalance() {
        return maxBalance;
    }

    public void proccessTranscation() {

    }

    @Override
    public String toString() {
        return "";
    }
}
