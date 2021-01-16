package cinema;
import java.util.*;

public class Cinema {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeatsPerRow = sc.nextInt();
        sc.close();
        int numberOfSeats = numberOfRows * numberOfSeatsPerRow;
        int res = (numberOfSeats <= 60) ? numberOfSeats * 10
                : numberOfSeatsPerRow * 10 * (numberOfRows >> 1) + numberOfSeatsPerRow * 8 * ((numberOfRows + 1) >> 1);
        
        System.out.printf("Total income:\n$%d", res);
    }
}