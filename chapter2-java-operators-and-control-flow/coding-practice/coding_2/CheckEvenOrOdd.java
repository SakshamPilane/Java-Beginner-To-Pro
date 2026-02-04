package coding_2;

import java.util.Scanner;
class CheckEvenOrOdd {
    public static void main(String[] args)
    {
        // can also be done using ternary operators
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number % 2 == 0)
        {
            System.out.print(number + " is an Even number.");
        }
        else
        {
            System.out.print(number + " is an Odd number.");
        }
        input.close();
    }
}
