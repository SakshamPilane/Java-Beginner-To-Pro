import java.util.Scanner;

public class ArrayBasics {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Size of Array?: ");
        int n = input.nextInt(), i;
        if (n <= 0) {
            System.out.println("Array size must be greater than 0.");
            return;
        }
        int[] array = new int[n]; // array declaration
        System.out.print("Enter elements: ");
        for (i = 0; i < n; i++)
        {
            array[i] = input.nextInt(); // entering elements into array
        }
        System.out.print("Array = ");
        for (i = 0; i < n; i++)
        {
            System.out.print(array[i] + " "); // printing elements from array
        }
        System.out.println();
        while(true)
        {
            System.out.println("1. Sum all elements.");
            System.out.println("2. Find average of all elements.");
            System.out.println("3. Find Largest Element.");
            System.out.println("4. Find Smallest Element.");
            System.out.println("5. Exit.");
            System.out.print("Select one: ");
            int choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    sumOfElements(array);
                    break;
                case 2:
                    averageOfElements(array);
                    break;
                case 3:
                    largestElement(array);
                    break;
                case 4:
                    smallestElement(array);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid Choice Try Again!");
                    break;
            }
        }
    }

    public static void sumOfElements(int[] array)
    {
        int i, sum = 0;
        for (i = 0; i < array.length; i++)
        {
            sum += array[i];
        }
        System.out.println("Sum of elements = " + sum);
    }

    public static void averageOfElements(int[] array)
    {
        int i, sum = 0;
        for (i = 0; i < array.length; i++)
        {
            sum += array[i];
        }
        double avg = (double) sum / array.length;
        System.out.println("Average of elements = " + avg);
    }

    public static void largestElement(int[] array)
    {
        int i, max = array[0];
        for (i = 1; i < array.length; i++)
        {
            if (max < array[i])
            {
                max = array[i];
            }
        }
        System.out.println("Largest Element = " + max);
    }

    public static void smallestElement(int[] array)
    {
        int i, min = array[0];
        for (i = 1; i < array.length; i++)
        {
            if (min > array[i])
            {
                min = array[i];
            }
        }
        System.out.println("Smallest Element = " + min);
    }
}
