package com.company;

import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class Controller {

    private static Menu menu = new Menu();
    Order order;


    // ui interface



    static int orderId = 1;
    static ArrayList<Order> orderArr = new ArrayList();
    private static Order addedOrder;
    static Scanner scan = new Scanner(System.in);


    public static void showMenu() {

        boolean finish = false;

        while (!finish) {
            menu.loadPizzaData();
            System.out.println("1) Add a new order");
            System.out.println("2) Show menu");
            System.out.println("3) Show current orders");
            System.out.println("4) Remove and save order");
            System.out.println("9) Exit program");

            switch (scan.nextLine()) {
                case "1":
                    // Adding a new order

                    boolean isAlsoSuccessful =false;

                    Controller.addOrderTryCatch();
                    Controller.showMenu();

                    break;

                case "2":
                    System.out.println("-------------------------------------------");
                    for (int i = 0; i < menu.pizzaMenu.size(); i++) {
                        System.out.println(menu.pizzaMenu.get(i));
                    }
                    System.out.println("-------------------------------------------");

                    Controller.showMenu();

                    break;
                case "3":
                    System.out.println("-------------------------------------------");
                    for (Order order : orderArr) {
                        System.out.println(order);
                        System.out.println(order.getPizzas());




                    }
                    System.out.println("-------------------------------------------");
                    Controller.showMenu();

                    break;
                case"4":


                    System.out.println("-------------------------------------------");
                    System.out.println("Enter OrderId to remove order");
                    Controller.removeAndSaveOrder();
                    System.out.println("Order has been removed");
                    Controller.showMenu();

                    break;
                case "9":
                    System.out.println("-------------------------------------------");
                    System.out.println("Closing down the system");
                    System.out.println("-------------------------------------------");
                    break;
                    



            }
            finish=true;
        }
    }


    public static void removeAndSaveOrder(){


            }








    public static void addOrderController() {

        String input;


        System.out.println("Enter name, phonenumber");
        input = promptForAnswer();

        //Split input and convert string to int
        String[] strAnswer = input.split("\\s");

        //convert string to int
        int phoneNumber = Integer.parseInt(strAnswer[1]);



        Date date = new Date();
        Order tempOrder = new Order(orderId++,date.toString(),strAnswer[0],phoneNumber);

        addPizzaToOrder(tempOrder);

        orderArr.add(tempOrder);

        //Add order to array
        System.out.println("Order for " + strAnswer[0] + " added");


    }

    private static void addPizzaToOrder(Order tempOrder) {
        String input;
        System.out.println("Input pizza number. input 0 for exit");
        boolean finished = false;
        while (!finished) {
            input = promptForAnswer();
            int intInput = Integer.parseInt(input);

            if (intInput == 0){
                finished = true;
            } else {
                try {
                    tempOrder.addPizza((Pizza) menu.pizzaMenu.get(intInput - 1).clone());
                    System.out.println("Pizza added to order");
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static String promptForAnswer() {
        return scan.nextLine();
    }



    public static void addOrderTryCatch(){

        boolean isSuccessful = false;

        while (!isSuccessful) {
            try {
                Controller.addOrderController();
                isSuccessful = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Phone number and pizzaID must be a number");
                System.out.println("Try again");
            } catch (ArrayIndexOutOfBoundsException f) {
                System.out.println("Error: All fields must be filled");
                System.out.println("Try again");
            }
        }
    }


}


