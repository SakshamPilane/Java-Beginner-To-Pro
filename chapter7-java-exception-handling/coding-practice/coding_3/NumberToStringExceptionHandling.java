package coding_3;

import java.util.Scanner;

public class NumberToStringExceptionHandling {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String str = input.nextLine();

            int num = Integer.parseInt(str);

            System.out.println("Number converted = " + num);
        }
        catch (NumberFormatException nFE)
        {
            System.out.println("Error: Invalid number format");
            System.out.println(nFE.getMessage());
        }
    }
}