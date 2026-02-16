package coding_9;

import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of an array: ");
        int size = input.nextInt();

        Integer[] array = new Integer[size];

        System.out.print("Enter elements into array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        System.out.println("Minimum Found of all Elements from array = " + findMin(array));

        input.close();
    }

    public static <T extends Number & Comparable<T>> T findMin(T[] array)
    {
        T minNumber = array[0];

        for (T num : array)
        {
            if (num.compareTo(minNumber) < 0)
            {
                minNumber = num;
            }
        }

        return minNumber;
    }
}
