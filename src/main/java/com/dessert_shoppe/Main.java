//2620_Varano_Bouley__P1
package com.dessert_shoppe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    // Create our new dessert shoppe, and give it an inventory to load
    DessertShoppe shop = new DessertShoppe(
      "OOPsy Daisy Desserts",
      "testInventory.txt"
    );
    // Set up the three users in the system, including payment methods
    User[] users = {
      new User("Chris", new CreditCard(1000.0)),
      new User("Zach", new GiftCard(100.0)),
      new User("Sam", new CreditCard(1000.0)),
    };
    // Build a receipt string by placing an order for each of the
    // users (the order lives in the file)
    String receipt = shop.placeOrder(users[0], "order1.txt");
    receipt += "\n\n" + shop.placeOrder(users[1], "order2.txt");
    receipt += "\n\n" + shop.placeOrder(users[2], "order3.txt");
    // Print the receipt
    System.out.println(receipt);
    // Check the current remaining balance of each user
    for (int i = 0; i < users.length; i++) {
      System.out.println(users[i]);
    }
    System.out.println("Inventory: \n"+shop.getInventory()); 
}
}
