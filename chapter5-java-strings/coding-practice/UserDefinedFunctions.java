import java.util.Scanner;

public class UserDefinedFunctions {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter main String: ");
        String mainStr = input.nextLine();

        System.out.println("Enter sub string: ");
        String subStr = input.nextLine();

        if (mainStr.isEmpty())
        {
            System.out.println("String is Empty....Exiting....!");
            input.close();
            return;
        }

        int position = indexOf(mainStr,subStr);

        if (position == -1)
        {
            System.out.println("String \"" + subStr + "\" not found in \"" + mainStr + "\".");
        }
        else
        {
            System.out.println("String \"" + subStr + "\" found at location = " + position + " in \"" + mainStr + "\".");
        }

        input.close();
    }

    public static int indexOf(String mainStr, String subStr)
    {
        if (subStr.isEmpty())
        {
            return 0;
        }
        for (int i = 0; i <= mainStr.length() - subStr.length(); i++) {
            int j;
            for (j = 0; j < subStr.length(); j++) {
                if (mainStr.charAt(i + j) != subStr.charAt(j))
                {
                    break;
                }
            }
            if (j == subStr.length())
            {
                return i;
            }
        }
        return -1;
    }
}
