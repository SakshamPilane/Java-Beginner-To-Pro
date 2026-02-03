package pattern_1;

import java.util.Scanner;
public class Pattern_1_Square {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Size for drawing square pattern: ");
        int n = input.nextInt(), i, j;
        for ( i = 0; i < n; i++ )
        {
            for ( j = 0; j < n; j++ )
            {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        input.close();
    }
}
