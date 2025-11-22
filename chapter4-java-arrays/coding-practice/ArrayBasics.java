import java.util.Scanner;

public class ArrayBasics {
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

        while (true)
        {
            System.out.println("************************************");
            System.out.println("1. Display Array");
            System.out.println("2. Print Reverse Array");
            System.out.println("3. Find sum of all elements in array");
            System.out.println("4. Find max of all elements in array");
            System.out.println("5. Find min of all elements in array");
            System.out.println("6. Count Number of elements in array");
            System.out.println("7. Search for an element in array");
            System.out.println("8. Exit");
            System.out.println("************************************");
            int choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    printArray(array);
                    break;
                case 2:
                    printReverseArray(array);
                    break;
                case 3:
                    sumElements(array);
                    break;
                case 4:
                    findMax(array);
                    break;
                case 5:
                    findMin(array);
                    break;
                case 6:
                    countElements(array);
                    break;
                case 7:
                    System.out.print("Enter Element to Search: ");
                    int element = input.nextInt();
                    int position = findElement(array, element);
                    if(position == -1)
                    {
                        System.out.println("Element " + element + " found at position " + position);
                    }
                    else {
                        System.out.println("Element " + element + " not found in array");
                    }
                    break;
                case 8:
                    System.out.println("Exiting....");
                    input.close();
                    return;
                default:
                    break;
            }
        }
    }

    public static void printArray(int[] array)
    {
        System.out.print("Array: ");
        for (int i : array)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printReverseArray(int[] array)
    {
        System.out.print("Array: ");
        for (int i = array.length - 1; i >= 0; i--)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void sumElements(int[] array)
    {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        System.out.println("Sum of all elements = " + sum);
    }

    public static void findMax(int[] array)
    {
        int max = Integer.MIN_VALUE;
        for (int j : array) {
            if (max < j) {
                max = j;
            }
        }
        System.out.println("Max of all elements = " + max);
    }

    public static void findMin(int[] array)
    {
        int min = Integer.MAX_VALUE;
        for (int j : array) {
            if (min > j) {
                min = j;
            }
        }
        System.out.println("Min of all elements = " + min);
    }

    public static void countElements(int[] array)
    {
        int count = 0;
        for (int j : array) {
            count++;
        }
        System.out.println("Total Number of elements in array = " + count);
    }

    public static int findElement(int[] array, int element)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (element == array[i])
            {
                return i;
            }
        }
        return -1;
    }
}
