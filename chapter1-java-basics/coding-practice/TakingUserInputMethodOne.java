import java.util.Scanner; // this is full path of importing scanner class from util package
public class TakingUserInputMethodOne {
    // for taking user input from keyboard Scanner class will be used
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // this is compulsory step to initialize scanner to work
        System.out.print("Enter Your Name: ");
        String name = input.nextLine(); // .nextLine() function or method is used to take input for strings only
        System.out.print("Enter Your Name: ");
        int age = input.nextInt(); // .nextInt() function or method is used to take input for integers only

        System.out.print("Your name is: " + name + "\n");
        System.out.print("Your age is: " + age + "\n");
        input.close(); // step to close scanner also important
    }
}
