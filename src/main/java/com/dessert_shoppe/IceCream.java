package com.dessert_shoppe;

public class IceCream extends item {

    String name;
    float price;
    int id;
    int number_scoops;
    String toppings;

    public IceCream(String name, float price, int id, int number_scoops, String toppings) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.number_scoops = number_scoops;
        this.toppings = toppings;
    }

}
