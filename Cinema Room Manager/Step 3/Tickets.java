package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = scan.nextInt();
        System.out.println();

        System.out.println("Cinema:");
        String[][] seats = new String[rows+1][columns+1];
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < columns + 1; j++) {
                if (i == 0 && j == 0) {
                    seats[i][j] = " ";
                } else if (j == 0){
                    seats[i][j] = String.valueOf(i);
                } else if (i == 0){
                    seats[i][j] = String.valueOf(j);
                } else {
                    seats[i][j] = "S";
                }
                System.out.print(seats[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Enter a row number:");
        int seatRow = scan.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatColumn = scan.nextInt();
        System.out.println();

        int totalSeats = rows * columns;
        int n = rows/2;
        int price;
        if (totalSeats < 60 || seatRow <= n) {
            price = 10;
        } else {
            price = 8;
        }

        System.out.println("Ticket price: $"+price);
        System.out.println();

        System.out.println("Cinema:");
        for (int i = 0; i < rows+1; i++) {
            for (int j = 0; j < columns + 1; j++) {
                if (i == 0 && j == 0) {
                    seats[i][j] = " ";
                } else if (j == 0){
                    seats[i][j] = String.valueOf(i);
                } else if (i == 0){
                    seats[i][j] = String.valueOf(j);
                } else if (i == seatRow && j == seatColumn) {
                    seats[i][j] = "B";
                } else {
                    seats[i][j] = "S";
                }
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
}
