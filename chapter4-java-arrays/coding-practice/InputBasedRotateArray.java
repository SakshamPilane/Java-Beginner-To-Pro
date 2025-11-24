import java.util.Scanner;

public class InputBasedRotateArray {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements?: ");
        int n = input.nextInt(), i;

        int[] array = new int[n];

        System.out.print("Enter elements into array of size " + array.length + " to rotate it: ");
        for (i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        System.out.print("By how many places do you want to rotate array: ");
        int index = input.nextInt();

        if (index > n)
        {
            index = index % n;
        }
        rotateArray(array, index);

        System.out.print("Rotated Array: ");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        input.close();
    }

    public static void rotateArray(int[] array, int index)
    {
        rotate(array,0,index-1);
        rotate(array,index,array.length-1);
        rotate(array,0,array.length-1);
    }

    public static void rotate(int[] array, int start,int end)
    {
        while (start < end)
        {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
