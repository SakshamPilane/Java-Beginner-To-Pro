import java.util.Scanner;

public class SubStringChecker {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first String: ");
        String str1 = input.nextLine();

        System.out.print("Enter second String: ");
        String str2 = input.nextLine();

        char[] charArray1 = str1.toCharArray();

        char[] charArray2 = str2.toCharArray();

        if (isSubString(charArray1, charArray2))
        {
            System.out.println("String = \"" + str2 + "\" is a sub string of String = \"" + str1 + "\".");
        }
        else
        {
            System.out.println("String = \"" + str2 + "\" is not a sub string of String = \"" + str1 + "\".");
        }

        input.close();
    }

    public static boolean isSubString(char[] charArray1, char[] charArray2)
    {
        int n = charArray1.length, m = charArray2.length, i;
        if (m > n)
        {
            return false;
        }
        for (i = 0; i <= n - m; i++)
        {
            int j;
            for (j = 0; j < m; j++)
            {
                if (charArray1[i + j] != charArray2[j])
                {
                    break;
                }
            }
            if (j == m)
            {
                return true;
            }
        }
        return false;
    }
}
