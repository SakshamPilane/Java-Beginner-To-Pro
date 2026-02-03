package coding_8;

import java.util.Scanner;
public class Pattern_8_HalfDiamond {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Size for drawing Half Diamond pattern: ");
        int n = input.nextInt();
        rightHalf(n);
        leftHalf(n);
        input.close();
    }

    public static void rightHalf(int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = n - 2; j >= i; j--)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void leftHalf(int n)
    {
        for (int i = 0; i < n; i++)
        {
            int k = n-1;
            while (k > i)
            {
                System.out.print("  ");
                k--;
            }
            for (int j = 0; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++)
        {
            int k = 0;
            while (k <= i)
            {
                System.out.print("  ");
                k++;
            }
            for (int j = n-2; j >= i; j--)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
