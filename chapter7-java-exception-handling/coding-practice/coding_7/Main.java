package coding_7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter first number: ");
            int a = input.nextInt();

            System.out.print("Enter second number: ");
            int b = input.nextInt();

            System.out.print("Enter third number: ");
            int c = input.nextInt();

            CheckMax obj = null;   // null reference

            try {
                int max = obj.getIsGreater(a, b, c);  // NullPointerException
                System.out.println(max + " is the greatest number");
            }
            catch (NullPointerException e) {
                System.out.println("Error: Object reference is null");
            }
        }
    }
}