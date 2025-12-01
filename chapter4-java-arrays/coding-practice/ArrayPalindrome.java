import java.util.Arrays;
import java.util.Scanner;

public class ArrayPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size for array: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Array size cannot be less than or equal to 0! EXITING.....");
            return;
        }

        int[] array = new int[n];

        System.out.print("Enter Elements into array: ");
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        if (checkPalindrome(array))
        {
            System.out.print("Array " + Arrays.toString(array) + " is a palindrome");
        }
        else
        {
            System.out.print("Array " + Arrays.toString(array) + " is not a palindrome");
        }
    }

    public static boolean checkPalindrome(int[] array)
    {
        for (int i = 0, j = array.length - 1; i < array.length/2; i++, j--) {
            if (array[i] != array[j])
            {
                return false;
            }
        }
        return true;
    }
}
