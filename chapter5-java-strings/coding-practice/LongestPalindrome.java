import java.util.Scanner;

public class LongestPalindrome {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
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

        int start = 0, maxLen = 1;

        for (int i = 0; i < str.length(); i++) {

            // Odd-length palindromes
            int left = i, right = i;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {

                int len = right - left + 1;
                if (len > maxLen) {
                    start = left;
                    maxLen = len;
                }
                left--;
                right++;
            }

            // Even-length palindromes
            left = i;
            right = i + 1;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {

                int len = right - left + 1;
                if (len > maxLen) {
                    start = left;
                    maxLen = len;
                }
                left--;
                right++;
            }
        }

        return str.substring(start, start + maxLen);
    }
}