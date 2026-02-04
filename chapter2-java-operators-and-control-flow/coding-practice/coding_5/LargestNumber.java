package coding_5;

import java.util.Scanner;
class LargestNumber {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first Number: ");
        float firstNumber = input.nextFloat();
        System.out.print("Enter second Number: ");
        float secondNumber = input.nextFloat();

        if(firstNumber == secondNumber)
        {
            System.out.print("Largest Number = " + firstNumber + " and " + secondNumber + "\n");
        }
        else if (secondNumber > firstNumber)
        {
            System.out.print("Largest Number = " + secondNumber + "\n");
        }
        else
        {
            System.out.print("Largest Number = " + firstNumber + "\n");
        }
        input.close();
    }
}
