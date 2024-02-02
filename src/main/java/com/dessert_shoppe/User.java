package com.dessert_shoppe;

public class User {

    double balance;
    String name;
    Card paymentMethod;

    public User(String name, CreditCard creditCard) {
        this.paymentMethod = creditCard;
        this.name = name;

    }

    public User(String name, GiftCard giftCard) {
        this.paymentMethod = giftCard;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " using " + paymentMethod + " with balance " + balance;
    }

}
