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
        int i;
        for(i = 0; i < array.length; i++)
        {
            if(array[i] == element)
            {
                System.out.println("Element " + element + " found at position " + (i+1) + ".");
                return;
            }
        }
        System.out.println("Element " + element + " not found.");
    }
}
