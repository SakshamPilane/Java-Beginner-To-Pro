import java.util.Scanner;
public class SearchingAndUpdating {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("How many Elements?: ");
        int n = input.nextInt(), i, element;

        int[] array = new int[n];
        System.out.print("Enter Element into array: ");
        for (i = 0; i < n; i++)
        {
            array[i] = input.nextInt();
        }

        while (true)
        {
            System.out.println("**************************************");
            System.out.println("1. Search Element: ");
            System.out.println("2. Replace Occurrence of a Number: ");
            System.out.println("3. Count All Occurrence of a Number: ");
            System.out.println("4. Display Element: ");
            System.out.println("5. Exit.");
            System.out.print("Select Choice: ");
            int choice = input.nextInt();
            System.out.println("**************************************");
            switch (choice)
            {
                case 1:
                    System.out.print("Enter Element to search: ");
                    element = input.nextInt();
                    searchElement(array,element);
                    break;

                case 2:
                    System.out.print("Enter Element which is to be replaced: ");
                    int primaryElement = input.nextInt();
                    System.out.print("Enter Element which will replace: ");
                    int secondaryElement = input.nextInt();
                    replaceElement(array, primaryElement, secondaryElement);
                    break;

                case 3:
                    System.out.print("Enter element to count it occurrence: ");
                    element = input.nextInt();
                    countElement(array,element);
                    break;

                case 4:
                    System.out.print("Elements entered into array: ");
                    for (i = 0; i < n; i++)
                    {
                        System.out.print(array[i] + " ");
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Exiting.....");
                    input.close();
                    return;

                default:
                    System.out.println("Wrong Input! PLease Try Again!");
                    break;
            }
        }
    }

    public static void searchElement(int[] array, int element) {
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                System.out.print((i + 1) + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Element " + element + " not found.");
        } else {
            System.out.println("Element " + element + " found at above position(s).");
        }
    }

    public static void replaceElement(int[] array, int primaryElement, int secondaryElement)
    {
        int i;
        boolean found = false;
        for (i = 0; i < array.length; i++)
        {
            if (array[i] == primaryElement)
            {
                array[i] = secondaryElement;
                found = true;
            }
        }
        if (found)
        {
            System.out.print("Updated Array: ");
            for (i = 0; i < array.length; i++)
            {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
        else {
            System.out.println("Sorry element " + primaryElement + " not found in array.");
        }
    }

    public static void countElement(int[] array, int element)
    {
        int i, count = 0;
        for (i = 0; i < array.length; i++)
        {
            if (array[i] == element)
            {
                count++;
            }
        }
        if (count == 0)
        {
            System.out.println("Element " + element + " not found in array.");
        }
        else {
            String wordCount = (count > 1) ? " times." : " time.";
            System.out.println(element + " occurred " + count + wordCount);
        }
    }
}
