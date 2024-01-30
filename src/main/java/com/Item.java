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
            

    public String getName() {
        return name;
    }




    public String getTypeOne() {
        return typeOne;
    }




    public double getPrice() {
        return Price;
    }




    public int getQuantity() {
        return quantity;
    }




    public String getTypetwo() {
        return typetwo;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", typeOne=" + typeOne + ", Price=" + Price + ", quantity=" + quantity
                + ", typetwo=" + typetwo + "]"+"\n\n";
    }


    
}
