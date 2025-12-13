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

    public static void findSmallestWord(String str) {
        char[] arr = str.toCharArray();

        int start = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int currLen = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ')
            {
                currLen++;
            }
            else
            {
                if (currLen > 0 && currLen < minLen)
                {
                    minLen = currLen;
                    minStart = start;
                }
                currLen = 0;
                start = i + 1;
            }
        }

        if (currLen > 0 && currLen < minLen) {
            minLen = currLen;
            minStart = start;
        }

        System.out.print("Smallest Word: ");
        for (int i = minStart; i < minStart + minLen; i++) {
            System.out.print(arr[i]);
        }
    }
}
