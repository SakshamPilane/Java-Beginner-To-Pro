package coding_26;

import java.util.Scanner;
import java.util.Arrays;

public class WaveFormSorting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements?: ");
        int n = input.nextInt();
        int[] array = new int[n];

        System.out.print("Enter elements into array of size " + array.length + ": ");
        for (int i = 0; i < array.length; i++) array[i] = input.nextInt();

        waveSort(array);

        System.out.println(Arrays.toString(array));
        input.close();
    }

    public static void waveSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0)
            {
                if (arr[i] > arr[i + 1]) swap(arr, i, i + 1);
            }
            else
            {
                if (arr[i] < arr[i + 1]) swap(arr, i, i + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}