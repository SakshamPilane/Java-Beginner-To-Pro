import java.util.Scanner;

public class CharWithMaxFreq {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string = ");
        String str = input.nextLine();

        if (str.isEmpty())
        {
            System.out.println("Empty String!!...EXITING....!");
            input.close();
            return;
        }

        System.out.println("Highest Occurring Char = " + findHighFreqChar(str));

        input.close();
    }

    public static char findHighFreqChar(String str)
    {
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            freq[c]++;
        }

        int max = 0;
        for (int j : freq) {
            if (max < j) {
                max = j;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == max)
            {
                return str.charAt(i);
            }
        }

        return '\0';
    }
}
