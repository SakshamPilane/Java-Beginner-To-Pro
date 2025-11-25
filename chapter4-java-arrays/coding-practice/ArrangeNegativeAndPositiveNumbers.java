import java.util.Scanner;

public class ArrangeNegativeAndPositiveNumbers {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements?: ");
        int n = input.nextInt(), i;

        if (n <= 0)
        {
            System.out.print("Size cannot be less than 0!");
            System.out.print("Exiting....");
            return;
        }

        int[] array = new int[n];

        System.out.print("Enter elements into array of size " + array.length + ": ");
        for (i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        shiftNumbers(array);

        System.out.print("Negative and Positive shifted array: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        input.close();
    }

    public static void shiftNumbers(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {

            if (arr[left] < 0) {
                left++;
            }
            else if (arr[right] >= 0) {
                right--;
            }
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }
}
