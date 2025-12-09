import java.util.Scanner;

public class CharReplacer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string to reverse it: ");
        String str = input.nextLine();

        if (str.isEmpty()) return;

        // get user input
        System.out.println("String entered = " + str);

        str = replaceSpace(str);
        // or could use str = str.replace(' ', '-');

        System.out.print("New String = " + str);

        input.close();
    }

    public static String replaceSpace(String str)
    {
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ')
            {
                charArray[i] = '-';
            }
        }
        return new String(charArray);
    }
}
