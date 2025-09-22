import java.util.Scanner;
public class SearchingAnElement {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("How many Elements?: ");
        int n = input.nextInt(), i;

        int[] array = new int[n];
        System.out.print("Enter Element into array: ");
        for (i = 0; i < n; i++)
        {
            array[i] = input.nextInt();
        }
        System.out.print("Enter Element to search: ");
        int element = input.nextInt();
        searchElement(array,element);
        input.close();
    }

    public static void searchElement(int[] array, int element)
    {
        int i, pos = 0;
        boolean flagFound = false;
        for(i = 0; i < array.length; i++)
        {
            if(array[i] == element)
            {
                flagFound = true;
                pos = i+1;
                break;
            }
        }
        if (flagFound)
        {
            System.out.println("Element " + element + " found at position " + pos + ".");
        }
        else {
            System.out.println("Element " + element + " not found.");
        }
    }
}
