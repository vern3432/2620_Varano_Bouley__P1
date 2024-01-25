package com.dessert_shoppe;

import com.dessert_shoppe.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DessertShoppe {
    DessertShoppe(String shoppe_name, String inventory_file) {
        try (
            // File file = new File(this.getClass().getResource("/res.txt").getFile());
            BufferedReader br = new BufferedReader(new InputStreamReader(
                           this.getClass().getResourceAsStream("/" + inventory_file)))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String placeOrder(User input_User, String order_path) {
        try (
            // File file = new File(this.getClass().getResource("/res.txt").getFile());

            BufferedReader br = new BufferedReader(new InputStreamReader(
                           this.getClass().getResourceAsStream("/" + order_path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ("reciept");
    }

}
