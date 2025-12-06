import java.util.Scanner;

public class StringBasics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("User enter your name: ");
        String str = input.nextLine();

        System.out.println("Name entered = " + str);

        System.out.println("Total characters in string are = " + countChar(str));
        countVowelsAndConsonants(str);
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
}