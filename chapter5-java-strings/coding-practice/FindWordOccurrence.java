import java.util.Scanner;

public class FindWordOccurrence {
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
        findOccurrence(str);

        input.close();
    }

    public static void findOccurrence(String str) {

        String[] inputWords = str.split(" ");
        String[] words = new String[inputWords.length];
        int[] counts = new int[inputWords.length];

        int uniqueCount = 0;

        for (String currentWord : inputWords) {

            boolean found = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (words[j].equals(currentWord)) {
                    counts[j]++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                words[uniqueCount] = currentWord;
                counts[uniqueCount] = 1;
                uniqueCount++;
            }
        }

        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(words[i] + " → " + counts[i]);
        }
    }
}
