package coding_23;

import java.util.Scanner;

public class GCDFinding {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StringBuilder finalStatement = new StringBuilder();

        System.out.print("Enter a number: ");
        int number1 = input.nextInt();

        System.out.print("Enter another number: ");
        int number2 = input.nextInt();

        int a = Math.abs(number1), b = Math.abs(number2);
        int remainder;
        do {
            remainder = a % b;
            a = b;
            b = remainder;
        } while (b != 0);

        finalStatement.append("GCD of ").append(number1).append(" & ").append(number2).append(" = ").append(a);

        System.out.println("GCD of " + finalStatement);

        input.close();

    }
}
