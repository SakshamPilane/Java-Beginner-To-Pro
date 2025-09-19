import java.util.Scanner;

public class Pattern_10_HollowDiamond {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Size for drawing Complete hollow Diamond pattern: ");
        int n = input.nextInt(), i, j;
        for ( i = 0; i < n; i++ )
        {
            int k = n-1;
            while (k>i)
            {
                System.out.print(" ");
                k--;
            }
            for ( j = 0; j <= i; j++ )
            {
                if (j==i||j==0)
                {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
        for ( i = 0; i < n; i++ )
        {
            int k = 0;
            while (k<=i)
            {
                System.out.print(" ");
                k++;
            }
            for ( j = n-2; j >= i; j-- )
            {
                if (j == n-2 || j == i)
                {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
        input.close();
    }
}
