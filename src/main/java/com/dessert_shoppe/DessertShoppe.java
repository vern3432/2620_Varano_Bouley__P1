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
        String proccessed=ProccessOrder(inventory_file);

    }

    String placeOrder(User input_User, String order_path) {
            String proccessed=ProccessOrder(order_path);

        return ("reciept");
    }


    String ProccessOrder(String order_path) {
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

        return("r");
    }

    String ProccessInv(String order_path) {
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

        return("r");
    }

}

// Google is informing me that a good load factor is .70 to .75, so I am
// thinking 1.3 times as large as the initial entry.Just round up if not an int
