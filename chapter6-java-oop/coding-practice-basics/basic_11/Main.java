package basic_11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Box b1 = new Box();
        System.out.print("Enter Width = ");
        float w = input.nextFloat();
        System.out.print("Enter Height = ");
        float h = input.nextFloat();
        System.out.print("Enter Depth = ");
        float d = input.nextFloat();
        if (w <= 0 || h <= 0 || d <= 0)
        {
            System.out.println("Invalid Input!");
            return;
        }
        Box b2 = new Box(w,h,d);
        System.out.println("Volume of Box with Width = " + w + " Height = " + h + " Depth = " + d + " is " + b2.volume());
        input.close();
    }
}
