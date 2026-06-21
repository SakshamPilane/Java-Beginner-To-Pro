package Coding_22;

import java.util.Scanner;

public class CountingOnesBits {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StringBuilder finalStatement = new StringBuilder();

        System.out.print("Enter a Number: ");
        int number = input.nextInt();
        int onesCount = 0;

        // The Shift Approach
        while (number != 0) {
            // counts if 1 is at right most side Example: 1 (0001) & 15 (1111) => 0001 that is 1 hence onesCount+1
            onesCount += (number & 1);
            // number right-shifted by 1 making Example: 15 (1111) as 0111
            number >>>= 1;
        }
        finalStatement.append((onesCount > 1) ? onesCount + " times" : onesCount + " time");
        System.out.println("One Appeared = " + finalStatement);

//        Brian Kernighan's Trick
//        while (number != 0)
//        {
//            // increments Count
//            onesCount++;
//            // At every step reduces number till all 0 appear that is: 15 (1111) & 14 (1110) => 1110, 14 (1110) & 13 (1101) => 1100, 12 (1100) & 11 (1011) => 1000, 8 (1000) & 7 (0111) => 0000 Hence Count = 4 steps
//            number = number & (number-1);
//        }

        input.close();

    }

}
