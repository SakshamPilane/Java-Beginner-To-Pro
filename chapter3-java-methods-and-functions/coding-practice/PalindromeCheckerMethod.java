import java.util.Scanner;
public class PalindromeCheckerMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to check if it is a palindrome number or not: ");
        int number = input.nextInt();
        if (isPalindrome(number) == number)
        {
            System.out.println(number + " is a Palindrome!");
        }
        else
        {
            System.out.println(number + " is not a Palindrome!");
        }
        input.close();
    }

    public static int isPalindrome(int number)
    {
        int digit, revNumber = 0;
        while(number > 0)
        {
            digit = number % 10;
            number /= 10;
            revNumber = revNumber * 10 + digit;
        }
        return revNumber;
    }
}
