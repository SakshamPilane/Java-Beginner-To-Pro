import java.util.Arrays;
import java.util.Scanner;

public class MergeArrays {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements for first Array?: ");
        int n = input.nextInt();
        System.out.print("How many Elements for second Array?: ");
        int m = input.nextInt();
        int i;
        int[] firstArray = new int[n];
        int[] secondArray = new int[m];

        System.out.print("Enter elements into first array of size " + n + ": ");
        for (i = 0; i < n; i++) {
            firstArray[i] = input.nextInt();
        }

        System.out.print("Enter elements into second array of size " + m + ": ");
        for (i = 0; i < m; i++) {
            secondArray[i] = input.nextInt();
        }
        mergeArrays(firstArray,secondArray);
        input.close();
    }

    public static void mergeArrays(int[] firstArray, int[] secondArray)
    {
        int max_size = firstArray.length + secondArray.length;
        int[] mergedArray = new int[max_size];
        for (int i = 0; i < firstArray.length; i++) {
            mergedArray[i] = firstArray[i];
        }
        for (int i = 0, j = firstArray.length + i; i < secondArray.length; i++, j++) {
            mergedArray[j] = secondArray[i];
        }

        Arrays.sort(mergedArray);
        System.out.print("Merged Array = ");
        for (int i = 0; i < max_size; i++) {
            System.out.print(mergedArray[i] + " ");
        }
    }
}
