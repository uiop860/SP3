package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Menu
{

    public String[][] array;
    public void readMenu(int index)
    {

        String path = "MenuIngredients.csv";
        String line = "";
        BufferedReader br = null;
        String csvSplit = ",";

        try
        {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
                String[] pizzas = line.split(csvSplit);
                System.out.println(pizzas[0] + " " + pizzas[1] + " " + pizzas[2] + " " + pizzas[3] + "kr.");

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
            array = new String[arrayMenu.size()][0];
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


    public String getArray(int a, int b) {
        return array[a][b];
    }
}

