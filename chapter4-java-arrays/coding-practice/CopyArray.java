import java.util.Scanner;

public class CopyArray {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements: ");
        int n = input.nextInt(), i;

        int[] array = new int[n];

        System.out.print("Enter Elements: ");
        for (i = 0; i < n; i++)
        {
            array[i] = input.nextInt();
        }

        System.out.print("Elements entered: ");
        for (i = 0; i < n; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        copyArray(array);

        input.close();
    }

    public static void copyArray(int[] array)
    {
        int cpArray[] = new int[array.length], i;
        System.out.println("Copying Elements.....");
        for (i = 0; i < array.length; i++)
        {
            cpArray[i] = array[i];
        }
        System.out.print("Copied Array: ");
        for (i = 0; i < array.length; i++)
        {
            System.out.print(cpArray[i] + " ");
        }
    }
}
