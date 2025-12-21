import java.util.Scanner;

public class LargestWordInString {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = input.nextLine();

        if (str.isEmpty()) {
            System.out.println("No String Entered... EXITING");
            return;
        }

        findLargestWord(str);
    }

    public static void findLargestWord(String str)
    {
        int wordLength = 0, tempLength = 0, largestWordFirstIndex, largestWordLastIndex = 0;
        for (int i = 0; i <= str.length(); i++)
        {
            if (i < str.length() && str.charAt(i) != ' ')
            {
                tempLength++;
            }
            else
            {
                if (tempLength > wordLength)
                {
                    wordLength = tempLength;
                    largestWordLastIndex = i;
                }
                tempLength = 0;
            }
        }

        largestWordFirstIndex = largestWordLastIndex - wordLength;

        System.out.println("Largest Word Length = " + wordLength);
        System.out.print("Largest Word = ");
        for (int i = largestWordFirstIndex; i < largestWordLastIndex; i++) {
            System.out.print(str.charAt(i));
        }
    }
}
