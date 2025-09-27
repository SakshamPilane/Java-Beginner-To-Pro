import java.util.Scanner;

public class StringLength {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String to find its length: ");
        String str = input.nextLine();
        char[] charArray = str.toCharArray();
        int strLength = findLength(charArray);
        System.out.print("Length of String " + str + " = " + strLength);
        input.close();
    }

    public static int findLength(char[] charArray)
    {
        int count = 0;
        for (char _ : charArray)
        {
            count++;
        }
        return count;
    }
}
