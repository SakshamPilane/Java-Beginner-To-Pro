import java.util.Scanner;
public class PowRecursion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        System.out.print("Enter its Exponential Power: ");
        int power = input.nextInt();
        int expNumber = powerOfNumber(number, power);
        System.out.println(number + "^" + power + " = " + expNumber);
        input.close();
    }
    public static int powerOfNumber(int number, int power)
    {
        if(power == 0 || number == 1)
        {
            return 1;
        }
        else
        {
            return number * powerOfNumber(number, power-1);
        }
    }
}
