import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first String: ");
        String str = input.nextLine();

        if (str.isEmpty())
        {
            System.out.print("String is Empty....EXITING.....");
            return;
        }

        System.out.println("Total Words: " + count(str));

        input.close();
    }

    public static int count(String str) {
        char[] charArray = str.toCharArray();
        int count = 0;
        boolean inWord = false;

        for (char c : charArray) {
            if (c != ' ')
            {
                if (!inWord)
                {
                    count++;
                    inWord = true;
                }
            }
            else
            {
                inWord = false;
            }
        }
        return count;
    }
}
