package coding_1;

import java.util.Scanner;

public class DivisionHandler {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter First Number: ");
            int firstNumber = input.nextInt();
            System.out.print("Enter Second Number: ");
            int secondNumber = input.nextInt();
            if (secondNumber == 0) {
                throw new ArithmeticException("Error: Division by zero!");
            }
            int result = firstNumber / secondNumber;
            System.out.println("Result: " + result);
        } catch (ArithmeticException aE) {
            System.out.println(aE.getMessage());
        }
    }
}