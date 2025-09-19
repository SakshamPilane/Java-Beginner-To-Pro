import java.util.Scanner;
public class Pattern_6_HollowPyramid {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Size for drawing hollow Pyramid pattern: ");
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
                if(i==0 || j==0 || j==i || i==n-1)
                {
                    System.out.print("* ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
        input.close();
    }
}
