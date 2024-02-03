package com.dessert_shoppe;

// GiftCard.java
public class GiftCard implements Card {
  private double balance;

  public GiftCard(double balance) {
      this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  @Override
  public void processTransaction(double amount) {
      if (amount <= balance) {
          balance -= amount;
      } else {
          System.out.println("Insufficient funds on Gift Card.");
      }
  }

  @Override
  public String toString() {
      return "Gift Card Balance: $" + balance;
  }

}
