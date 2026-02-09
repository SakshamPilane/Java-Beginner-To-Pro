package coding_11;

import java.util.InputMismatchException;
import java.util.Scanner;

class LeftShiftingArray {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter size for array: ");
        int size = input.nextInt();

        if (size <= 0) {
            System.out.println("Array must contain at least one element.");
            return;
        }

        int[] array = new int[size];

        System.out.print("Enter elements into array: ");
        for (int i = 0; i < size; i++) {
            try {
                array[i] = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter integers only.");
                input.next();
                i--;
            }
        }

        leftShiftMethod(array);

        for (int num : array) {
            System.out.print(num + " ");
        }

        input.close();
    }

    public static void leftShiftMethod(int[] array)
    {
        int firstIndexElement = array[0];
        for (int i = 0; i < array.length - 1; i++)
        {
            array[i] = array[i+1];
        }
        array[array.length - 1] = firstIndexElement;
    }

}
