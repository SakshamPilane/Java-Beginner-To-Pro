import java.util.Scanner;
public class ReverseANumberMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number to reverse it: ");
        int orgNumber = input.nextInt();
        System.out.println("Reverse number = " + reverseNumber(orgNumber));
        input.close();
    }
    public static int reverseNumber(int number)
    {
        int digit, revNumber = 0;
        while(number > 0)
        {
            digit = number % 10;
            revNumber = revNumber * 10 + digit;
            number = number / 10;
        }
        return revNumber;
    }
}
