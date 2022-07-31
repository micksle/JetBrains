package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = scan.nextInt();
        int seats = rows * columns;

        int n = rows/2;
        int first = n * columns;
        int second = seats - first;
        int income;
        if (seats < 60) {
            income = seats*10;
        } else {
            income = (first * 10) + (second * 8);
        }

        System.out.println("Total income:");
        System.out.println("$"+income);
    }
}
