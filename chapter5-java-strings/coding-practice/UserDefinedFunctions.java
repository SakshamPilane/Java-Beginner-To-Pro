import java.util.Scanner;

public class UserDefinedFunctions {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter main String: ");
        String mainStr = input.nextLine();
        if (mainStr.isEmpty())
        {
            System.out.print("String is Empty....Exiting....!");
            input.close();
            return;
        }

        System.out.print("Enter sub string: ");
        String subStr = input.nextLine();

        while (true)
        {
            System.out.println("***************************************");
            System.out.println("1. Find Index of a sub string.");
            System.out.println("2. Find Starting Index of a sub string.");
            System.out.println("3. Find Ending Index of a sub string.");
            System.out.println("4. Exit!");
            System.out.println("***************************************");
            System.out.println("Enter a choice: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice)
            {
                case 1:
                    int position1 = indexOf(mainStr,subStr);

                    if (position1 == -1)
                    {
                        System.out.println("String \"" + subStr + "\" not found in \"" + mainStr + "\".");
                    }
                    else
                    {
                        System.out.println("String \"" + subStr + "\" found at location = " + position1 + " in \"" + mainStr + "\".");
                    }
                    break;

                case 2:
                    if (!startsWith(mainStr,subStr))
                    {
                        System.out.println("String \"" + mainStr + "\" does not start with \"" + subStr + "\".");
                    }
                    else
                    {
                        System.out.println("String \"" + mainStr + "\" starts with \"" + subStr + "\".");
                    }
                    break;

                case 3:
                    if (!endsWith(mainStr,subStr))
                    {
                        System.out.println("String \"" + mainStr + "\" does not end with \"" + subStr + "\".");
                    }
                    else
                    {
                        System.out.println("String \"" + mainStr + "\" ends with \"" + subStr + "\".");
                    }
                    break;

                case 4:
                    System.out.println("Exiting.....");
                    input.close();
                    return;

                default:
                    System.out.println("Wrong Choice Try Again!!");
            }
        }
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

    public static boolean startsWith(String mainStr, String subStr)
    {
        if (subStr.isEmpty())
        {
            return true;
        }
        if (subStr.length() > mainStr.length())
        {
            return false;
        }
        for (int i = 0; i < subStr.length(); i++) {
            if (mainStr.charAt(i) != subStr.charAt(i))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean endsWith(String mainStr, String subStr)
    {
        if (subStr.isEmpty())
        {
            return true;
        }
        if (subStr.length() > mainStr.length())
        {
            return false;
        }
        for (int i = mainStr.length() - subStr.length(), j = 0; i < mainStr.length(); i++, j++) {
            if (mainStr.charAt(i) != subStr.charAt(j))
            {
                return false;
            }
        }
        return true;
    }
}
