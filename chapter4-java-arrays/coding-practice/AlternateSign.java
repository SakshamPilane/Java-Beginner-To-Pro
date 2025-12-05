import java.util.Scanner;

public class AlternateSign {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements?: ");
        int n = input.nextInt();

        int[] array = new int[n];

        System.out.print("Enter elements into array of size " + array.length + ": ");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        altSignMaker(array);

        input.close();
    }

    public static void altSignMaker(int[] array)
    {
        boolean isNegative = array[0] < 0;
        for (int i = 1; i < array.length; i++) {
            if (isNegative)
            {
                if (array[i] >= 0)
                {
                    isNegative = false;
                    continue;
                }
                int pos = findNextPositive(array, i + 1);
                if (pos == -1)
                {
                    break;
                }
                rotateRight(array, i, pos);
                isNegative = false;
            }
            else
            {
                if (array[i] < 0)
                {
                    isNegative = true;
                    continue;
                }
                int pos = findNextNegative(array, i + 1);
                if (pos == -1)
                {
                    break;
                }
                rotateRight(array, i, pos);
                isNegative = true;
            }
        }

        for (int num : array)
        {
            System.out.print(num + " ");
        }
    }

    public static int findNextNegative(int[] array, int pos)
    {
        for (int i = pos; i < array.length; i++) {
            if (array[i] < 0)
            {
                return i;
            }
        }
        return -1;
    }

    public static int findNextPositive(int[] array, int pos)
    {
        for (int i = pos; i < array.length; i++) {
            if (array[i] >= 0)
            {
                return i;
            }
        }
        return -1;
    }

    public static void rotateRight(int[] array, int start, int end)
    {
        int temp = array[end];
        for (int i = end; i > start; i--) {
            array[i] = array[i - 1];
        }
        array[start] = temp;
    }
}