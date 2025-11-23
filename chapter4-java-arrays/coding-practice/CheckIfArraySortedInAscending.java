import java.util.Scanner;

public class CheckIfArraySortedInAscending {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements?: ");
        int n = input.nextInt(), i;

        int[] array = new int[n];

        System.out.print("Enter elements into array of size " + array.length + ": ");
        for (i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        if (sorted(array))
        {
            System.out.println("Array is sorted!");
        }
        else
        {
            System.out.println("Array is not sorted!");
        }
        input.close();
    }

    public static boolean sorted(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1])
            {
                return false;
            }
        }
        return true;
    }
}
