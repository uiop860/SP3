package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Controller {


    // ui interface




    private static Order addedOrder;
    static Scanner scan = new Scanner(System.in);


    public static void showMenu() {

        boolean finish = false;

        while (!finish) {
            System.out.println("1) Add a new order");
            System.out.println("2) Show menu");
            System.out.println("3) Show current orders");
            System.out.println("4) Remove order and save order");

            switch (scan.nextLine()) {
                case "1":
                    // Adding a new order
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

                    Controller.showMenu();
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case"4":

                    break;
                    



            }
            finish=true;
        }
    }

    public static void addOrderController() {

        String tempOrder;


        System.out.println("Enter name, phonenumber and pizza nr.");
        tempOrder = promptForAnswer();

        //Split input and convert string to int
        String[] strAnswer = tempOrder.split("\\s");

        //convert string to int
        int[] intAnswer = new int[2];
        intAnswer[0] = Integer.parseInt(strAnswer[1]);
        intAnswer[1] = Integer.parseInt(strAnswer[2]);


        //Add order to array
        addOrder(strAnswer[0],intAnswer[0],intAnswer[1]);
        System.out.println("Order for " + strAnswer[0] + " added");


    }


    public static String promptForAnswer() {
        return scan.nextLine();
    }

    static ArrayList<Order> orderArr = new ArrayList();

    public static void addOrder(String name, int phoneNumber, int pizzaIndex){

        Menu menu = new Menu();
        menu.menuToArray();


        int orderId = 1;

        addedOrder = new Order(1,menu.getArray(pizzaIndex,1),name,phoneNumber);
        orderArr.add(addedOrder);
    }


}
