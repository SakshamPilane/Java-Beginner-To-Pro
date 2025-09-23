import java.util.Scanner;

public class ReverseAnArrayWithTempVariable {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements: ");
        int i, n = input.nextInt();

        int[] array = new int[n];
        System.out.print("Enter Elements into array: ");
        for (i = 0; i < n; i++)
        {
            array[i] = input.nextInt();
        }

        System.out.print("Array Entered: ");
        for (i = 0; i < n; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        reverseArray(array);

        input.close();
    }

    public static void reverseArray(int[] array)
    {
        int i, j, temp;
        for (i = 0, j = array.length - 1; i < array.length/2; i++, j--)
        {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        System.out.print("Reversed Array: ");
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
