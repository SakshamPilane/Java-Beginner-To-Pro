import java.util.Scanner;

public class StringFrequencyCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string to reverse it: ");
        String str = input.nextLine();

        // get user input
        System.out.println("String entered = " + str);

        freqCount(str);

        input.close();
    }

    public static void freqCount(String str)
    {
    }
}
