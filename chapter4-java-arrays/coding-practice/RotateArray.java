import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int i;
        System.out.print("How many Elements for first array: ");
        int n = input.nextInt();
        int[] array1 = new int[n];

        System.out.print("How many Elements for second array: ");
        int m = input.nextInt();
        int[] array2 = new int[m];

        System.out.print("Enter elements into array of size " + array1.length + " to left shift it: ");
        for (i = 0; i < array1.length; i++) {
            array1[i] = input.nextInt();
        }

        System.out.print("Enter elements into array of size " + array2.length + " to right shift it: ");
        for (i = 0; i < array2.length; i++) {
            array2[i] = input.nextInt();
        }

        rotateLeft(array1); // rotate left method call

        // printing array 1
        System.out.print("Left Rotated Array = ");
        for (int num : array1)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        rotateRight(array2); // rotate right method call

        // printing array 2
        System.out.print("Right Rotated Array = ");
        for (int num : array2)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        input.close();
    }

    public static void rotateLeft(int[] array)
    {
        int first = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i-1] = array[i];
        }
        array[array.length - 1] = first;
    }

    public static void rotateRight(int[] array)
    {
        int last = array[array.length-1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i-1];
        }
        array[0] = last;
    }
}
