import java.util.Scanner;
public class PrintEvenNumbersInRange {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int i = 2, range;
        System.out.print("Enter Range of Even Numbers to find?: ");
        range = input.nextInt();
        System.out.print("Even Numbers are: ");
        while (i<=100)
        {
            System.out.print(i + " ");
            i+=2;
        }
        input.close();
    }
}