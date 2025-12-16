import java.util.Scanner;

public class StringOrderReversal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = input.nextLine();

        if (str.isEmpty()) {
            System.out.println("No String entered!! Exiting...");
            return;
        }

        str = reverseOrder(str);
        System.out.println("Order Reversed String = " + str);
    }

    public static String reverseOrder(String str) {
        char[] arr = str.toCharArray();
        char[] result = new char[arr.length];

        int index = 0;               // index for result array
        int end = arr.length - 1;    // end of word

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                index = copyWord(arr, result, i + 1, end, index);
                result[index++] = ' ';
                end = i - 1;
            }
        }

        // copy first word
        copyWord(arr, result, 0, end, index);

        return new String(result);
    }

    public static int copyWord(char[] src, char[] dest, int start, int end, int index) {
        for (int i = start; i <= end; i++) {
            dest[index++] = src[i];
        }
        return index;
    }
}
