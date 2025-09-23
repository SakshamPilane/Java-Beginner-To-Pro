import java.util.Scanner;

public class FindingSecondLargestElement {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements: ");
        int n = input.nextInt();

        int[] array = new int[n];
        if (n < 2)
        {
            System.out.println("Array must have at least 2 elements!");
            return;
        }

        System.out.print("Enter Elements: ");
        for (int i = 0; i < n; i++)
        {
            array[i] = input.nextInt();
        }

        System.out.print("Elements entered: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        findSecondLargest(array);

        input.close();
    }

    public static void findSecondLargest(int[] array)
    {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int num : array) {
            if(num > max)
            {
                secondMax = max;
                max = num;
            }
            else if (num > secondMax && num != max)
            {
                secondMax = num;
            }
        }

        if (secondMax == Integer.MIN_VALUE)
        {
            System.out.println("No distinct second largest element exists.");
        }
        else
        {
            System.out.println("Largest Element: " + max);
            System.out.println("Second Largest Element: " + secondMax);
        }
    }
}
