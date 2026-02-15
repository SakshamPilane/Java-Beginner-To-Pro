package coding_8;

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

        System.out.println("Maximum Found of all Elements from array = " + findMax(array));

        input.close();
    }

    public static <T extends Comparable<T>> T findMax(T[] array)
    {
        T maxNumber = array[0];
        for (T t : array) {
            if (t.compareTo(maxNumber) > 0) {
                maxNumber = t;
            }
        }
        return maxNumber;
    }
}
