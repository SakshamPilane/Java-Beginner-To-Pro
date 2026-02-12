package coding_9;

import java.util.Scanner;

public class StringCopy {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = input.nextLine();

        if (str.isEmpty())
        {
            System.out.print("No String Entered! Exiting.....");
            return;
        }

        System.out.println("String Entered = " + str);

        String newStr = strCopy(str);

        System.out.print("New String = " + newStr);

        input.close();
    }

    public static String strCopy(String str)
    {
        char[] charArray = str.toCharArray();
        char[] newCharArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            newCharArray[i] = charArray[i];
        }
        // or use of System.arraycopy(charArray, 0, newCharArray, 0, charArray.length);
        return new String(newCharArray);
    }
}
