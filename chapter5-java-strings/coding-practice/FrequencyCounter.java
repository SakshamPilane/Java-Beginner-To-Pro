import java.util.Arrays;
import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = input.nextLine();

        char[] charArray = str.toLowerCase().toCharArray();

        findCharacters(charArray);
        input.close();
    }

    public static void findCharacters(char[] charArray)
    {
        int i, k;
        char[] freqArray = new char[charArray.length];
        for (i = 0, k = 0; i < charArray.length; i++) {
            if (!searchCharacter(freqArray, charArray[i]))
            {
                freqArray[k++] = charArray[i];
            }
        }
        findFrequency(Arrays.copyOf(freqArray, k), charArray);
    }

    public static boolean searchCharacter(char[] freqArray, char ch)
    {
        int i;
        for (i = 0; i < freqArray.length; i++)
        {
            if (freqArray[i] == ch)
            {
                return true;
            }
        }
        return false;
    }

    public static void findFrequency(char[] freqArray, char[] charArray)
    {
        int i, j;
        for (i = 0; i < freqArray.length; i++) {
            int count = 0;
            for (j = 0; j < charArray.length; j++) {
                if(charArray[j] == freqArray[i])
                {
                    count++;
                }
            }
            String wordString = (count >= 2) ? " times." : " time.";
            System.out.println(freqArray[i] + " occurred " + count + wordString);
        }
    }
}
