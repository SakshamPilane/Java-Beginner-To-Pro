import java.util.Scanner;

public class StringRotationCheck {

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        String temp = s1 + s1;
        return isSubstring(temp, s2);
    }

    // Manual substring check
    public static boolean isSubstring(String text, String pattern) {
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j;
            for (j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (j == pattern.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = input.nextLine();

        System.out.print("Enter second string: ");
        String str2 = input.nextLine();

        // get user input
        System.out.println("First String entered = " + str1);
        System.out.println("Second String entered = " + str2);

        if (isRotation(str1, str2))
        {
            System.out.println("Is A Rotation!");
        }
        else
        {
            System.out.println("Is not a Rotation!");
        }

        input.close();
    }
}