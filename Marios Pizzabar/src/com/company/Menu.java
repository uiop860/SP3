package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Menu
{
    public void readMenu(int index)
    {

        String path = "";
        String line = "";
        BufferedReader br = null;
        String csvSplit = ",";
        if (index == 1)
        {
            path = "Menu.csv";
        }
        else if (index == 2)
        {
            path = "MenuIngredients.csv";
        }

        try
        {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
                String[] pizzas = line.split(csvSplit);
                if (index == 1)
                {
                    System.out.println(pizzas[0] + " " + pizzas[1] + " " + pizzas[2] + "kr.");
                }
                else if (index == 2)
                {
                    System.out.println(pizzas[0] + " " + pizzas[1] + " " + pizzas[2] + " " + pizzas[3] + "kr.");
                }

            }


        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }


        }
    }


    public void menuToArray()
    {

        String path = "Menu.csv";
        String line = "";
        BufferedReader br = null;
        String csvSplit = ",";

        try
        {
            List<String[]> arrayMenu = new ArrayList<String[]>();
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
                arrayMenu.add(line.split(csvSplit));
            }
            String[][] array = new String[arrayMenu.size()][0];
            arrayMenu.toArray(array);

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }


        }
    }
}

