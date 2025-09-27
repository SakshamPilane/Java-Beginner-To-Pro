import java.util.Scanner;

public class ReverseAString {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String to reverse it: ");
        String str = input.nextLine();
        System.out.println("String you entered: " + str);
        char[] charArray = str.toCharArray();
        String revStr = revString(charArray);
        System.out.println("Reversed String: " + revStr);
        input.close();
    }

    public static String revString(char[] charArray)
    {
        char ch;
        int i, j;
        for (i = 0, j = charArray.length-1; i < charArray.length/2; i++, j--)
        {
            ch = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = ch;
        }
        return new String(charArray); // returning a char array in form of String
    }
}
