import java.util.Scanner;

public class ArrayRotationToRight {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("How many Elements: ");
        int n = input.nextInt(), i;
        int[] array = new int[n];
        System.out.print("Enter Elements into array: ");
        for (i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        rotateArray(array);
        input.close();
    }

    public static void rotateArray(int[] array)
    {
        int last = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--)
        {
            array[i] = array[i - 1];
        }
        array[0] = last;

        System.out.print("Updated Array: ");
        for (int val : array)
        {
            System.out.print(val+" ");
        }
    }
}