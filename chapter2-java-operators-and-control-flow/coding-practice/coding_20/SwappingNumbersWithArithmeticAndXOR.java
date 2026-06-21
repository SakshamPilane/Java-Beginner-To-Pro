package coding_20;

import java.util.Scanner;

public class SwappingNumbersWithArithmeticAndXOR {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number1 = input.nextInt();

        System.out.print("Enter another number: ");
        int number2 = input.nextInt();

        System.out.println("Swapped Numbers after arithmetic method!");
        System.out.println("Before: " + number1 + " and " + number2);

        number1 = number2 + number1;
        number2 = number1 - number2;
        number1 = number1 - number2;

        System.out.println("Swapped Numbers after arithmetic method!");
        System.out.println("After: " + number1 + " and " + number2);

        System.out.println();

        System.out.println("Swapped Numbers after XOR (^) method!");
        System.out.println("Before: " + number1 + " and " + number2);

        number1 = number1 ^ number2;
        number2 = number1 ^ number2;
        number1 = number1 ^ number2;

        System.out.println("Swapped Numbers after XOR (^) method!");
        System.out.println("After: " + number1 + " and " + number2);

        input.close();

    }

}
