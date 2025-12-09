import java.util.Scanner;

public class FirstRepeating {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        if (str.isEmpty()) return;

        System.out.println("String entered = " + str);

        char c = findR(str);

        if (c == '\0') {
            System.out.println("No Repeating character found!");
        } else {
            System.out.println("First Repeating character = " + c);
        }

        input.close();
    }

    public static char findR(String str)
    {
        char[] charArray = str.toLowerCase().toCharArray();
        for (char c : charArray) {
            int count = 0;
            for (char value : charArray) {
                if (c == value) {
                    count++;
                    if (count > 1) {
                        return c;
                    }
                }
            }
        }
        return '\0';
    }
}
