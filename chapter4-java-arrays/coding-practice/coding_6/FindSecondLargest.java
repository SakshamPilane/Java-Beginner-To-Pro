package coding_6;

import java.util.Scanner;

class FindSecondLargest {
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

        int number = penultimate(array);

        System.out.print("Second highest number = " + number);

        input.close();
    }

    public static int penultimate(int[] array)
    {
        if (array.length < 2) {
            System.out.println("Need at least 2 elements!");
        }

        int highest = array[0], secondHighest = Integer.MIN_VALUE;

        for (int num : array) {
            if (highest < num)
            {
                secondHighest = highest;
                highest = num;
            }
            else if (num > secondHighest && num != highest)
            {
                secondHighest = num;
            }
        }

        if (secondHighest == Integer.MIN_VALUE)
        {
            System.out.println("No second largest element exists!");
        }
        return secondHighest;
    }
}
