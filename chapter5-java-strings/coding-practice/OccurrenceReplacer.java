import java.util.Scanner;

public class OccurrenceReplacer {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = input.nextLine();

        char[] charArray = str.toCharArray();

        System.out.print("Enter a character to be replaced = ");
        char originalChar = input.nextLine().charAt(0);
        if (!ifExists(charArray , originalChar))
        {
            System.out.println("Given Character does not exist in String!");
            System.out.println("****************EXITING******************");
            return;
        }

        System.out.print("Enter a character to which will replace existing character = ");
        char replaceChar = input.nextLine().charAt(0);

        System.out.println("Given String = " + str);

        System.out.println("Replacing characters....");
        replaceOccurrencesMethod(charArray, originalChar, replaceChar);

        System.out.println("String after replacing character '" + originalChar + "' by your given character '" + replaceChar + "' = " + new String(charArray));

        input.close();
    }

    public static boolean ifExists (char[] charArray, char originalChar)
    {
        for (char ch : charArray)
        {
            if (ch == originalChar)
            {
                return true;
            }
        }
        return false;
    }

    public static void replaceOccurrencesMethod(char[] charArray, char originalChar, char replaceChar) {
        int i, n = charArray.length;
        for (i = 0; i < n; i++) {
            if (charArray[i] == originalChar)
            {
                charArray[i] = replaceChar;
            }
        }
    }
}
