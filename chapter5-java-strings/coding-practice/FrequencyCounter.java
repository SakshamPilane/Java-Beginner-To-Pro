import java.util.Arrays;
import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = input.nextLine().toLowerCase();

        int[] freqArray = new int[128];

        findFrequency(freqArray,str);
        input.close();
    }

    public static void findFrequency(int[] freqArray, String str) {
        int i, ascii = 0;
        for (i = 0; i < str.length(); i++)
        {
            ascii = str.charAt(i);
            freqArray[ascii]++;
        }
        System.out.println("Character frequencies:");
        for (i = 0; i < freqArray.length; i++) {
            if (freqArray[i] > 0) {
                String times = (freqArray[i] > 1) ? "times" : "time";
                System.out.println("'" + (char)i + "' occurred " + freqArray[i] + " " + times + ".");
            }
        }
    }
}
