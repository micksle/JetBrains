package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = scan.nextInt();
        String[][] seats = new String[rows+1][columns+1];
        System.out.println();

        int seatRow = 0;
        int seatColumn = 0;
        boolean exit = false;
        while(!exit) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            int action = scan.nextInt();

            switch (action){
                case 1:
                    showSeats(rows, columns, seats, seatRow, seatColumn);
                    break;
                case 2:
                    System.out.println("Enter a row number:");
                    seatRow = scan.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    seatColumn = scan.nextInt();
                    System.out.println();
                    buyTicket(rows, columns, seatRow, seatColumn);
                    break;
                case 0:
                    exit = true;
            }
            System.out.println();
        }
    }

    public static void showSeats(int rows, int columns, String[][] seats, int seatRow, int seatColumn) {
        System.out.println("Cinema:");
        for (int i = 0; i < rows+1; i++) {
            for (int j = 0; j < columns+1; j++) {
                if (i == 0 && j == 0) {
                    seats[i][j] = " ";
                } else if (j == 0){
                    seats[i][j] = String.valueOf(i);
                } else if (i == 0){
                    seats[i][j] = String.valueOf(j);
                } else if (i == seatRow && j == seatColumn) {
                    seats[i][j] = "B";
                } else if (seats[i][j] != null && seats[i][j].equals("B")){
                    seats[i][j] = "B";
                } else {
                    seats[i][j] = "S";
                }
                System.out.print(seats[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void buyTicket(int rows, int columns, int seatRow, int seatColumn) {
        int totalSeats = rows * columns;
        int n = rows/2;
        int price;
        if (totalSeats < 60 || seatRow <= n) {
            price = 10;
        } else {
            price = 8;
        }
        System.out.println("Ticket price: $"+price);

    }

}
