package com.company;

public class Pizza implements Cloneable {

    public int pizzaNr;
    public String pizzaName;
    public String ingredients;
    public int price;

    public Pizza(int pizzaNr, String pizzaName, String ingredients, int price) {
        this.pizzaNr = pizzaNr;
        this.pizzaName = pizzaName;
        this.ingredients = ingredients;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Pizza nr. " + pizzaNr +
                "  " +pizzaName +
                "\t \t Ingredients: " + ingredients +
                " \tPrice:" + price + " Kr";
    }

    public Object clone() throws
            CloneNotSupportedException
    {
        return super.clone();
    }
}
