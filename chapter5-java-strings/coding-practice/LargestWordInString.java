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

        System.out.print("Largest String: " + findLargestWord(str));
    }

    public static String findLargestWord(String str) {
        char[] arr = str.toCharArray();

        int maxLen = 0;
        int maxStart = 0;

        int currentLen = 0;
        int currentStart = 0;

        boolean inWord = false;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != ' ') {
                if (!inWord) {
                    inWord = true;
                    currentStart = i;
                    currentLen = 1;
                } else {
                    currentLen++;
                }
            } else {
                if (inWord) {
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                        maxStart = currentStart;
                    }
                    inWord = false;
                }
            }
        }

        if (inWord && currentLen > maxLen) {
            maxLen = currentLen;
            maxStart = currentStart;
        }

        return str.substring(maxStart, maxStart + maxLen);
    }

}
