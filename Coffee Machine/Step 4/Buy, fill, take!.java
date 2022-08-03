package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private final static int eWater = 250;                                                      // espresso ingredients requirements
    private final static int eMilk = 0;
    private final static int eCoffee = 16;
    private final static int ePrice = 4;

    private final static int lWater = 350;                                                      // latte ingredients requirements
    private final static int lMilk = 75;
    private final static int lCoffee = 20;
    private final static int lPrice = 7;

    private final static int cWater = 200;                                                      // cappuccino ingredients requirements
    private final static int cMilk = 100;
    private final static int cCoffee = 12;
    private final static int cPrice = 6;

    public static int initialWater = 400;                                                       // initial ingredients amount
    public static int initialMilk = 540;
    public static int initialCoffee = 120;
    public static int initialCups = 9;
    public static int initialMoney = 550;

    public static void main(String[] args) {
        menu();                                                                                 // calling the menu method
    }

    public static void menu() {                                                                 // menu method (driver method)
        Scanner scan = new Scanner(System.in);
        info();                                                                                 // current ingredients info
        System.out.println("Write action (buy, fill, take):");

        switch (scan.next()) {                                                                  // switch - case for user actions
            case "buy":
                buy();                                                                          // calling the method to buy the coffee
                break;
            case "fill":
                fill();                                                                         // calling the method to fill the machine
                break;
            case "take":
                take();                                                                         // calling the method to take money
                info();                                                                         // calling the method to print data
                break;
        }
    }

    public static void buy() {                                                                  // main method to buy the coffee
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");

        switch (scan.nextInt()) {                                                               // switch - case for coffee type
            case 1:
                buyCoffee(eWater, eMilk, eCoffee, ePrice);                                      // calling the universal method, to buy espresso
                break;
            case 2:
                buyCoffee(lWater, lMilk, lCoffee, lPrice);                                      // calling the universal method, to buy latte
                break;
            case 3:
                buyCoffee(cWater, cMilk, cCoffee, cPrice);                                      // calling the universal method, to buy cappuccino
                break;
        }
    }

    public static void buyCoffee(int typeWater, int typeMilk, int typeCoffee, int typePrice) {     // universal method to buy specific coffee
        initialWater -= typeWater;                                                              // calculating the ingredients and resources
        initialMilk -= typeMilk;                                                                // left after the buy - action
        initialCoffee -= typeCoffee;
        initialCups--;
        initialMoney += typePrice;
        info();                                                                                 // calling the method to show current ingredients info
    }

    public static void fill() {                                                                 // method to fill ingredients into machine
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        initialWater += scan.nextInt();                                                         // adding the resources
        System.out.println("Write how many ml of milk you want to add: ");
        initialMilk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        initialCoffee += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        initialCups += scan.nextInt();

        info();                                                                                 // calling the method to print the resources info
    }

    public static void take() {                                                                 // method to take the money
        System.out.println("I gave you " + initialMoney + "\n");
        initialMoney = 0;
    }

    public static void info() {                                                                 // method to print the info
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", initialWater);
        System.out.printf("%d ml of milk\n", initialMilk);
        System.out.printf("%d g of coffee beans\n", initialCoffee);
        System.out.printf("%d disposable cups\n", initialCups);
        System.out.printf("$%d of money\n", initialMoney);
        System.out.println();
    }
}
