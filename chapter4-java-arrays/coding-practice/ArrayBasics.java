import java.util.Scanner;

public class ArrayBasics {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Size of Array?: ");
        int n = input.nextInt(), i;
        int[] array = new int[n]; // array declaration
        System.out.print("Enter elements: ");
        for (i = 0; i < n; i++)
        {
            array[i] = input.nextInt(); // entering elements into array
        }
        System.out.print("Array = ");
        for (i = 0; i < n; i++)
        {
            System.out.print(array[i] + " "); // printing elements from array
        }
        input.close();
    }
}
