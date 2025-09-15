import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TakingUserInputMethodTwo {
    // for taking user input from keyboard BufferedReader,InputStreamReader and IOException classes will be used
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("Enter Your Name: ");
        String name = br.readLine(); // .readLine() function or method is used to take input for strings only
        System.out.print("Enter Your Name: ");
        int age = br.read(); // .read() function or method is used to take input for integers
        System.out.print("Your name is: " + name + "\n");
        System.out.print("Your age is: " + age + "\n");
    }
}
