package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Controller {

    private  Scanner scan = new Scanner(System.in);
    private  ArrayList<Order> orderArr = new ArrayList();
    private Connection con;
    private int orderID = 0;


    // @author Magnus
    public void showMenu() throws Exception {

        try {
            con = new Connection ("jdbc:mysql://localhost:3306/pizzasp3",
                    "root",
                    "hitman123");

            con.getMenuFromDatabase();
            orderID = con.getOrderIDFromDatabase() + 1;




            boolean finish = false;


            while (!finish) {
                System.out.println("-------------------------------------------");
                System.out.println("1) Add a new order");
                System.out.println("2) Show menu");
                System.out.println("3) Show current orders");
                System.out.println("4) Remove and save order");
                System.out.println("9) Exit program");
                System.out.println("-------------------------------------------");

                switch (scan.nextLine()) {
                    case "1":

                        addOrderTryCatch();
                        orderID += 1;

                        break;

                    case "2":
                        System.out.println("-------------------------------------------");
                        for (int i = 0; i < con.pizzaMenu.size(); i++) {
                            System.out.println(con.pizzaMenu.get(i));
                        }
                        System.out.println("-------------------------------------------");



                        break;
                    case "3":
                        System.out.println("-------------------------------------------");
                        for (Order order : orderArr) {
                            System.out.println(order);
                            order.pizzaArrPrinter();
                        }
                        System.out.println("-------------------------------------------");


                        break;
                    case"4":


                        System.out.println("-------------------------------------------");
                        System.out.println("Enter OrderId to remove order");
                        removeAndSaveOrder(Integer.parseInt(promptForAnswer()));
                        System.out.println("Order has been removed");
                        System.out.println("-------------------------------------------");


                        break;
                    case "9":
                        System.out.println("-------------------------------------------");
                        System.out.println("Closing down the system");
                        System.out.println("-------------------------------------------");
                        con.close();
                        finish=true;
                        break;
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    // @author Aleksander
    public void removeAndSaveOrder(int orderIdInput) {

        Predicate<Order> condition = orderArr -> orderArr.getOrderID() == orderIdInput;

        for (int i = 0; i < orderArr.size(); i++) {
            if (orderArr.get(i).getOrderID() == orderIdInput){
                con.insertOrderIntoDatabase(orderArr.get(i).getName(),orderArr.get(i).getPhoneNumber());
                for (int j = 0; j < orderArr.get(i).getPizzasLength(); j++) {
                    con.insertPizzasIntoDatabase(orderArr.get(i).getPizzas(j).getPizzaNr(),orderArr.get(i).getPizzas(j).getPizzaName(),
                            orderArr.get(i).getPizzas(j).getIngredients(),orderArr.get(i).getPizzas(j).getPrice(),orderIdInput);
                }



                }
                orderArr.removeIf(condition);
            }
        }


    // @author Lukas
    public void addOrderTryCatch(){

        boolean isSuccessful = false;

        while (!isSuccessful) {
            try {
                addOrderController();
                isSuccessful = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Phone number must be a number");
                System.out.println("Try again");
            } catch (ArrayIndexOutOfBoundsException f) {
                System.out.println("Error: All fields must be filled");
                System.out.println("Try again");
            }
        }
    }



    // @author magnus
    public void addOrderController() {

        Date date = new Date();

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String currentDate = simpleDateFormat.format(new Date());


        System.out.println("Enter name, phonenumber");
        String input = promptForAnswer();

        //Split input
        String[] strAnswer = input.split("\\s");

        //convert string to int
        int phoneNumber = Integer.parseInt(strAnswer[1]);

        Order tempOrder = new Order(orderID,date.toString(),strAnswer[0],phoneNumber);

        boolean successful = false;
        while(!successful){
            try {
                addPizzaToOrder(tempOrder);
                successful = true;
            }catch (Exception e){
                System.out.println("Sicke thats the wrong number");
            }
        }
        System.out.println("Enter pickup time");
        int pickupTime = Integer.parseInt(promptForAnswer());

        tempOrder.setPickupTime(pickupTime);



        orderArr.add(tempOrder);
        System.out.println("Order for " + strAnswer[0] + " added");


    }

    // @author Oliver
    private void addPizzaToOrder(Order tempOrder) {
        String input;
        boolean finished = false;
        System.out.println("Input pizza number. input 0 for exit");

        while (!finished) {
            input = promptForAnswer();
            int  intInput = Integer.parseInt(input);
            if (intInput == 0){
                finished = true;
            } else {
                try {
                    tempOrder.addPizza((Pizza) con.pizzaMenu.get(intInput - 1).clone());
                    System.out.println("Pizza added to order");
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // @author Aleksander
    public String promptForAnswer() {
        return scan.nextLine();
    }


}


