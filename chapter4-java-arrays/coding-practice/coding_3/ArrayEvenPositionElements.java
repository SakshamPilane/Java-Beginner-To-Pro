package coding_3;

import java.util.Scanner;

class ArrayEvenPositionElements {
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
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        evenPos(array);

        input.close();
    }

    public static void evenPos(int[] array)
    {
        System.out.print("Elements at Even Position: ");
        for (int i = 0; i < array.length; i+=2) {
            System.out.print(array[i] + " ");
        }
    }
}
