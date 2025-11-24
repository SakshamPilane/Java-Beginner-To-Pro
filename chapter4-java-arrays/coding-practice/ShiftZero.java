import java.util.Scanner;

public class ShiftZero {
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
        int index = 0;
        for (int num : array) {
            if (num != 0)
            {
                array[index++] = num;
            }
        }

        while (index < array.length)
        {
            array[index++] = 0;
        }
    }
}
