import java.util.Scanner;

public class SubStringCheck {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first string = ");
        String str1 = input.nextLine();

        if (str1.isEmpty())
        {
            System.out.println("First String is Empty....Exiting....!");
            input.close();
            return;
        }

        System.out.print("Enter second string = ");
        String str2 = input.nextLine();

        if (str2.isEmpty())
        {
            System.out.println("Second String is Empty....Exiting....!");
            input.close();
            return;
        }

        if (checkSubString(str1, str2))
        {
            System.out.println("Is a Sub String!");
        }
        else
        {
            System.out.println("Is not a Sub String!");
        }

        input.close();
    }

    public static boolean checkSubString(String str1, String str2)
    {
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            int j;
            for (j = 0; j < str2.length(); j++) {
                if (str1.charAt(i+j) != str2.charAt(j))
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
