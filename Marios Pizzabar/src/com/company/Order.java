package com.company;


import java.util.ArrayList;

public class Order  {

    public int orderID;
    public String name;
    public int phoneNumber;
    public String date;
    private ArrayList<Pizza> Pizzas = new ArrayList();

    public Order(int orderID, String date, String name, int phoneNumber) {
        this.orderID = orderID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = date;

    }


    public int getOrderID() {
        return orderID;
    }

    public ArrayList<Pizza> getPizzas() {

        return Pizzas;
    }

    public void addPizza(Pizza pizza){
        Pizzas.add(pizza);

    }


}
