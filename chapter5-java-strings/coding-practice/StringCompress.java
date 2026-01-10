import java.util.Scanner;

public class StringCompress {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        if (str.isEmpty()) {
            System.out.println("String is Empty....Exiting....!");
            input.close();
            return;
        }
        String compressedStr = compress(str);

        System.out.println("Compressed String = " + compressedStr);

        input.close();
    }

    public static String compress(String str) {
        if (str == null || str.isEmpty()) return "";

        StringBuilder result = new StringBuilder();

        char current = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == current) {
                count++;
            } else {
                result.append(current).append(count);
                current = str.charAt(i);
                count = 1;
            }
        }

        // append last group
        result.append(current).append(count);

        return result.toString();
    }
}
