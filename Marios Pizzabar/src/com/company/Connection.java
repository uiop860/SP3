package com.company;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class Connection implements AutoCloseable {


    public ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    private final String db_url;
    private final String db_user;
    private final String db_password;
    private java.sql.Connection con;

    private PreparedStatement importMenuFromDatabase;
    private PreparedStatement importOrderIDFromDatabase;
    private PreparedStatement insertOrderIntoDatabase;
    private PreparedStatement insertPizzasIntoDatabase;


    public Connection(String db_url, String db_user, String db_password) throws SQLException
    {
        this.db_url = db_url;
        this.db_user = db_user;
        this.db_password = db_password;
        prepareConnection();
    }
    @Override
    public void close() throws Exception
    {
        con.close();
    }


    public void getMenuFromDatabase()
    {

        try(ResultSet rs = importMenuFromDatabase.executeQuery())
        {
            while (rs.next())
            {
                int menuPizzaNR = rs.getInt(1);
                String menuPizzaName = rs.getString(2);
                String menuIngredients = rs.getString(3);
                int menuPrice = rs.getInt(4);
                pizzaMenu.add(new Pizza(menuPizzaNR,menuPizzaName,menuIngredients,menuPrice));

            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int getOrderIDFromDatabase (){

        int orderID= 0;
        try
        {
            try(ResultSet rs = importOrderIDFromDatabase.executeQuery())
            {
                while (rs.next())
                {
                    orderID = rs.getInt(1);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return orderID;

    }

    public void insertOrderIntoDatabase(String name,int phoneNumber){

        try
        {
            insertOrderIntoDatabase.setString(1,name);
            insertOrderIntoDatabase.setInt(2,phoneNumber);

            if (insertOrderIntoDatabase.executeUpdate() != 1)
            {
                System.out.println("Error");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void insertPizzasIntoDatabase (int pizzaNR, String pizzaName, String ingredients, int pizzaPrice, int orderID){

        try
        {
            insertPizzasIntoDatabase.setInt(1,pizzaNR);
            insertPizzasIntoDatabase.setString(2,pizzaName);
            insertPizzasIntoDatabase.setString(3,ingredients);
            insertPizzasIntoDatabase.setInt(4,pizzaPrice);
            insertPizzasIntoDatabase.setInt(5,orderID);

            if (insertPizzasIntoDatabase.executeUpdate() != 1)
            {
                System.out.println("Error");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }


    private void prepareConnection() throws SQLException
    {
        con = DriverManager.getConnection(db_url, db_user, db_password);

        importMenuFromDatabase = con.prepareStatement("SELECT * FROM pizzasp3.pizzamenu");
        importOrderIDFromDatabase = con.prepareStatement("SELECT OrderID FROM pizzasp3.savedpizzaorders ORDER BY OrderID DESC LIMIT 1");
        insertOrderIntoDatabase = con.prepareStatement("INSERT INTO pizzasp3.savedpizzaorders (CustomerName,CustomerPhoneNumber) VALUES (?,?)");
        insertPizzasIntoDatabase = con.prepareStatement("INSERT INTO pizzaorder(PizzaNR,PizzaName,Ingredients,Price,Saved_pizza_orders_orderID) VALUES (?,?,?,?,?)");


    }
}
