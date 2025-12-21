import java.util.Scanner;

public class WordCharacterReversal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = input.nextLine();

        if (str.isEmpty()) {
            System.out.println("No String Entered... EXITING");
            return;
        }

        reverseEachWord(str);
    }

    public static void reverseEachWord(String str)
    {
        int startIndex = 0, lastIndex;
        boolean inWord = false;
        char[] arr = str.toCharArray();
        for (int i = 0; i <= arr.length; i++) {
            if (i < arr.length && arr[i] != ' ')
            {
                if (!inWord)
                {
                    inWord = true;
                    startIndex = i;
                }
            }
            else
            {
                lastIndex = i - 1;
                inWord = false;
                reverseWord(arr, startIndex, lastIndex);
            }
        }

        System.out.print("Word Reversal String = ");
        for (char c : arr) {
            System.out.print(c);
        }
    }

    public static void reverseWord(char[] arr, int startIndex, int lastIndex)
    {
        for (int i = startIndex, j = lastIndex; i < j; i++, j--) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
    }
}
