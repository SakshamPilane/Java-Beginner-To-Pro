import java.util.Scanner;

public class StringPermutation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = input.nextLine();

        if (str.isEmpty()) {
            System.out.println("String is Empty....Exiting....!");
            input.close();
            return;
        }

        char[] arr = str.toCharArray();
        System.out.print("Permutations = ");
        permutateString(0, arr.length, arr);

        input.close();
    }

    public static void permutateString(int startIndex, int length, char[] arr) {

        if (startIndex == length - 1) {
            System.out.print(arr);
            System.out.print(" ");
            return;
        }

        for (int i = startIndex; i < length; i++) {
            swap(startIndex, i, arr);
            permutateString(startIndex + 1, length, arr);
            swap(startIndex, i, arr);
        }
    }

    public static void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}