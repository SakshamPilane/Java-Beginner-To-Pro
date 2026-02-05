package coding_2;

import java.util.Scanner;

class CopyArray {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements?: ");
        int n = input.nextInt(), i, j = 0;

        int[] array = new int[n];

        System.out.print("Enter elements into array of size " + array.length + ": ");
        for (i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        int[] copyArray = new int[array.length];

        for (int element : array) {
            copyArray[j++] = element;
        }

        System.out.print("New copy of array: ");
        for (int element : copyArray) {
            System.out.print(element + " ");
        }

        input.close();
    }
}
