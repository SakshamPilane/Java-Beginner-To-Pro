import java.util.Scanner;
public class NumberToWords {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter any number from (1 to 5): ");
        int number = input.nextInt();

        switch (number)
        {
            case 1:
                System.out.print(number + " = One");
                break;
            case 2:
                System.out.print(number + " = Two");
                break;
            case 3:
                System.out.print(number + " = Three");
                break;
            case 4:
                System.out.print(number + " = Four");
                break;
            case 5:
                System.out.print(number + " = Five");
                break;
            default:
                System.out.print("Number Exceeds 1 to 5 range!");
                break;
        }
        input.close();
    }
}
