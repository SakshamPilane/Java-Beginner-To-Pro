package coding_3;

import java.util.Scanner;

class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 2 Numbers: ");
        Integer[] swapArrays1 = new Integer[2];
        swapArrays1[0] = input.nextInt();
        swapArrays1[1] = input.nextInt();
        swap(swapArrays1,0,1);

        System.out.print("Enter 2 Strings: ");
        String[] swapArrays2 = new String[2];
        swapArrays2[0] = input.next();
        swapArrays2[1] = input.next();
        swap(swapArrays2,0,1);

        for (int i = 0; i < 2; i++) {
            System.out.print(swapArrays1[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < 2; i++) {
            System.out.print(swapArrays2[i] + " ");
        }

        input.close();
    }

    public static <T> void swap(T[] array, int i, int j)
    {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
