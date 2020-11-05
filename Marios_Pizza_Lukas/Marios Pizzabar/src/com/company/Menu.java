package com.company;

import java.util.ArrayList;

public class Menu {

    public ArrayList<Pizza> menuArr = new ArrayList<>();

    public void menuConstructor(){
        Pizza pizza1 = new Pizza(1,"Vesuvio","Tomatsauce, ost, oregano, skinke ",57);
        Pizza pizza2 = new Pizza(2,"Amerikaner","Tomatsauce, ost, oregano, oksefars ", 53);
        Pizza pizza3 = new Pizza(3, "Cacciatore","Tomatsauce, ost, oregano, pepperoni",57 );
        Pizza pizza4 = new Pizza(4,"Carbona", "Tomatsauce, ost, oregano, kødsauce, spaghetti, cocktailpølser",63);
        Pizza pizza5 = new Pizza(5,"Dennis", "Tomatsauce, ost, oregano, pepperoni, cocktailpølser",65);
//        Pizza pizza6 = new Pizza(6,);
//        Pizza pizza7 = new Pizza(7, );
//        Pizza pizza8 = new Pizza(8, );
//        Pizza pizza9 = new Pizza(9,);
//        Pizza pizza10 = new Pizza(10,);
//        Pizza pizza11 = new Pizza(11,);
//        Pizza pizza12 = new Pizza(12,);
//        Pizza pizza13 = new Pizza(13,);
//        Pizza pizza14 = new Pizza(14,);



        menuArr.add(pizza1);
        menuArr.add(pizza2);
        menuArr.add(pizza3);
        menuArr.add(pizza4);
        menuArr.add(pizza5);


    }

    public ArrayList<Pizza> getMenuArr() {
        return menuArr;
    }
}
