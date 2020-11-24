package com.company;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void showMenu() {

        Connection con;

        try {
            con = new Connection("jdbc:mysql://localhost:3306/pizzasp3",
                    "root",
                    "hitman123");

            con.getMenuFromDatabase();

            for (int i = 0; i < con.pizzaMenu.size(); i++) {
                System.out.println(con.pizzaMenu.get(i));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}