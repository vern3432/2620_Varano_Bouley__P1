package com.dessert_shoppe;

public class Sundae extends item {

    String name;
    Float price;
    int id;

    int number_scoops;

    public Sundae(String name, Float price, int id, int number_scoops) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.number_scoops = number_scoops;

    }

}
