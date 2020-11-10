package com.company;


import java.util.ArrayList;

public class Order  {

    public int orderID;
    public String name;
    public int phoneNumber;
    public String date;
    private ArrayList<Pizza> pizzas = new ArrayList();

    public Order(int orderID, String date, String name, int phoneNumber) {
        this.orderID = orderID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = date;

    }

    @Override
    public String toString() {
        return  "orderID: " + orderID +
                "\tname: " + name +
                "\tphoneNumber: " + phoneNumber +
                "\tdate: " + date ;
    }

    public int getOrderID() {
        return orderID;
    }

    public void pizzaArrPrinter(){
        for (Pizza pizza : pizzas) {
            System.out.println("\t"+pizza.toString());
        }
    }

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }

    public int getPizzasLength(){
        return pizzas.size();
    }

    public String getPizzasAsString(int i){
        return pizzas.get(i).csvString();
    }


}
