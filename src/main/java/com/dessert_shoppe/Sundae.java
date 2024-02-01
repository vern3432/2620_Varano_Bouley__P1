package com.dessert_shoppe;

public class Sundae extends item {

    String name;
    Float price;
    int id;

    int number_scoops;

    public Sundae(String name, Float price, int id, int number_scoops) {
        super(name, price, id, number_scoops, topping);

    }

}
