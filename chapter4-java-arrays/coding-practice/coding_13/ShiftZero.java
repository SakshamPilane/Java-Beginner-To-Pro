package coding_13;

import java.util.Scanner;

class ShiftZero {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements?: ");
        int n = input.nextInt(), i;

        if (n <= 0)
        {
            System.out.print("Size cannot be less than 0!");
            System.out.print("Exiting....");
            return;
        }

        int[] array = new int[n];

        System.out.print("Enter elements into array of size " + array.length + ": ");
        for (i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        shiftZero(array);

        System.out.print("Zero shifted array: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        input.close();
    }

    public static void shiftZero(int[] array)
    {
        int j = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != 0) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
        }
    }
}
