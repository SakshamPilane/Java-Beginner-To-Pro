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

        Result res = kadane(array);

        System.out.println("Maximum contiguous subarray sum = " + res.maxSum);
        System.out.println("Subarray indices: [" + res.start + ", " + res.end + "]");
        System.out.println("Subarray elements: " + Arrays.toString(Arrays.copyOfRange(array, res.start, res.end + 1)));
    }

    // small helper class to return multiple values
    static class Result {
        int maxSum;
        int start;
        int end;
        Result(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }

    // Kadane's algorithm
    public static Result kadane(int[] arr) {
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

        return new Result(maxSoFar, start, end);
    }
}