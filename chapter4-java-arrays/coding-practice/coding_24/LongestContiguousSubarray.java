package coding_24;

import java.util.Scanner;

public class LongestContiguousSubarray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size for array: ");
        int n = input.nextInt();
        if (n <= 0) {
            System.out.println("Array size cannot be less than or equal to 0! EXITING.....");
            return;
        }

        int[] array = new int[n];
        System.out.println("Enter elements into array:");
        for (int i = 0; i < n; i++) array[i] = input.nextInt();
        searchSubarray(array);
    }

    public static void searchSubarray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int bestStart = 0, bestEnd = 0;   // best (longest) window seen so far
        int currStart = 0;                // start of current increasing run

        for (int i = 1; i < array.length; i++) {
            // break of strictly increasing sequence
            if (array[i] <= array[i - 1]) {
                int currEnd = i - 1;

                // update best window if needed
                if (currEnd - currStart > bestEnd - bestStart) {
                    bestStart = currStart;
                    bestEnd = currEnd;
                }

                // start new sequence
                currStart = i;
            }
        }

        // final run might reach the end — check it
        if (array.length - 1 - currStart > bestEnd - bestStart) {
            bestStart = currStart;
            bestEnd = array.length - 1;
        }

        // print result
        System.out.println("Longest increasing contiguous subarray = ");
        for (int i = bestStart; i <= bestEnd; i++) {
            System.out.print(array[i] + (i < bestEnd ? " " : ""));
        }
        System.out.println();
    }
}
