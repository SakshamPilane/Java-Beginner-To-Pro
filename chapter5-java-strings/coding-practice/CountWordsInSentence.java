import java.util.Scanner;

public class CountWordsInSentence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a Sentence: ");
        String sentence = input.nextLine();

        char[] sentenceArray = sentence.toLowerCase().toCharArray();

        int count = countWords(sentenceArray);

        System.out.print("Total number of words in given sentence : ");
        System.out.print("\"" + sentence + "\"");
        System.out.print(" are " + count);

        input.close();
    }

    public static int countWords(char[] sentenceArray)
    {
        int count = 0;
        boolean inWord = false;
        for (char c : sentenceArray)
        {
            if (c == ' ' || c == '\n' || c == '\t')
            {
                inWord = false;
            }
            else if (!inWord && (c >= 'a' && c <= 'z'))
            {
                inWord = true;
                count++;
            }
        }
        return count;
    }
}
