package com;
//43, Sundae, Vanilla, 3.75, 3, Peanut Butter

public class Item {
    protected String name = null;
    protected String typeOne = null;
    protected double price = 0.0;
    protected int number_scoops = 0;
    protected String topping = null;
    protected int quant = 0;

    public Item(String name, String typeOne, double price, int number_scoops, String topping, int quant) {
        this.name = name;
        this.typeOne = typeOne;
        this.price = price;
        this.number_scoops = number_scoops;
        this.topping = topping;
        this.quant = quant;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getQuant() {
        return quant;
    }

    public String getName() {
        return name;
    }

    public String getTypeOne() {
        return typeOne;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber_scoops() {
        return number_scoops;
    }

    public String gettopping() {
        return topping;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", typeOne=" + typeOne + ", Price=" + price + ", number_scoops=" + number_scoops
                + ", topping=" + topping + ", quant=" + quant + "]" + "\n\n";
    }

}
