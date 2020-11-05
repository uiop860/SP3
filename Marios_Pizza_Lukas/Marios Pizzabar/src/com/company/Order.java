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

    public ArrayList<Order> orderArr = new ArrayList();

    public void addOrder(String name, int phoneNumber, int pizzaIndex){

        Menu menu = new Menu();
        menu.menuConstructor();

        int orderId = 1;

        Order test = new Order(1,menu.getMenuArr().get(1).toString(),"Susanne",20139103);
        orderArr.add(test);
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
