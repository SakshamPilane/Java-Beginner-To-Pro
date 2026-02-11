package coding_3;

import java.util.Arrays;
import java.util.Scanner;

public class StringFrequencyCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string to count frequency of each character: ");
        String str = input.nextLine();

        if (str.isEmpty()) return;

        // get user input
        System.out.println("String entered = " + str);

        freqCount(str);

        input.close();
    }

    public static void freqCount(String str)
    {
        char[] charArray = str.toLowerCase().toCharArray();
        Arrays.sort(charArray);
        int count = 1;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i-1])
            {
                count++;
            }
            else
            {
                System.out.println(charArray[i - 1] + " occurs " + count + " time(s)");
                count = 1;
            }
        }
        System.out.println(charArray[charArray.length - 1] + " occurs " + count + " time(s)");
    }
}
