package coding_14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        int[] numbers = new int[5];
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 5 integers:");

        for (int i = 0; i < numbers.length; i++) {
            try {
                System.out.print("Number " + (i + 1) + ": ");
                numbers[i] = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
                input.next();
                i--;
            }
        }

        System.out.println("You entered:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        input.close();
    }
}
