import java.util.Scanner;

public class SumOfDigitsRecursion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of terms to display sum of those digits: ");
        int n = input.nextInt();
        int sum = sumOfDigits(n);
        System.out.println("Sum of Digits = " + sum);
        input.close();
    }
    public static int sumOfDigits(int number)
    {
        if(number == 0)
        {
            return 0;
        }
        else
        {
            return number%10 + sumOfDigits(number/10);
        }
    }
}
