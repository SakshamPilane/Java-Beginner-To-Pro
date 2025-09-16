import java.util.Scanner;
public class PrintOneToN {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("How many elements do you want to print?: ");
        int n = input.nextInt();
        int i;
        for(i = 1; i <= n; i++)
        {
            System.out.print(i + " ");
        }
        input.close();
    }
}
