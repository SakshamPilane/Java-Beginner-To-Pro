import java.util.Arrays;
import java.util.Scanner;

public class StringDuplicateRemover {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        if (str.isEmpty())
        {
            System.out.println("Empty String!!...EXITING....!");
            return;
        }

        System.out.println("String without duplicates = " + removeDuplicates(str));

        input.close();
    }

    public static String removeDuplicates(String str) {

        char[] charArr = str.toCharArray();
        int index = 0;

        for (int i = 0; i < charArr.length; i++) {

            boolean flagFound = false;

            char current = charArr[i];
            if (current >= 'A' && current <= 'Z') {
                current = (char) (current + 32);
            }

            for (int j = 0; j < index; j++) {

                char stored = charArr[j];
                if (stored >= 'A' && stored <= 'Z') {
                    stored = (char) (stored + 32);
                }

                if (current == stored) {
                    flagFound = true;
                    break;
                }
            }

            if (!flagFound) {
                charArr[index] = charArr[i];
                index++;
            }
        }

        return new String(Arrays.copyOf(charArr, index));
    }
}
