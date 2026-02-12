package coding_5;

import java.util.Scanner;

public class SpacesRemover {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        if (str.isEmpty()) return;

        System.out.println("String entered = " + str);

        String result = removeSpaces(str);

        System.out.println("New String without spaces = " + result);

        input.close();
    }

    public static String removeSpaces(String str) {
        char[] arr = str.toCharArray();
        int j = 0;  // write pointer

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {      // only copy NON-space characters
                arr[j++] = arr[i];
            }
        }

        return new String(arr, 0, j);
    }
}
