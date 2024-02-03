package com.dessert_shoppe;

public class User {
\    private String name;
    private double balance;
    private Card userPaymentMethod;

    public User(String name, GiftCard gcard) {
        this.name = name;
        this.userPaymentMethod = gcard;
        this.balance = gcard.getBalance();
    }
\

    public User(String name, CreditCard ccard) {
        this.name = name;
        this.userPaymentMethod = ccard;
        this.balance = ccard.getBalance();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Card getUserPaymentMethod() {
        return userPaymentMethod;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void processPayment(double amount) {
        // Call the payment method's processTransaction
        userPaymentMethod.processTransaction(amount);
        // Update the user's balance
        balance = userPaymentMethod.getBalance();
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", balance=$" + balance + "]";
    }
=======

    public User(String name, GiftCard giftCard) {
        this.paymentMethod = giftCard;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " using " + paymentMethod + " with balance " + balance;
    }

}
