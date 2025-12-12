import java.util.Scanner;

public class LargestWordInString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = input.nextLine();

        if (str.isEmpty())
        {
            System.out.print("No String Entered...EXITING");
            return;
        }
    }

    public static void findLargestWord(String str)
    {
        char[] charArray = str.toCharArray();
        int j = 0, diff, greaterLength = 0, start, end;
        boolean isWord = false;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ')
            {
                if (!isWord)
                {
                    j = i;
                    isWord = true;
                }
            }
            else
            {
                end = i
                diff = i - j;
                if (greaterLength < diff)
                {
                    greaterLength = diff;
                }
                isWord = false;
            }
        }

        System.out.println("Longest String = ")
        for (int i = start; i < end; i++) {
            System.out.print(charArray[i]);
        }
    }
}