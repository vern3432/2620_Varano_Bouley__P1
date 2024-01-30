package com;
//43, Sundae, Vanilla, 3.75, 3, Peanut Butter

public class Item {
    String name=null;
    String typeOne=null;
    double Price=0.0;
    int quantity=0;
    String typetwo=null;
    


    public Item(String name, String typeOne, double price, int quantity, String typetwo) {
        this.name = name;
        this.typeOne = typeOne;
        Price = price;
        this.quantity = quantity;
        this.typetwo = typetwo;
    }
            



    @Override
    public String toString() {
        return "Item []";
    }
    
}
