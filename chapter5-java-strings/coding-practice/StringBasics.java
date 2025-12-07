import java.util.Scanner;

public class StringBasics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("User enter your name: ");
        String str = input.nextLine();

        // get user input
        System.out.println("Name entered = " + str);

        // convert to lowercase and uppercase
        convertToLowerCase(str);
        convertToUpperCase(str);

        // count total characters in array
        System.out.println("Total characters in string are = " + countChar(str));
        countVowelsAndConsonants(str);

        // check if palindrome
        String ifPalindrome = (checkPalindrome(str)) ? " is a Palindrome." : " is a not Palindrome.";
        System.out.println("String = " + str + ifPalindrome);

        // count Digits
        countAll(str);

        // printing each character from string on new line
        printString(str);

        input.close();
    }

    public static void convertToLowerCase(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 65 && charArray[i] <= 90) {
                charArray[i] = (char) (charArray[i] + 32);
            }
        }

        System.out.print("Lowe case String = ");
        for (char c : charArray) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void convertToUpperCase(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 97 && charArray[i] <= 122) {
                charArray[i] = (char) (charArray[i] - 32);
            }
        }

        System.out.print("Upper case String = ");
        for (char c : charArray) {
            System.out.print(c);
        }
        System.out.println();
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

    public static void countAll(String str)
    {
        int digits = 0, letters = 0, specialChar = 0;
        char[] charArray = str.toLowerCase().toCharArray();
        for (char c : charArray) {
            if (c >= '1' && c <= '9') {
                digits++;
            } else if (c >= 'a' && c <= 'z') {
                letters++;
            } else {
                specialChar++;
            }
        }
        System.out.println("Total Digits = " + digits);
        System.out.println("Total letters = " + letters);
        System.out.println("Total Special Characters = " + specialChar);
    }

    public static void printString(String str)
    {
        System.out.println("Printing String each on new line: ");
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }
}