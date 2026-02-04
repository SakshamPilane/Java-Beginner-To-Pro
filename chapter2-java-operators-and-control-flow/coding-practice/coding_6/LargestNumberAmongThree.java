package coding_6;

import java.util.Scanner;
class LargestNumberAmongThree {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First Number: ");
        float firstNumber = input.nextFloat();
        System.out.print("Enter Second Number: ");
        float secondNumber = input.nextFloat();
        System.out.print("Enter Third Number: ");
        float thirdNumber = input.nextFloat();

        if (firstNumber == secondNumber && firstNumber == thirdNumber)
        {
            System.out.print("All Numbers are equal");
        }
        else if (firstNumber >= secondNumber && firstNumber >= thirdNumber)
        {
            System.out.print(firstNumber + " is the largest number");
        }
        else if (secondNumber >= thirdNumber)
        {
            System.out.print(secondNumber + " is the largest number");
        }
        else
        {
            System.out.print(thirdNumber + " is the largest number");
        }
        input.close();
    }
}
