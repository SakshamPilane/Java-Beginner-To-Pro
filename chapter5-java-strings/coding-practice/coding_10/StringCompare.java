package coding_10;

import java.util.Scanner;

public class StringCompare {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first String: ");
        String str = input.nextLine();
        System.out.print("Enter second String: ");
        String str2 = input.nextLine();

        if (str.isEmpty())
        {
            System.out.print("First String Empty! Exiting.....");
            return;
        }
        if (str2.isEmpty())
        {
            System.out.print("Second String Empty! Exiting.....");
            return;
        }

        System.out.println("First String Entered = " + str);
        System.out.println("Second String Entered = " + str2);

        // or use of str.compareTo(str2);
        if(strCompare(str, str2))
        {
            System.out.print("Both the Strings String 1 = " + str + " & String 2 = " + str2 + " are equal!");
        }
        else
        {
            System.out.print("Both the Strings String 1 = " + str + " & String 2 = " + str2 + " are not equal!");
        }

        input.close();
    }

    public static Boolean strCompare(String str, String str2)
    {
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != charArray2[i])
            {
                return false;
            }
        }
        return true;
    }
}
