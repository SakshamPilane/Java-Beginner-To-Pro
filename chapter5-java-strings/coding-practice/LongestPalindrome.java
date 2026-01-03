import java.util.Scanner;

public class LongestPalindrome {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = input.nextLine();

        if (str.isEmpty()) {
            System.out.println("String is Empty....Exiting....!");
            input.close();
            return;
        }

        System.out.println("Longest Palindrome in String = \"" + findLongestPalindrome(str) + "\".");
        input.close();
    }

    public static String findLongestPalindrome(String str) {

        int start = 0, maxLength = 1;
        int n = str.length();

        for (int i = 0; i < n; i++) {

            // Odd length palindromes
            int left = i, right = i;
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                int len = right - left + 1;
                if (len > maxLength) {
                    start = left;
                    maxLength = len;
                }
                left--;
                right++;
            }

            // Even length palindromes
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                int len = right - left + 1;
                if (len > maxLength) {
                    start = left;
                    maxLength = len;
                }
                left--;
                right++;
            }
        }

        return str.substring(start, start + maxLength);
    }
}