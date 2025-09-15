import java.util.Scanner;
public class AbsoluteValueFinder {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double absNumber = input.nextDouble();

        double temp;
        temp = (absNumber >= 0) ? absNumber : -absNumber;
        System.out.print("Absolute value of " + absNumber + " is " + temp + " and it is " + temp + " units away from centre.");

        input.close();
    }
}
