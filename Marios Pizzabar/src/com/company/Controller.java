package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Controller {

    // ui interface


    static Scanner scan = new Scanner(System.in);


    public static void showMenu() {

        boolean finish = false;

        while (!finish) {
            System.out.println("Press '1' to place a new order, or '2' to remove an existing order");
            switch (scan.nextLine()) {
                case "1":
                    // Adding a new order
                    boolean isSuccessful = false;

                    while (!isSuccessful) {
                        try {
                            Controller.addOrderController();
                            System.out.println("1) Add a new order");
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

                    // remove an existing order


            }
            finish=true;
        }
    }

    public static void addOrderController() {

        String tempOrder;


        System.out.println("Enter name, phonenumber and pizzaId");
        tempOrder = promptForAnswer();

        //Split input and convert string to int
        String[] strAnswer = tempOrder.split("\\s");

        //convert string to int
        int[] intAnswer = new int[2];
        intAnswer[0] = Integer.parseInt(strAnswer[1]);
        intAnswer[1] = Integer.parseInt(strAnswer[2]);


        addOrder(strAnswer[0],intAnswer[0],intAnswer[1]);
        //create a new order from the input
        //order.addOrder();
        System.out.println("Order for " + strAnswer[0] + " added");

/*        //test if order is created
        System.out.println(order.orderArr.get(0).toString());
        Controller.showMenu();*/
    }


    public static String promptForAnswer() {
        return scan.nextLine();
    }

    static ArrayList<Order> orderArr = new ArrayList();

    public static void addOrder(String name, int phoneNumber, int pizzaIndex){

        Menu menu = new Menu();
        menu.menuConstructor();

        int orderId = 1;

        Order test = new Order(1,menu.getMenuArr().get(pizzaIndex).toString(),name,phoneNumber);
        orderArr.add(test);
    }


}
