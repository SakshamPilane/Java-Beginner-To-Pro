package coding_19;

import java.util.Arrays;
import java.util.Scanner;

class RepeatingNonRepeatingElements {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size for array: ");
        int n = input.nextInt();

        if(n <= 0)
        {
            System.out.println("Array size cannot be less than or equal to 0! EXITING.....");
            return;
        }

        int[] array = new int[n];

        System.out.print("Enter Elements into array: ");
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        System.out.println("Array Entered: " + Arrays.toString(array));

        Arrays.sort(array);

        find(array);
    }

    public static void find(int[] arr) {

        int firstRepeating = -1;
        int firstNonRepeating = -1;

        // ---------- FIRST REPEATING ----------
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    firstRepeating = arr[i];
                    i = arr.length;   // break outer loop
                    break;
                }
            }
        }

        // ---------- FIRST NON-REPEATING ----------
        for (int k : arr) {
            int count = 0;

            // count occurrences of arr[i]
            for (int i : arr) {
                if (k == i) {
                    count++;
                    if (count > 1) break;   // early break → optimization
                }
            }

            if (count == 1) {
                firstNonRepeating = k;
                break;
            }
        }

        System.out.println("First Repeating = " + firstRepeating);
        System.out.println("First Non-Repeating = " + firstNonRepeating);
    }
}