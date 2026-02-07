package coding_8;

import java.util.Arrays;
import java.util.Scanner;

class FreqCounter {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements?: ");
        int n = input.nextInt(), i;

        int[] array = new int[n];

        System.out.print("Enter elements into array of size " + array.length + ": ");
        for (i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        Arrays.sort(array);

        countFreq(array);

        input.close();
    }

    public static void countFreq(int[] array)
    {
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1])
            {
                count++;
            }
            else
            {
                System.out.println(array[i - 1] + " occurs " + count + " time(s)");
                count = 1;
            }
        }
        System.out.println(array[array.length - 1] + " occurs " + count + " time(s)");
    }
}