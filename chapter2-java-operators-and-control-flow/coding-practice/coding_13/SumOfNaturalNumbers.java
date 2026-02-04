package coding_13;

import java.util.Scanner;
class SumOfNaturalNumbers {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Range: ");
        int range = input.nextInt(), i, sum = 0;
        for (i=1;i<=range;i++)
        {
            sum += i;
        }
        System.out.print("Sum of Natural Numbers = " + sum);
        input.close();
    }
}
