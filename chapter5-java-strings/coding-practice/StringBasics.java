import java.util.Scanner;

public class StringBasics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("User enter your name: ");
        String str = input.nextLine();

        System.out.println("Name entered = " + str);

        System.out.println("Total characters in string are = " + countChar(str));
        countVowelsAndConsonants(str);
        String ifPalindrome = (checkPalindrome(str)) ? " is a Palindrome." : " is a not Palindrome.";
        System.out.println("String = " + str + ifPalindrome);
        input.close();
    }

    public static int countChar(String str) {
        char[] charArray = str.toCharArray();
        int count = 0;
        for (char _ : charArray) {
            count++;
        }
        return count;
    }

    public static void countVowelsAndConsonants(String str) {
        char[] charArray = str.toLowerCase().toCharArray();
        int vowels = 0, consonants = 0;
        for (int ch : charArray) {
            if ((ch >= 97 && ch <= 122))
            {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                }
                else
                {
                    consonants++;
                }
            }
        }
        System.out.println("Total vowels are = " + vowels + " and consonants are = " + consonants);
    }

    public static boolean checkPalindrome(String str)
    {
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i = 0, j = charArray.length - 1; i <= charArray.length/2; i++, j--) {
            if (charArray[i] != charArray[j])
            {
                return false;
            }
        }
        return true;
    }
}