import java.util.Scanner;

// using bubble sort
public class AscendingSorting {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements: ");
        int n = input.nextInt();

        int[] array = new int[n];

        System.out.print("Enter Elements: ");
        for (int i = 0; i < n; i++)
        {
            array[i] = input.nextInt();
        }

        System.out.print("Elements entered: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        sortArray(array);

        input.close();
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
