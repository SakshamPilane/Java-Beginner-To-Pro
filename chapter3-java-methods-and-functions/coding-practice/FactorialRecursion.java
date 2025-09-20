import java.util.Scanner;
public class FactorialRecursion {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number to find its Factorial: ");
        int number = input.nextInt();
        int factorial = findFactorial(number);
        System.out.print("Factorial of " + number + " = " + factorial);
        input.close();
    }
    public static int findFactorial(int number) {
        if(number == 0 || number == 1)
        {
            return 1;
        }
        else
        {
            return number * findFactorial(number - 1);
        }
    }
}