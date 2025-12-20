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

    public static int count(String str)
    {
        int count = 0;
        boolean inWord = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ')
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
