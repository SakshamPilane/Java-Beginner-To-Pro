import java.util.Scanner;
public class Pattern_5_Pyramid {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Size for drawing Pyramid pattern: ");
        int n = input.nextInt(), i, j;
        for ( i = 0; i < n; i++ )
        {
            int k = n;
            while (k > i)
            {
                System.out.print(" ");
                k--;
            }
            for ( j = 0; j <= i; j++ )
            {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        input.close();
    }
}