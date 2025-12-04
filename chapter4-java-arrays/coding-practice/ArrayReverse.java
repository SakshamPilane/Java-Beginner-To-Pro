import java.util.Scanner;

public class ArrayReverse {
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

        System.out.print("Array: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        revArray(array);

        input.close();
    }

    public static void revArray(int[] array)
    {
        int n = array.length, i , j, temp;
        for (i = 0, j = n - 1; i < n / 2; i++, j--) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        System.out.print("Reversed Array: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
