package coding_5;

import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Size = ");
        int size = input.nextInt();
        System.out.print("Enter Elements into String Array = ");
        String[] array1 = new String[size];
        for (int i = 0; i < size; i++) {
            array1[i] = input.next();
        }

        System.out.print("Enter Size = ");
        size = input.nextInt();
        System.out.print("Enter Elements into int Array = ");
        Integer[] array2 = new Integer[size];
        for (int i = 0; i < size; i++) {
            array2[i] = input.nextInt();
        }

        System.out.println("String Array Size = " + countElements(array1));
        System.out.println("Integer Array Size = " + countElements(array2));

        input.close();
    }

    public static <T> int countElements(T[] array) {
        int count = 0;
        for (T ignored : array) {
            count++;
        }
        return count;
    }
}
