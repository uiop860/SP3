package com.company;

import java.util.ArrayList;


public class Order  {

    public int orderID;
    public String pizza;
    public String name;
    public int phoneNumber;
    public String date;

    public Order(int orderID, String date, String pizza, String name, int phoneNumber) {
        this.orderID = orderID;
        this.pizza = pizza;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = date;

    }


    @Override
    public String toString() {
        return  "orderID: " + orderID +
                "\tname: " + name +
                "\tphoneNumber: " + phoneNumber +
                "\tpizza: " + pizza +
                "\tdate: " + date ;
    }

    public int getOrderID() {
        orderID = ++orderID;
        return orderID;
    }
}
