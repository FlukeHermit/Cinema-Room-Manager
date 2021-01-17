package cinema;
import java.util.*;

public class Cinema {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int numberOfRows = sc.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int numberOfSeatsPerRow = sc.nextInt();
        
        String[][] seatMap = new String[numberOfRows + 1][numberOfSeatsPerRow + 1]; 

        int numberOfSeats = numberOfRows * numberOfSeatsPerRow;

        generate(numberOfRows, numberOfSeatsPerRow, seatMap); 

        System.out.println();

        System.out.println("Enter a row number:");
        int rowNumber = sc.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seatNumber = sc.nextInt();

        sc.close();

        seatMap[rowNumber][seatNumber] = " B";
        int price = ticketPrice(numberOfSeats, numberOfRows, rowNumber);
        System.out.println();
        System.out.printf("Ticket price: $%d", price);
        System.out.println();
        printSeat(numberOfRows, numberOfSeatsPerRow, seatMap);
    
    }

    public static void generate(int row, int column, String[][] seatMap) {
        System.out.println("Cinema:");
        for (int i = 0; i < row + 1; i++) {
            for (int j = 0; j < column + 1; j++) {
                if (i == 0 && j == 0) {
                    seatMap[i][j] = " ";
                    System.out.print(seatMap[i][j]);
                
                } else if (i == 0) {
                    seatMap[i][j] = " " + Integer.toString(j);
                    System.out.print(seatMap[i][j]);
                } else if (j == 0) {
                    seatMap[i][j] = Integer.toString(i);
                    System.out.print(seatMap[i][j]);
                } else {
                    seatMap[i][j] = " S";
                    System.out.print(seatMap[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void printSeat(int row, int column, String[][] seatMap) {
        System.out.println("Cinema:");
        for (int i = 0; i < row + 1; i++) {
            for (int j = 0; j < column + 1; j++) {
                System.out.print(seatMap[i][j]);
            }
            System.out.println();
        }
    }

    public static int ticketPrice(int n, int rows, int rowNum) {
        int ticketPrice;
        if (n <= 60) {
            ticketPrice = 10;
            return ticketPrice;
        } else {
            int midRow = rows >> 1;
            ticketPrice = rowNum <= midRow ? 10 : 8;
            return ticketPrice;
        }
    }

    
}        
