import java.util.Scanner;
public class Pattern_4_RightAngledTriangle {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Size for drawing right angled triangle pattern: ");
        int n = input.nextInt(), i, j;
        for ( i = 0; i < n; i++ )
        {
            for ( j = 0; j <= i; j++ )
            {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        input.close();
    }
}
