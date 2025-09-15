import java.io.*;
public class CheckVowels {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.print("Enter a Alphabet: ");
        char alphabet = br.readLine().toLowerCase().charAt(0);
        int ascii;
        ascii = alphabet;
        if (ascii < 97 || ascii > 122) // or use a method Character.isLetter(alphabet) to check if an alphabet
        {
            System.out.print("Wrong Character! Only Alphabet Needed");
        }
        else if (alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u')
        {
            System.out.print("Is a vowel");
        }
        else
        {
            System.out.print("Is a consonant");
        }
        br.close();
    }
}
