import java.util.Scanner;

public class SmallestWordInString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = input.nextLine();

        if (str.isEmpty()) {
            System.out.println("No String Entered... EXITING");
            return;
        }

        findSmallestWord(str);
    }

    public static void findSmallestWord(String str)
    {
        int wordLength = Integer.MAX_VALUE, tempLength = 0, smallestWordFirstIndex, smallestWordLastIndex = 0;
        for (int i = 0; i <= str.length(); i++)
        {
            if (i < str.length() && str.charAt(i) != ' ')
            {
                tempLength++;
            }
            else
            {
                if (tempLength < wordLength)
                {
                    wordLength = tempLength;
                    smallestWordLastIndex = i;
                }
                tempLength = 0;
            }
        }

        smallestWordFirstIndex = smallestWordLastIndex - wordLength;

        System.out.println("Smallest Word Length = " + wordLength);
        System.out.print("Smallest Word = ");
        for (int i = smallestWordFirstIndex; i < smallestWordLastIndex; i++) {
            System.out.print(str.charAt(i));
        }
    }
}
