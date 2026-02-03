package pattern_2;

import java.util.Scanner;

public class Pattern_2_HollowSquare {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Size for drawing hollow square pattern: ");
        int n = input.nextInt(), i, j;
        for ( i = 0; i < n; i++ )
        {
            for ( j = 0; j < n; j++ )
            {
                if (i==0 || i==n-1 || j==0 || j==n-1)
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
