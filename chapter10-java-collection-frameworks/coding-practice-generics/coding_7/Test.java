package coding_7;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of an array: ");
        int size = input.nextInt();

        Integer[] array = new Integer[size];

        System.out.print("Enter elements into array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        System.out.println("Sum of all Elements from array = " + sumOfArrayUsingGenerics(array));

        input.close();
    }

    public static <T extends Number> double sumOfArrayUsingGenerics(T[] array)
    {
        double sum = 0;

        for (T t : array) {
            sum += t.doubleValue();
        }
        return sum;
    }
}
