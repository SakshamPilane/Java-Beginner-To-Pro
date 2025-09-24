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
        int i, temp, next = array[array.length-1];
        for (i = 0; i < array.length; i++)
        {
            temp = array[i];
            array[i] = next;
            next = array[i+1];
            array[i+1] = temp;
        }
    }
}