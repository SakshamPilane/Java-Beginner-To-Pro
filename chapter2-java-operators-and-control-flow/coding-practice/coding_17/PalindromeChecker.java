package coding_17;

import java.util.Scanner;
class PalindromeChecker {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number to check if it is a palindrome: ");
        int number = input.nextInt(), digit, reverseNumber = 0, originalNumber = number;
        while (number != 0)
        {
            digit = number % 10;
            number = number / 10;
            reverseNumber = reverseNumber * 10 + digit;
        }
        String statusPalindrome = (originalNumber == reverseNumber) ? "Yes it is a Palindrome" : "No it is not a Palindrome";
        System.out.print(statusPalindrome + "\n");
        System.out.print("Original Number = " + originalNumber + " and Reverse Number = " + reverseNumber);
        input.close();
    }
}
