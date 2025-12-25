import java.util.Scanner;

public class AnagramCheck {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first String: ");
        String str1 = input.nextLine().toLowerCase().replaceAll("\\s+", "");

        System.out.print("Enter second String: ");
        String str2 = input.nextLine().toLowerCase().replaceAll("\\s+", "");

        if (isAnagram(str1, str2)) {
            System.out.println("Both strings ARE anagrams!");
        } else {
            System.out.println("Both strings are NOT anagrams!");
        }

        input.close();
    }
    
    public static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }
}
