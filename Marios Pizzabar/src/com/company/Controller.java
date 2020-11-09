package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Controller {

    private static Scanner scan = new Scanner(System.in);
    private static Menu menu = new Menu();
    private static ArrayList<Order> orderArr = new ArrayList();
    public static int orderId = 1;


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
                        order.pizzaArrPrinter();

                    }
                    System.out.println("-------------------------------------------");
                    Controller.showMenu();

                    break;
                case"4":


                    System.out.println("-------------------------------------------");
                    System.out.println("Enter OrderId to remove order");
                    Controller.removeAndSaveOrder(Integer.parseInt(Controller.promptForAnswer()));
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


    public static void removeAndSaveOrder(int orderIdInput){

        Predicate<Order> condition = orderArr -> orderArr.getOrderID() == orderIdInput;

        for (int i = 0; i < orderArr.size(); i++) {
            if (orderArr.get(i).getOrderID() == orderIdInput){
                try {
                    FileWriter myWriter = new FileWriter("testFile.txt");
                    for (int j = 0; j < orderArr.get(i).getPizzasLength() ; j++) {
                        myWriter.write(orderArr.get(i).getPizzasAsString(j)+"\n");
                    }
                    myWriter.close();

                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                orderArr.removeIf(condition);
            }
        }
//





    }


    public static void addOrderTryCatch(){

        boolean isSuccessful = false;

        while (!isSuccessful) {
            try {
                Controller.addOrderController();
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

    public static void addOrderController() {

        String input;
        Date date = new Date();


        System.out.println("Enter name, phonenumber");
        input = promptForAnswer();

        //Split input
        String[] strAnswer = input.split("\\s");

        //convert string to int
        int phoneNumber = Integer.parseInt(strAnswer[1]);

        Order tempOrder = new Order(orderId++,date.toString(),strAnswer[0],phoneNumber);
        addPizzaToOrder(tempOrder);
        orderArr.add(tempOrder);
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

}


