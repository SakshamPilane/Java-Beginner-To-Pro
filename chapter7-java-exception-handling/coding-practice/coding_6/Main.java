package coding_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            try {
                System.out.print("Enter a number: ");
                int num = Integer.parseInt(input.nextLine());

                int result = 10 / num;
                System.out.println("Result: " + result);

            } catch (NumberFormatException e) {
                System.out.println("Inner catch: Invalid number format");
            }

        } catch (ArithmeticException e) {
            System.out.println("Outer catch: Division by zero");
        }
    }
}
