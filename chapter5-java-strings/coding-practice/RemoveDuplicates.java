public class RemoveDuplicates {

    public static void main(String[] args) {
        String str = "programming";
        boolean[] seen = new boolean[256];  // ASCII characters

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!seen[ch]) {
                seen[ch] = true;
                result += ch;
            }
        }

        System.out.println("Result: " + result);
    }
}
