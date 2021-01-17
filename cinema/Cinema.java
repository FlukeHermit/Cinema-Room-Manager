package cinema;
import java.util.*;

public class Cinema {

    public static Scanner sc = new Scanner(System.in);
    static int numberOfRows;
    static int numberOfSeatsPerRow;
    static int choice;
    static String[][] seatMap;
    static int numberOfSeats;
    static int purchasedTickets;
    static int rowNumber;
    static int seatNumber;


    public static void main(String[] args) {


        System.out.println("Enter the number of rows:");
        numberOfRows = sc.nextInt();

        System.out.println("Enter the number of seats in each row:");
        numberOfSeatsPerRow = sc.nextInt();
        seatMap = new String[numberOfRows + 1][numberOfSeatsPerRow + 1]; 

        generate(numberOfRows, numberOfSeatsPerRow, seatMap); 

        do {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            choice = sc.nextInt();
        } while (takeAction(choice));
  
    }

    public static boolean takeAction(int choice) {
        switch (choice) {
            case 1:
                printSeat(numberOfRows, numberOfSeatsPerRow, seatMap);
                break;
            case 2:
                ticketPrice();
                break;
            case 3:
                statistics();
                break;
            case 0:
                return false;
            default:
                System.out.println("Invalid input");
                break;
        }
        return true;
    }    

    public static void generate(int row, int column, String[][] seatMap) {

        for (int i = 0; i < row + 1; i++) {
            for (int j = 0; j < column + 1; j++) {
                if (i == 0 && j == 0) {
                    seatMap[i][j] = " ";
                
                } else if (i == 0) {
                    seatMap[i][j] = " " + Integer.toString(j);
                } else if (j == 0) {
                    seatMap[i][j] = Integer.toString(i);
                } else {
                    seatMap[i][j] = " S";
                }
            }
        }
    }

    public static void printSeat(int row, int column, String[][] seatMap) {
        System.out.println("\nCinema:");
        for (int i = 0; i < row + 1; i++) {
            for (int j = 0; j < column + 1; j++) {
                System.out.print(seatMap[i][j]);
            }
            System.out.println();
        }
    }

    public static void ticketPrice() {

        boolean check = true;
        do {
            System.out.println("\nEnter a row number:");
            rowNumber = sc.nextInt();
    
            System.out.println("Enter a seat number in that row:");
            seatNumber = sc.nextInt();
            if (rowNumber > numberOfRows || seatNumber > numberOfSeatsPerRow || rowNumber < 1 || seatNumber < 1) {
                System.out.println("Wrong input!");
            } else if (seatMap[rowNumber][seatNumber].equals(" B")) {
                System.out.println("That ticket has already been purchased!"); 
            } else {
                check = false;
                seatMap[rowNumber][seatNumber] = " B";
                purchasedTickets++;
            }
        } while (check);
    
 
        numberOfSeats = numberOfRows * numberOfSeatsPerRow;
        int ticketPrice;
        if (numberOfSeats <= 60) {
            ticketPrice = 10;

        } else {
            int midRow = numberOfRows >> 1;
            ticketPrice = rowNumber <= midRow ? 10 : 8;

        }
        System.out.printf("Ticket price: $%d%n", ticketPrice);
    
        

    }

    public static void statistics() {
        int currentFirstHalf = 0;
        int currentBackHalf = 0;
        int currentIncome;
        int totalIncome;
        numberOfSeats = numberOfRows * numberOfSeatsPerRow;
        for (int i = 1; i < numberOfRows + 1; i++) {
            for (int j = 1; j < numberOfSeatsPerRow + 1; j++) {
                if (seatMap[i][j].equals(" B")) {
                    if (i <= numberOfRows / 2) {
                        currentFirstHalf++;
                    } else {
                        currentBackHalf++;
                    }
                }
            }
        }

        int purchasedTicket = currentFirstHalf + currentBackHalf;
        float percent = (float) purchasedTicket / numberOfSeats * 100;

        if (numberOfSeats <= 60) {
            totalIncome = 10 * numberOfSeats;
            currentIncome = 10 * purchasedTicket;
        } else {
            int midRow = (numberOfRows / 2);
            currentIncome = 10 * currentFirstHalf + 8 * currentBackHalf;
            totalIncome = (midRow * 10 + (numberOfRows - midRow) * 8) * numberOfSeatsPerRow;
        }

        System.out.printf("Number of purchased tickets:%d\n" +
                        "Percentage: %.2f%%\n" +
                        "Current income: $%d\n" +
                        "Total income: $%d\n\n",
                purchasedTickets, percent, currentIncome, totalIncome);
    }

    
}        
