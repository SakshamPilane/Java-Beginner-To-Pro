package coding_9;

import java.util.Arrays;
import java.util.Scanner;

class DuplicateRemover {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements?: ");
        int n = input.nextInt();

        int[] array = new int[n];

        System.out.print("Enter elements into array of size " + array.length + ": ");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        Arrays.sort(array);
        int size = removeDuplicates(array);

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        input.close();
    }

    public static int removeDuplicates(int[] arr) {
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j + 1;
    }
}
