package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        final int N = scan.nextInt();
        System.out.printf("For %d cups of coffee you will need:\n", N);
        final int water = 200;
        System.out.println((water * N) + " ml of water");
        final int milk = 50;
        System.out.println((milk * N) + " ml of milk");
        final int coffee = 15;
        System.out.println((coffee * N) + " g of coffee beans");
    }
}
