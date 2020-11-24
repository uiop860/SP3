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

        try
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
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }


    private void prepareConnection() throws SQLException
    {
        con = DriverManager.getConnection(db_url, db_user, db_password);

        importMenuFromDatabase = con.prepareStatement("SELECT * FROM pizzasp3.pizzamenu");


    }
}
