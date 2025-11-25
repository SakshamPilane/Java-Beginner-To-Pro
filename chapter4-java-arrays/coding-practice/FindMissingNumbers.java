import java.util.Arrays;
import java.util.Scanner;

public class FindMissingNumbers {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size for array: ");
        int n = input.nextInt();

        if(n <= 0)
        {
            System.out.println("Array size cannot be less than or equal to 0! EXITING.....");
            return;
        }

        int[] array = new int[n];

        System.out.print("Enter Elements into array: ");
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        System.out.print("Array Entered: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        Arrays.sort(array);

        findMissing(array);
    }
    
    private static void findMissing(int[] array)
    {
        int low, high;
        boolean missingFound = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1])
            {
                continue;
            }
            if (array[i] - array[i - 1] > 1)
            {
                missingFound = true;
                System.out.print("Missing Numbers from " + array[i - 1] + " to " + array[i] + " are: ");
                low = array[i - 1];
                high = array[i];
                for (int j = low + 1; j < high; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
        if (!missingFound) {
            System.out.println("No missing numbers found.");
        }
    }
}
