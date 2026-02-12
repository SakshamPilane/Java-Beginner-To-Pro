package coding_6;

import java.util.Scanner;

public class VowelsRemover {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        if (str.isEmpty()) return;

        System.out.println("String entered = " + str);

        str = removeVowels(str);

        System.out.println("New String without vowels = " + str);

        input.close();
    }

    public static String removeVowels(String str)
    {
        char[] charArray = str.toCharArray();
        int j = 0;
        for (char c : charArray) {
            if (!isVowel(c))
            {
                charArray[j++] = c;
            }
        }
        return new String(charArray, 0, j);
    }

    public static boolean isVowel(char c)
    {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
