import java.util.Scanner;

public class SelectionSort {
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

        sSort(array);

        System.out.print("Sorted Array: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        input.close();
    }

    public static void sSort(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            boolean swapped = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j])
                {
                    minIndex = j;
                    swapped = true;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            if (!swapped)
            {
                break;
            }
        }
    }
}
