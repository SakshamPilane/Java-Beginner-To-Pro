import java.util.*;

public class SpacesRemover {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = input.nextLine();

        System.out.println("Given String = " + str);
        char[] charArray = str.toCharArray();

        System.out.println("Removing Spaces....");
        char[] copyArray = removeSpaceMethod(charArray);
        System.out.println("String After Removing Space = " + new String(copyArray));

        input.close();
    }

    public static char[] removeSpaceMethod(char[] charArray) {
        int i, j = 0, n = charArray.length;
        char[] smaller = new char[n];
        for (i = 0; i < n; i++) {
            if (charArray[i] != ' ') {
                smaller[j++] = charArray[i];
            }
        }
        return Arrays.copyOf(smaller, j);
    }
}
