import java.util.Scanner;

public class CopyArray {
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

        copyArray(array);

        input.close();
    }

    public static void copyArray(int[] array)
    {
        int[] cpArray = new int[array.length];

        int i;

        System.out.println("Copying Elements.....");
        for (i = 0; i < array.length; i++)
        {
            cpArray[i] = array[i];
        }

        System.out.print("Copied Array: ");
        for (int num : cpArray)
        {
            System.out.print(num + " ");
        }
    }
}
