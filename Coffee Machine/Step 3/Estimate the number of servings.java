package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private final static int WATER = 200;                                                       // constant ingredient values
    private final static int MILK = 50;
    private final static int COFFEE = 15;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        final int waterCapacity = scan.nextInt();                                               // the number of ingredients machine has
        System.out.println("Write how many ml of milk the coffee machine has: ");
        final int milkCapacity = scan.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        final int coffeeCapacity = scan.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        final int amount = scan.nextInt();                                                      // amount of cups needed

        int waterNeeded = amount * WATER;                                                       // number of ingredients needed
        int milkNeeded = amount * MILK;
        int coffeeNeeded = amount * COFFEE;

        int waterLeft = (waterCapacity - waterNeeded);                                          // number of ingredients left after making the order
        int milkLeft = (milkCapacity - milkNeeded);
        int coffeeLeft = (coffeeCapacity - coffeeNeeded);

        int waterMinAble = waterCapacity / WATER;                                               // the min number of cups machine able to make
        int milkMinAble = milkCapacity / MILK;
        int coffeeMinAble = coffeeCapacity / COFFEE;
        int minAble = waterMinAble;

        if (milkMinAble < minAble) {                                                            // choosing the min cups value
            minAble = milkMinAble;
        }
        if (coffeeMinAble < minAble) {
            minAble = coffeeMinAble;
        }

        if (waterLeft < 0 ||  milkLeft < 0 || coffeeLeft < 0) {                                 // if not enough ingredients then print max able amount
            System.out.printf("No, I can make only %d cup(s) of coffee\n", minAble);
            return;
        }

        if (waterLeft < WATER ||  milkLeft < MILK || coffeeLeft < COFFEE) {                     // else if the number of ingredients is enough
            System.out.println("Yes, I can make that amount of coffee");                        // to the number of cups ordered, print that info
            return;
        }

        int waterAble = waterLeft / WATER;                                                      // if the number of ingredients is even more
        int milkAble = milkLeft / MILK;                                                         // count max possible number of cups to be made
        int coffeeAble = coffeeLeft / COFFEE;
        int maxAble = waterAble;

        if (milkAble < maxAble) {                                                               // chose the right amount of cups depending on
            maxAble = milkAble;                                                                 // the available number of ingredients
        }
        if (coffeeAble < maxAble) {
            maxAble = coffeeAble;
        }
                                                                                                // print that data
        System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", maxAble);
    }
}
