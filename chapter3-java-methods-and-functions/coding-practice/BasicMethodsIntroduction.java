import java.util.Scanner;
public class BasicMethodsIntroduction {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        printHello();
        System.out.print("Enter a Number to find its square: ");
        int squareNumber = input.nextInt();
        square(squareNumber);
        System.out.print("Enter a Number to check if its even or not?: ");
        int evenNumber = input.nextInt();
        isEven(evenNumber);
        input.close();
    }
    public static void printHello()
    {
        System.out.print("Hello User welcome to our automated program please follow instruction given below!\n");
    }
    public static void square(int number)
    {
        System.out.print("Square of " + number + " is : " + number*number + "\n");
    }
    public static void isEven(int number)
    {
        String isEven = (number%2==0) ? " is an Even number\n" : " is Not an even number\n";
        System.out.print("Given number " + number + isEven);
    }
}
