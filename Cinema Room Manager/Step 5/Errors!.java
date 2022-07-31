package cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        menu();                                                                 // menu method call
    }

    public static void menu() {
        Scanner scan = new Scanner(System.in);
        String[][] seats = createSeats();                                       // calling the method to create the array - representation of the room 
        boolean exit = false;                                                   // flag to end the program

        while (!exit) {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            switch (scan.nextInt()) {
                case 1:
                    print(seats);                                               // call the method to print the representation of the room
                    break;
                case 2:
                    buy(seats);                                                 // call the method to buy the tickets
                    break;
                case 3:
                    statistics(seats);                                          // call the method to calculating and printing the statistics
                    break;
                case 0:
                    exit = true;                                                // end the program
                    break;
            }
        }
    }

    public static void buy(String[][] seats) {                                  // method to buy the tickets
        Scanner scan = new Scanner(System.in);

        int rows = seats.length - 1;                                            // cinema rows amount
        int columns = seats[0].length - 1;                                      // cinema columns amount

        int seatRow = 0;                                                        // initial values
        int seatColumn = 0;
        boolean exit = false;

        while (!exit) {
            exit = true;                                                        // if no mistakes on choosing the seat provided - exit after the purchase
            System.out.println("\nEnter a row number:");
            seatRow = scan.nextInt();                                           // desired seat row
            System.out.println("Enter a seat number in that row:");
            seatColumn = scan.nextInt();                                        // desired seat in that row
            System.out.println();

            if (seatRow > rows || seatColumn > columns) {                       // if index is out of bounds - re-purchase
                System.out.println("Wrong input!\n");
                exit = false;                                                   
            } else if (seats[seatRow][seatColumn].equals("B")) {                // if seat is taken - re-purchase
                System.out.println("That ticket has already been purchased!\n");
                exit = false;
            }
        }
        int price = count(seats, seatRow);                                      //  call the method to count the price of the seat
        System.out.println("Ticket price: $" + price);

        seats[seatRow][seatColumn] = "B";                                       // mark the chosen seat as "taken"
    }

    public static int count(String[][] seats, int seatRow) {                    // method to count the price of the seat
        int rows = seats.length - 1;                                            // rows in the cinema
        int columns = seats[0].length - 1;                                      // seats in each row in the cinema

        int totalSeats = rows * columns;                                        // total seats amount
        int half = rows / 2;                                                    // front half of the rows
        int price;                                                              // price of the ticket
        if (totalSeats <= 60) {                                                 // if amount of seats is less than 60, then the price is $10 per ticket
            price = 10;
        } else if (seatRow <= half) {                                           // else if the chosen seat row is on the front half - the price is $10 per ticket
            price = 10;
        } else {                                                                // else the price is $8 per ticket
            price = 8;
        }
        return price;
    }

    public static void statistics(String[][] seats) {
        int rows = seats.length - 1;                                            // rows in the cinema
        int columns = seats[0].length - 1;                                      // seats in each row in the cinema
        int totalSeats = rows * columns;                                        // total seats amount
        int half = rows / 2;                                                    // front half of the rows
        int frontHalf = half * columns;                                         // front half seats amount
        int backHalf = totalSeats - frontHalf;                                  // back half seats amount

        int totalIncome;                                                        // max possible income, counting by || number of seats * ticket price for this seat ||
        if (totalSeats <= 60) {
            totalIncome = totalSeats * 10;
        } else {
            totalIncome = (frontHalf * 10) + (backHalf * 8);
        }

        int income = 0;                                                         // current income
        int purchased = 0;                                                      // purchased tickets amount
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[i][j].equals("B")) {                                  // if the seat is marked as "booked", then amount of purchased tickets += 1
                    purchased++;
                    if (totalSeats <= 60) {                                     // finding out the ticket price
                        income += 10;
                    } else if (i <= half) {
                        income += 10;
                    } else {
                        income += 8;
                    }
                }
            }
        }
        double percentage = (double) (100 * purchased) / totalSeats;            // percentage of the booked seats from the total number of seats

        System.out.println("\nNumber of purchased tickets: " + purchased);      // printing the received info 
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Current income: $" + income);
        System.out.println("Total income: $" + totalIncome);
    }

    public static String[][] createSeats() {                                    // method to create the cinema room
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt() + 1;                                          // rows number
        System.out.println("Enter the number of seats in each row:");
        int columns = scan.nextInt() + 1;                                       // seats number in each row            
        String[][] seats = new String[rows][columns];

        for (int i = 0; i < rows; i++) {                                        // filling the initial info about the room (all the seats are non-booked)
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j == 0) {
                    seats[i][j] = " ";
                } else if (j == 0) {
                    seats[i][j] = String.valueOf(i);
                } else if (i == 0) {
                    seats[i][j] = String.valueOf(j);
                } else {
                    seats[i][j] = "S";
                }
            }
        }
        return seats;
    }

    public static void print(String[][] seats) {                                // method to print the cinema room
        System.out.println("\nCinema:");
        for (String[] seat : seats) {                                           // enhanced loop for the rows
            for (String s : seat) {                                             // enhanced loop for the columns
                System.out.print(s + " ");                                      // printing the state of the current seat
            }
            System.out.println();
        }
    }
}
