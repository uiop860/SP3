package com.company;

import java.io.*;
import java.util.ArrayList;


// @author Lukas
public class Menu {

    public ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    // @author Magnus
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
}

