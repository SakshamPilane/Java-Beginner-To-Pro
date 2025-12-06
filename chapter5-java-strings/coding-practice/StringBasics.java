import java.util.Scanner;

public class StringBasics {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("User enter your name: ");
        String str = input.nextLine();

        System.out.println("Name entered = " + str);

        char[] charArray = str.toCharArray();
        System.out.println("Total characters in string are = " + countChar(charArray));

        input.close();
    }

    public static int countChar(char[] charArray)
    {
        int count = 0;
        for (char ch : charArray)
        {
            count++;
        }
        return count;
    }
}
