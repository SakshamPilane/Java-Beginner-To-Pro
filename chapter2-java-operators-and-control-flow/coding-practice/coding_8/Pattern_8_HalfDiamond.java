package coding_8;

import java.util.Scanner;
public class Pattern_8_HalfDiamond {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Size for drawing Half Diamond pattern: ");
        int n = input.nextInt(), i, j;
        for ( i = 0; i < n; i++ )
        {
            for ( j = 0; j <= i; j++ )
            {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        for ( i = 0; i < n; i++ )
        {
            for ( j = n-2; j >= i; j-- )
            {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        input.close();
    }
}
