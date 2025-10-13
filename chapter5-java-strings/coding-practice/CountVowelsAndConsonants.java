import java.util.Scanner;

public class CountVowelsAndConsonants {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String to find vowels and consonants in it: ");
        String str = input.nextLine();
        System.out.println("String you entered: " + str);
        str = str.toLowerCase().replaceAll("\\s+", "");
        findVowelsAndConsonants(str.toCharArray());
        input.close();
    }

    public static void findVowelsAndConsonants(char[] charArray)
    {
        int vowelsCount = 0, consonantsCount = 0, j = 0, k = 0;
        char[] vowels = new char[charArray.length];
        char[] consonants = new char[charArray.length];
        for (char ch : charArray) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                vowels[j++] = ch;
                vowelsCount++;
            }
            else
            {
                if(ch >= 'a' && ch <= 'z')
                {
                    consonants[k++] = ch;
                    consonantsCount++;
                }
            }
        }

        System.out.println("Total Vowels found : " + vowelsCount);
        System.out.println("Vowels found are: " + new String(vowels));

        System.out.println("Total Consonants found : " + consonantsCount);
        System.out.println("Consonants found are: " + new String(consonants));
    }
}
