import java.util.Scanner;
public class MethodWithVarArgs {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        calcSum(10,20,30,40,50);
        calcSum(10,20,30,40);
        calcSum(10,20,30);
        calcSum(10,20);
        input.close();
    }
    public static void calcSum(int... numbers)
    {
        int sum = 0;
        for(int num : numbers)
        {
            sum += num;
        }
        System.out.println("Total Sum = " + sum);
    }
}
