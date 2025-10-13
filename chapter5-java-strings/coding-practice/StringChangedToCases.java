import java.util.Scanner;

public class StringChangedToCases {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = input.nextLine();

        System.out.println("Given String = " + str);
        char[] charArray = str.toCharArray();

        System.out.println("Converting String to Upper Case....");
        char[] upperArray = toUpperCase(charArray.clone());
        System.out.println("Upper Case String = " + new String(upperArray));

        System.out.println("Converting String to Lower Case....");
        char[] lowerArray = toLowerCase(charArray.clone());
        System.out.println("Lower Case String = " + new String(lowerArray));

        input.close();
    }

    public static char[] toUpperCase(char[] upperArray)
    {
        int i, n = upperArray.length, asciiCode;
        for (i = 0; i < n; i++) {
            asciiCode = upperArray[i];
            if (asciiCode >= 97 && asciiCode <= 122)
            {
                asciiCode -= 32;
                upperArray[i] = (char) asciiCode;
            }
        }
        return upperArray;
    }

    public static char[] toLowerCase(char[] lowerArray)
    {
        int i, n = lowerArray.length, asciiCode;
        for (i = 0; i < n; i++) {
            asciiCode = lowerArray[i];
            if (asciiCode >= 65 && asciiCode <= 90)
            {
                asciiCode += 32;
                lowerArray[i] = (char) asciiCode;
            }
        }
        return lowerArray;
    }
}
