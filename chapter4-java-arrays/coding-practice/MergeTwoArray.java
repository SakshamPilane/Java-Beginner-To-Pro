import java.util.Scanner;

public class MergeTwoArray {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements in array 1: ");
        int n = input.nextInt();
        System.out.print("How many Elements in array 2: ");
        int m = input.nextInt();

        int[] array1 = new int[n];
        int[] array2 = new int[m];

        System.out.print("Enter Elements in array 1: ");
        for (int i = 0; i < n; i++)
        {
            array1[i] = input.nextInt();
        }

        System.out.print("Enter Elements in array 2: ");
        for (int i = 0; i < m; i++)
        {
            array2[i] = input.nextInt();
        }

        mergeArray(array1,array2);
    }

    public static void mergeArray(int[] array1,int[] array2)
    {
        int size = array1.length + array2.length, i;
        int[] mergedArray = new int[size];

        System.out.println("Merging Arrays.....");

        for (i = 0; i < array1.length; i++) {
            mergedArray[i] = array1[i];
        }

        for (i = 0; i < array2.length; i++) {
            mergedArray[array1.length + i] = array2[i];
        }

        System.out.print("Merged Array: ");
        for (int num : mergedArray)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        sortArray(mergedArray);
    }

    public static void sortArray(int[] array)
    {
        int i, j, temp;
        System.out.println("Sorting.....");
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        System.out.print("Sorted Array: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
