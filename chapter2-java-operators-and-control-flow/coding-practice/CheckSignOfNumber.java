import java.util.Scanner;
public class CheckSignOfNumber {
    public static void main(String[] args)
    {
        // In this program we will check sign's of a number whether it is negative or positive or zero
        // using decision control statements
        Scanner input = new Scanner(System.in);

        System.out.print("Enter A Number: ");
        float number = input.nextFloat();

        if(number > 0)
        {
            System.out.print(number + " is a Positive number.\n");
        }
        else if (number == 0)
        {
            System.out.print("Is a Zero number.\n");
        }
        else
        {
            System.out.print(number + " is a Negative Number.\n");
        }
        input.close();
    }
}