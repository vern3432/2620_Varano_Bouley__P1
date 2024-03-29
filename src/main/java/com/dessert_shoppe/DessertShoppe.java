package com.dessert_shoppe;

import com.Item;
import com.dessert_shoppe.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//need to make these use one function
//has table size should always be prime, one less than a power of 2.
public class DessertShoppe {

  String shoppe_name;
  HashMap<Integer, Item> inventory;

  private static final DecimalFormat df = new DecimalFormat("0.00");
  private boolean trace = false; // trun tracing on/off

  DessertShoppe(String shoppe_name, String inventory_file) {
    this.shoppe_name = shoppe_name;
    ProccessInv(inventory_file);
  }

  /**
   * Get an order from a specific user
   *
   * @param input_User
   * @param order_path
   * @return
   */
  public String placeOrder(User input_User, String order_path) {
    return buildReceipt(input_User, order_path);
  }

  public String buildReceipt(User inputUser, String order_path) {
    String receiptLine = "";
    String receipt = "";
    String totalLine = "";
    String receiptHeading =
      "          " +
      shoppe_name +
      "\n" +
      "--------------------------------------------------" +
      "\n";

    try (
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(
          this.getClass().getResourceAsStream("/" + order_path)
        )
      )
    ) {
      System.out.println();

      ArrayList<Double> subtotal = new ArrayList<>();
      Double sum = 0.00;
      String currentLine;

      while ((currentLine = reader.readLine()) != null) {
        String[] part = currentLine.split(" ");

        int itemNumber = Integer.parseInt(part[0]); // the first number
        int quantity = Integer.parseInt(part[1]); // the second number
        Item item = inventory.get(itemNumber); // the current item that we are looking at
        String name = item.getTypeOne(); // the item's name
        Double price = item.getPrice(); // the item's price
        Double total = price * quantity; // total for the items

        // make sure that the first number is the item number and second is the quantity
        if (quantity >= item.getQuant()) {
          quantity = item.getQuant();
          inventory.get(itemNumber).setQuant(0);
        }else{
          inventory.get(itemNumber).setQuant( item.getQuant()-quantity);



        }


        if (part.length == 2) {
          receiptLine =
            String.format("%-15s", " " + quantity + "x") +
            String.format("%11s", name) +
            " (@ " +
            df.format(price) +
            ") .... " +
            "$  " +
            String.format("%5s", df.format(total)) +
            "\n";

          subtotal.add(total);
        } else {
          return (
            "Invalid line in the order file at: " +
            currentLine +
            ". Must have format <itemNumber> <quantity>"
          );
        }
        receipt = receiptLine + receipt;
      }

      for (int i = 0; i < subtotal.size(); i++) {
        sum = sum + subtotal.get(i);
      }

      totalLine =
        String.format("%41s", "Total .... ") +
        String.format("%-3s", "$ ") +
        df.format(sum) +
        "\n";

      sum = Double.parseDouble(df.format(sum));

      inputUser.setBalance(sum); // Set the users new balance
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
      return null;
    }

    receipt = receiptHeading + receipt + totalLine;

    return receipt;
  }

  /**
   * Read a file for an inventory
   *
   * @param order_path
   */
  public void ProccessInv(String order_path) {
    ArrayList<String> readInfo = fileProcess(order_path);

    // 43, Sundae, Vanilla, 3.75, 3, Peanut Butter
    HashMap<Integer, Item> InvMap = new HashMap<>();

    for (int i = 1; i < readInfo.size(); i++) {
      LinkedList<String> temp = new LinkedList<>(
        Arrays.asList(readInfo.get(i).split(","))
      );
      int quant = 1;

      if (InvMap.containsKey(Integer.parseInt(temp.get(0)))) {
        quant = InvMap.get(Integer.parseInt(temp.get(0))).getQuant() + 1;
      }
      // For When qunaity and other flavour/type isn't included
      while (temp.size() < 6) {
        while ((temp.size() < 5)) {
          while ((temp.size() < 4)) {
            while ((temp.size() < 3)) {
              temp.add(null);
            }

            temp.add("0");
          }

          temp.add("1");
        }

        temp.add(null);
      }
      Item tempItem = new Item(
        temp.get(1),
        temp.get(2),
        Double.parseDouble(temp.get(3).replace(" ", "")),
        Integer.parseInt(temp.get(4).replace(" ", "")),
        temp.get(5),
        quant
      );
      InvMap.put(Integer.parseInt(temp.get(0)), tempItem);

      if (trace) {
        System.out.println("added " + temp.get(0));
      }
    }
    this.inventory = InvMap;
  }

  public HashMap<Integer, Item> getInventory() {
    return inventory;
  }

  /**
   * Read resource stream files and return lines as Arraylist
   *
   * @param filename
   * @return
   */
  public ArrayList<String> fileProcess(String filename) {
    ArrayList<String> forReturn = new ArrayList<String>();
    try (
      BufferedReader br = new BufferedReader(
        new InputStreamReader(
          this.getClass().getResourceAsStream("/" + filename)
        )
      )
    ) {
      String currentLine;
      while ((currentLine = br.readLine()) != null) {
        forReturn.add((currentLine));
      }
      br.close(); // Exit the file
    } catch (IOException e) {
      e.printStackTrace();
    }
    return forReturn;
  }
}
// Google is informing me that a good load factor is .70 to .75, so I am
// thinking 1.3 times as large as the initial entry.Just round up if not an int
// int size_map=Integer.parseInt(readInfo.get(0))/ 0.75 + 1;
// if key value exists, get the key i guess.
