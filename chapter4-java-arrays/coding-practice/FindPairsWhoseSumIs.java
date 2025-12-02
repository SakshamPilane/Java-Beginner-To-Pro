import java.util.Arrays;
import java.util.Scanner;

public class FindPairsWhoseSumIs {
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

        System.out.print("Enter element to find its sum if exists: ");
        int element = input.nextInt();

        Arrays.sort(array);
        sumOfPairs(array, element);
    }

    public static void sumOfPairs(int[] array, int element)
    {
        int left = 0;
        int right = array.length - 1;
        boolean found = false;

        while(left < right)
        {
            int sum = array[left] + array[right];

            if(sum == element)
            {
                System.out.println("Pair found: (" + array[left] + ", " + array[right] + ")");
                found = true;
                left++;
                right--;
            }
            else if(sum < element)
            {
                left++;
            }
            else
            {
                right--;
            }
        }

        if(!found)
        {
            System.out.println("No such pair exists!");
        }
    }
}