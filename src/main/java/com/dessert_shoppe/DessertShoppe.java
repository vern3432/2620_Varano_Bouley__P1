package com.dessert_shoppe;

import com.Item;
import com.Item;
import com.dessert_shoppe.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

  DessertShoppe(String shoppe_name, String inventory_file) {
    this.shoppe_name = shoppe_name;
    ProccessInv(inventory_file);
  }

  String placeOrder(User input_User, String order_path) {
    String proccessed = ProccessOrder(order_path);

    return ("reciept");
  }

  String ProccessOrder(String order_path) {
    ArrayList<String> readInfo = fileProcess(order_path);

    return ("r");
  }

  public void ProccessInv(String order_path) {
    ArrayList<String> readInfo = fileProcess(order_path);
    System.out.println("ProcessInv Arraylist created");
    // int size_map=Integer.parseInt(readInfo.get(0))/ 0.75 + 1;
    //if key value exists, get the key i guess.
    //43, Sundae, Vanilla, 3.75, 3, Peanut Butter
    HashMap<Integer, Item> InvMap = new HashMap<Integer, Item>();
    System.out.println("ProcessInv HashMap created");

    for (int i = 1; i < readInfo.size(); i++) {
      List<String> temp = new LinkedList<String>(
        Arrays.asList(readInfo.get(i).split(","))
      );
      while (temp.size() < 6) {
        while ((temp.size() < 5)) {
          temp.add("1");
        }
        temp.add(null);
        System.out.println("added null to item temp");
      }
      System.out.println("adding" + temp.get(0));
      Item tempItem = new Item(
        temp.get(1),
        temp.get(2),
        Double.parseDouble(temp.get(3).replace(" ", "")),
        Integer.parseInt(temp.get(4).replace(" ", "")),
        temp.get(5)
      );
      InvMap.put(Integer.parseInt(temp.get(0)), tempItem);

      System.out.println("added" + temp.get(0));
    }
    this.inventory = InvMap;
  }

  public HashMap<Integer, Item> getInventory() {
    return inventory;
  }

  //read resource stream files and return lines as Arraylist
  public ArrayList<String> fileProcess(String filename) {
    ArrayList<String> forReturn = new ArrayList<String>();
    try (
      BufferedReader br = new BufferedReader(
        new InputStreamReader(
          this.getClass().getResourceAsStream("/" + filename)
        )
      )
    ) {
      String line;
      while ((line = br.readLine()) != null) {
        forReturn.add((line));
        // add meaningfull processing to file
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return forReturn;
  }
}
// Google is informing me that a good load factor is .70 to .75, so I am
// thinking 1.3 times as large as the initial entry.Just round up if not an int
