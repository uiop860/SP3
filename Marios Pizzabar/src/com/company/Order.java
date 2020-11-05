package com.company;

import java.util.ArrayList;


public class Order  {

    public int orderID;
    public String pizza;
    public String name;
    public int phoneNumber;

    public Order(int orderID, String pizza, String name, int phoneNumber) {
        this.orderID = orderID;
        this.pizza = pizza;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }



    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", pizza='" + pizza + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }


    public int getOrderID() {
        orderID = ++orderID;
        return orderID;
    }
}
