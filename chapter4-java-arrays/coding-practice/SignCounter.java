import java.util.Scanner;

public class SignCounter {
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

        System.out.println("Total Positive Numbers in array are: " + positiveCount(array));
        System.out.println("Total Negative Numbers in array are: " + negativeCount(array));
        System.out.println("Total Zero Numbers in array are: " + zeroCount(array));

        input.close();
    }

    public static int positiveCount(int[] array)
    {
        int positiveCount = 0;
        System.out.print("Positive numbers found with position: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0)
            {
                System.out.print(array[i] + "(" + i + ") ");
                positiveCount++;
            }
        }
        System.out.println();
        return positiveCount;
    }

    public static int negativeCount(int[] array)
    {
        int negativeCount = 0;
        System.out.print("Negative numbers found with position: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0)
            {
                System.out.print(array[i] + "(" + i + ") ");
                negativeCount++;
            }
        }
        System.out.println();
        return negativeCount;
    }

    public static int zeroCount(int[] array)
    {
        int zeroCount = 0;
        System.out.print("Zero numbers found with position: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
            {
                System.out.print(array[i] + "(" + i + ") ");
                zeroCount++;
            }
        }
        System.out.println();
        return zeroCount;
    }
}
