package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Menu {

    public String[][] array;
    public ArrayList<Pizza> pizzaMenu = new ArrayList<>();


    public void loadPizzaData() {

        String path = "MenuIngredients.csv";
        String line = "";
        BufferedReader br = null;
        String csvSplit = ",";

        try {
            br = new BufferedReader(new FileReader(path));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] pizzas = line.split(csvSplit);
//                System.out.println(pizzas[0] + " " + pizzas[1] + " " + pizzas[2] + " " + pizzas[3] + " Kr.");

                int id = Integer.parseInt(pizzas[0]);
                String name = pizzas[1];
                String ingredients = pizzas[2];
                int price = Integer.parseInt(pizzas[3]);
                Pizza pizza = new Pizza(id,name,ingredients,price);
                pizzaMenu.add(pizza);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }


//    public void menuToArray() {
//
//        String path = "Menu.csv";
//        String line = "";
//        BufferedReader br = null;
//        String csvSplit = ",";
//
//        try {
//            List<String[]> arrayMenu = new ArrayList<String[]>();
//            br = new BufferedReader(new FileReader(path));
//            while ((line = br.readLine()) != null) {
//                arrayMenu.add(line.split(csvSplit));
//            }
//            array = new String[arrayMenu.size()][0];
//            arrayMenu.toArray(array);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//
//        }
//    }


    public String getArray(int a, int b) {
        return array[a][b];
    }

}

