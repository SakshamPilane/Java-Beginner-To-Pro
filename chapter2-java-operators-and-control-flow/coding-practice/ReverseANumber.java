import java.util.Scanner;
public class ReverseANumber {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number to reverse it: ");
        int number = input.nextInt(), digit, reverseNumber = 0;
        while (number != 0)
        {
            digit = number % 10;
            number = number / 10;
            reverseNumber = reverseNumber * 10 + digit;
        }
        System.out.print("Reversed Number = " + reverseNumber);
        input.close();
    }
}