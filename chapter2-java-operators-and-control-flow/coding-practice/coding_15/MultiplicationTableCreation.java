package coding_15;

import java.util.Scanner;
class MultiplicationTableCreation {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number to create its multiplication table: ");
        int number = input.nextInt(), i;
        for (i = 1; i <= 10; i++)
        {
            System.out.print(number + " x " + i + " = " + number * i + "\n");
        }
        input.close();
    }
}
