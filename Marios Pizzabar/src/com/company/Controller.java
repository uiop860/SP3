package com.company;

import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class Controller {
    private static Menu menu = new Menu();


    // ui interface



    static int orderId = 0;
    static ArrayList<Order> orderArr = new ArrayList();
    private static Order addedOrder;
    static Scanner scan = new Scanner(System.in);


    public static void showMenu() {

        boolean finish = false;

        while (!finish) {
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

                    while(!isAlsoSuccessful) {
                        System.out.println("-------------------------------------------");
                        System.out.println("1) Add another pizza");
                        System.out.println("2) Finish your order");
                        if (scan.nextLine().equals("1")) {
                            Controller.addOrderTryCatch();

                        } else {
                            orderId = orderId + 1;
                            Controller.showMenu();
                            isAlsoSuccessful = true;
                        }
                    }

                    break;

                case "2":
                    System.out.println("-------------------------------------------");
                    menu.readMenu();
                    System.out.println("-------------------------------------------");

                    Controller.showMenu();

                    break;
                case "3":
                    System.out.println("-------------------------------------------");
                    for (int i = 0; i <orderArr.size() ; i++) {
                        System.out.println(orderArr.get(i));
                    }
                    System.out.println("-------------------------------------------");
                    Controller.showMenu();

                    break;
                case"4":

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



    public static void addOrder(String name, int phoneNumber, int pizzaIndex){

       // Menu menu = new Menu();
        menu.menuToArray();

        Date date = new Date();


        addedOrder = new Order(orderId,date.toString(),menu.getArray(pizzaIndex,1),name,phoneNumber);

        orderArr.add(addedOrder);
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


