package coding_14;

import java.util.Scanner;
class FactorialOfNumbers {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number to find its factorial: ");
        int number = input.nextInt(), i = 1, factorial = 1;

        while (i <= number)
        {
            factorial *= i;
            i++;
        }
        System.out.print("Factorial of " + number + " = " + factorial);
        input.close();
    }
}
