import java.util.Scanner;

public class PalindromeCheckerString {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a String to check if it is palindrome or not: ");
        String str = input.nextLine();
        if(checkPalindrome(str))
        {
            System.out.println("Is a Palindrome!");
        }
        else
        {
            System.out.println("Is not a Palindrome!");
        }
        input.close();
    }

    public static boolean checkPalindrome(String str)
    {
        char[] charArray = str.toLowerCase().toCharArray();
        int n = charArray.length, i;
        boolean flag = true;

        System.out.println("Reducing String to LowerCase....");

        System.out.print("Given String: ");
        for (i = 0; i < n; i++) {
            System.out.print(charArray[i]);
        }
        System.out.println();

        System.out.print("Reversed String: ");
        for (i = n - 1; i >= 0; i--) {
            System.out.print(charArray[i]);
        }
        System.out.println();

        for (i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[n - 1 - i]) {
                return false;
            }
        }
        return flag;
    }
}
