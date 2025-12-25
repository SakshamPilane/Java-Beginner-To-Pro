import java.util.Scanner;

public class StringRotationCheck {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first string = ");
        String str1 = input.nextLine();

        if (str1.isEmpty())
        {
            System.out.println("First String is Empty....Exiting....!");
            input.close();
            return;
        }

        System.out.println("Enter second string = ");
        String str2 = input.nextLine();

        if (str2.isEmpty())
        {
            System.out.println("Second String is Empty....Exiting....!");
            input.close();
            return;
        }

        if (str1.length() != str2.length())
        {
            System.out.println("String Lengths are different.... Exiting...!");
            input.close();
            return;
        }

        if (checkSubString(str1.concat(str1), str2))
        {
            System.out.println("Is a Rotation!");
        }
        else
        {
            System.out.println("Is not a Rotation!");
        }

        input.close();
    }

    public static boolean checkSubString(String temp, String str2)
    {
        for (int i = 0; i <= temp.length() - str2.length(); i++) {
            int j;
            for (j = 0; j < str2.length(); j++) {
                if (temp.charAt(i+j) != str2.charAt(j))
                {
                    break;
                }
            }
            if (j == str2.length())
            {
                return true;
            }
        }
        return false;
    }
}