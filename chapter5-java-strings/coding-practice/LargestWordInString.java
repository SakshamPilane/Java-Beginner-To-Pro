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

    public static void findLargestWord(String str) {
        char[] arr = str.toCharArray();

        int start = 0;
        int maxStart = 0;
        int maxLen = 0;
        int currLen = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ')
            {
                currLen++;
            }
            else
            {
                if (currLen > maxLen)
                {
                    maxLen = currLen;
                    maxStart = start;
                }
                currLen = 0;
                start = i + 1;
            }
        }

        if (currLen > maxLen) {
            maxLen = currLen;
            maxStart = start;
        }

        System.out.print("Largest Word: ");
        for (int i = maxStart; i < maxStart + maxLen; i++) {
            System.out.print(arr[i]);
        }
    }
}
