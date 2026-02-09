package coding_12;

import java.util.*;

public class RightShiftingArray {

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

        rightShiftMethod(array);

        for (int num : array) {
            System.out.print(num + " ");
        }

        input.close();
    }

    public static void rightShiftMethod(int[] array)
    {
        int lastIndexElement = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--)
        {
            array[i] = array[i-1];
        }
        array[0] = lastIndexElement;
    }

}
