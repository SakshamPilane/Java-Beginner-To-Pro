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

    public static void reverseEachWord(String str) {
        char[] arr = str.toCharArray();

        int start = 0;     // start index of word

        for (int i = 0; i <= arr.length; i++) {

            // word ends on space or end of string
            if (i == arr.length || arr[i] == ' ') {

                int left = start;
                int right = i - 1;

                // reverse current word
                while (left < right) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }

                start = i + 1; // move to next word
            }
        }

        System.out.print("Reversed Word String = ");
        System.out.println(arr);
    }
}
