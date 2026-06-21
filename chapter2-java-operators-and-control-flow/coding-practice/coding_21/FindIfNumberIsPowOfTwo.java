package coding_21;

import java.util.Scanner;

public class FindIfNumberIsPowOfTwo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StringBuilder finalStatement = new StringBuilder();

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        boolean isPowerOfTwo = (number > 0) && (number & (number - 1)) == 0;

        finalStatement.append((isPowerOfTwo) ? "Number " + number + " is power of two" : "Number " + number + " is not power of two");

        System.out.println(finalStatement);

        input.close();

    }

}
