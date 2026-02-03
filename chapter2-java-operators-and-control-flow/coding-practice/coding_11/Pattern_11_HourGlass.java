package coding_11;

import java.util.Scanner;

public class Pattern_11_HourGlass {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Size for drawing Complete Hour Glass pattern: ");
        int n = input.nextInt(), i, j;

        for (i = 0; i < n; i++)
        {
            int k = 0;
            while(k<i)
            {
                System.out.print(" ");
                k++;
            }
            for (j = n-1; j >= i; j--)
            {
                System.out.print("* ");
            }
            System.out.print("\n");
        }

        for (i = 1; i < n; i++)
        {
            int k = n-1;
            while(k>i)
            {
                System.out.print(" ");
                k--;
            }
            for (j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        input.close();
    }
}
