import java.util.Scanner;

public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        if (str.isEmpty()) return;

        System.out.println("String entered = " + str);

        char c = findNR(str);

        if (c == '\0') {
            System.out.println("No non-repeating character found!");
        } else {
            System.out.println("Non-repeating character = " + c);
        }

        input.close();
    }

    public static char findNR(String str)
    {
        char[] charArray = str.toCharArray();
        for (char value : charArray) {
            int count = 0;
            for (char item : charArray) {
                if (value == item) {
                    count++;
                    if (count > 1) {
                        break;
                    }
                }
            }
            if (count == 1) {
                return value;
            }
        }
        return '\0';
    }
}
