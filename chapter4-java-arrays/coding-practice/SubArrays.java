import java.util.Scanner;

public class SubArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size for array: ");
        int n = input.nextInt();
        if (n <= 0) {
            System.out.println("Array size cannot be less than or equal to 0! EXITING.....");
            return;
        }

        int[] array = new int[n];
        System.out.print("Enter elements into array: ");
        for (int i = 0; i < n; i++) array[i] = input.nextInt();
        createSubArrays(array);
    }

    public static void createSubArrays(int[] array)
    {
        System.out.println("Subarrays : ");
        for (int i = 0; i < array.length ; i++) {
            for (int j = i; j < array.length; j++) {
                System.out.print("{");
                for (int k = i; k <= j; k++) {
                    System.out.print(array[k]);
                    if (k < j){
                        System.out.print(", ");
                    }
                }
                System.out.print("} ");
                if (j < array.length-1)
                {
                    System.out.print("; ");
                }
            }
            System.out.println();
        }
    }
}