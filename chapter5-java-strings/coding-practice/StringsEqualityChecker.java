import java.util.Scanner;

public class StringsEqualityChecker {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first String: ");
        String str1 = input.nextLine();

        System.out.print("Enter second String: ");
        String str2 = input.nextLine();

        char[] charArray1 = str1.toCharArray();

        char[] charArray2 = str2.toCharArray();

        if (isEqual(charArray1, charArray2))
        {
            System.out.println("String = \"" + str1 + "\" and String = \"" + str2 + "\" are Equal.");
        }
        else
        {
            System.out.println("String = \"" + str1 + "\" and String = \"" + str2 + "\" are not Equal.");
        }

        input.close();
    }

    public static boolean isEqual(char[] charArray1, char[] charArray2)
    {
        if(charArray1.length != charArray2.length)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < charArray1.length; i++)
            {
                if (charArray1[i] != charArray2[i])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
