package com.dessert_shoppe;
import com.dessert_shoppe.GiftCard;
import com.dessert_shoppe.CreditCard;


public class User {
    double balance;

    User(String name,GiftCard gcard){


    }
    User(String name,CreditCard ccard){


    }
    public String toString(){

        return(""+this.balance);
    }


}
