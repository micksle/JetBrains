package cinema;

public class Cinema {
    public static void main(String[] args) {
        System.out.println("Cinema:");
        String[][] seats = new String[8][9];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
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
    }
}
