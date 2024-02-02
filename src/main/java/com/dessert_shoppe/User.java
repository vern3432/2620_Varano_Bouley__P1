package com.dessert_shoppe;

public class User {
    double balance;
    Card userPaymentMethod;

    // User paying with a gift card
    User(String name, GiftCard gcard) {
        this.userPaymentMethod = gcard;

    }

    // User paying with a credit card
    User(String name, CreditCard ccard) {
        this.userPaymentMethod = ccard;

    }

    public String toString() {

        return (" " + this.balance);
    }

}
