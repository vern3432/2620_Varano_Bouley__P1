package com.dessert_shoppe;



public class User {
    double balance;
    Card userPaymentMethod;

    User(String name,GiftCard gcard){
        this.userPaymentMethod=gcard;


    }
    User(String name,CreditCard ccard){
        this.userPaymentMethod=ccard;



    }
    public String toString(){

        return(""+this.balance);
    }


}
