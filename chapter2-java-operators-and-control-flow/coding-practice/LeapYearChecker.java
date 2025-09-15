import java.util.Scanner;
public class LeapYearChecker {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Year: ");
        int year = input.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
        {
            System.out.print(year + " is a Leap Year.");
        }
        else
        {
            System.out.print(year + " is not a Leap Year.");
        }
        input.close();
    }
}