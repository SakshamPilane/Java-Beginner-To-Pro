import java.util.Scanner;
import java.util.Arrays;

public class KadaneAlgo {
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
        kadane(array);
    }

    // Kadane's algorithm
    public static void kadane(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        int start = 0, end = 0, s = 0;

        for (int i = 1; i < arr.length; i++) {
            if (maxEndingHere + arr[i] < arr[i]) {
                // start new subarray at i
                maxEndingHere = arr[i];
                s = i;
            } else {
                // extend existing subarray
                maxEndingHere += arr[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
        }

        System.out.println("Maximum contiguous subarray sum = " + maxSoFar);
        System.out.println("Subarray indices: [" + start + ", " + end + "]");
        System.out.println("Subarray elements: " + Arrays.toString(Arrays.copyOfRange(arr, start, end + 1)));
    }
}