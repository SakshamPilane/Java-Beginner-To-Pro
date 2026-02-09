package coding_15;

import java.util.Arrays;
import java.util.Scanner;

class BinarySearch {
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

        System.out.print("Array Entered: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        Arrays.sort(array);

        System.out.print("Sorted Array: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Enter an Element to search: ");
        int search = input.nextInt();

        int found = binarySearching(array, 0, n - 1, search);

        if (found == -1)
        {
            System.out.print("Element " + search + " not Found!");
        }
        else
        {
            System.out.print("Element " + search + " Found at position " + found);
        }

        input.close();
    }

    public static int binarySearching(int[] array, int low, int high, int search)
    {
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (array[mid] == search)
            {
                return mid;
            }
            else if (array[mid] < search)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }
}
