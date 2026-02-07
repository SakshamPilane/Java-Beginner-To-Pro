package coding_9;

import java.util.Scanner;

class DuplicateRemoverWithoutLosingOrder {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("How many Elements?: ");
        int n = input.nextInt();

        int[] array = new int[n];

        System.out.print("Enter elements into array of size " + array.length + ": ");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }

        int size = removeDuplicates(array);

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        input.close();
    }

    public static int removeDuplicates(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            boolean flagFound = false;
            for (int j = 0; j < index; j++) {
                if (array[i] == array[j])
                {
                    flagFound = true;
                    break;
                }
            }
            if (!flagFound)
            {
                array[index] = array[i];
                index++;
            }
        }

        return index;
    }
}
