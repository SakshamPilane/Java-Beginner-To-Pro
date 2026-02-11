package coding_2;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string to reverse it: ");
        String str = input.nextLine();

        // get user input
        System.out.println("String entered = " + str);

        revString(str);

        input.close();
    }

    public static void revString(String str)
    {
        char[] charArray = str.toCharArray();

        for (int i = 0, j = charArray.length - 1; i < charArray.length / 2; i++, j--) {
            char c = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = c;
        }

        System.out.print("Reverse of given String = ");
        for (char c : charArray)
        {
            System.out.print(c);
        }
    }
}
