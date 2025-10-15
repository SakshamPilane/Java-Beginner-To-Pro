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
        int i, count = 0;
        for (i = 0; i < sentenceArray.length; i++)
        {
            while (i < sentenceArray.length && (sentenceArray[i] == ' ' || sentenceArray[i] == '\n' || sentenceArray[i] == '\t'))
            {
                i++;
            }
            if (i < sentenceArray.length && (sentenceArray[i] >= 'a' && sentenceArray[i] <= 'z'))
            {
                count++;
                while (i < sentenceArray.length && (sentenceArray[i] != ' ' && sentenceArray[i] != '\n' && sentenceArray[i] != '\t'))
                {
                    i++;
                }
            }
        }
        return count;
    }
}
