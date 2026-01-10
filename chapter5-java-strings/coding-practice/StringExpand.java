import java.util.Scanner;

public class StringExpand {
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
        String expandedStr = expand(str);

        System.out.println("Expanded String = " + expandedStr);

        input.close();
    }

    public static String expand(String compressed) {
        if (compressed == null || compressed.isEmpty()) return "";
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < compressed.length()) {
            char ch = compressed.charAt(i++);
            int count = 0;
            while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                count = count * 10 + (compressed.charAt(i) - '0');
                i++;
            }

            result.append(String.valueOf(ch).repeat(Math.max(0, count)));
        }
        return result.toString();
    }
}