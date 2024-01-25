package com.dessert_shoppe;

import com.dessert_shoppe.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
//need to make these use one function 


public class DessertShoppe {

    HashMap inventory;

    DessertShoppe(String shoppe_name, String inventory_file) {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        this.getClass().getResourceAsStream("/" + inventory_file)))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                // add meaningfull processing to file
                //Use first line to determine structure of hashmap 
                //then create hashmap
                //.put is used to add a key: inventory.put("Norway", "Oslo");
                //is there  way to make this more efficient since we arleady know the number of items? 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String placeOrder(User input_User, String order_path) {
        try (

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        this.getClass().getResourceAsStream("/" + order_path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                // add meaningfull processing to file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ("reciept");
    }

}






























                //Google is informing me that a good load factor is .70 to .75, so I am thinking 1.3 times as large as the initial entry.Just round up if not an int
