import java.util.Scanner;
public class MethodsWithParametersAndReturn {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Hello " + name + " Welcome to Custom Calculator Interface Program!");
        int choice;
        while (true)
        {
            System.out.println("*************************************");
            System.out.println("1. Largest of 2 numbers program?");
            System.out.println("2. Calculate Area of circle program?");
            System.out.println("3. Check if a Prime number program?");
            System.out.println("4. Calculate Simple Interest program?");
            System.out.println("5. Calculate Final Grade program?");
            System.out.println("6. Exit!");
            System.out.println("Enter Choice (1,2,3,4,5): ");
            choice = input.nextInt();
            System.out.println("*************************************");
            switch (choice)
            {
                case 1:
                    System.out.print("Enter first number: ");
                    int number1 = input.nextInt();
                    System.out.print("Enter second number: ");
                    int number2 = input.nextInt();
                    int largestNumber = largestNumber(number1,number2);
                    System.out.println("Largest number is: " + largestNumber);
                    break;

                case 2:
                    System.out.print("Enter radius of a circle: ");
                    double radius = input.nextDouble();
                    double area = areaOfCircle(radius);
                    System.out.println("Area of Circle is: " + area);
                    break;

                case 3:
                    System.out.print("Enter a number to check if it is prime or not?: ");
                    int primeNumber = input.nextInt();
                    if(isPrime(primeNumber))
                    {
                        System.out.println(primeNumber + " is Prime.");
                    }
                    else {
                        System.out.println(primeNumber + " is not Prime.");
                    }
                    break;

                case 4:
                    System.out.print("Enter a Principal Amount: ");
                    double principalAmount = input.nextInt();
                    System.out.print("Enter a Annual Rate Interest %: ");
                    double annualRateInterest = input.nextInt();
                    System.out.print("Enter a Time Period in Years: ");
                    int timePeriod = input.nextInt();
                    double sI = simpleInterest(principalAmount,annualRateInterest,timePeriod);
                    System.out.println("Simple Interest = " + sI);
                    break;

                case 5:
                    System.out.print(name + " enter your marks of math subject out of 100: ");
                    double mathMarks = input.nextDouble();
                    System.out.print(name + " enter your marks of english subject out of 100: ");
                    double englishMarks = input.nextDouble();
                    System.out.print(name + " enter your marks of science subject out of 100: ");
                    double sciMarks = input.nextDouble();
                    System.out.print(name + " enter your marks of hindi subject out of 100: ");
                    double hindiMarks = input.nextDouble();
                    System.out.print(name + " enter your marks of marathi subject out of 100: ");
                    double marathiMarks = input.nextDouble();
                    String Grade = gradesCalculator(mathMarks,englishMarks,sciMarks,hindiMarks,marathiMarks);
                    System.out.println(name + " you achieved " + Grade);
                    break;

                case 6:
                    System.out.println("Exiting Program Menu....!");
                    return;

                default:
                    System.out.println("Invalid Choice Try Again!");
                    break;
            }
        }
    }

    public static int largestNumber(int number1, int number2)
    {
        return Math.max(number1, number2);
    }

    public static double areaOfCircle(double radius)
    {
        return Math.PI * radius * radius;
    }

    public static boolean isPrime(int number)
    {
        if (number <= 1)
        {
            return false;
        }
        int i;
        for(i = 2; i <= Math.sqrt(number); i++)
        {
            if(number % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static double simpleInterest(double principalAmount, double annualRateInterest, int timePeriod)
    {
        return (principalAmount * annualRateInterest * timePeriod) / 100;
    }

    public static String gradesCalculator(double mathMarks,double englishMarks,double sciMarks,double hindiMarks,double marathiMarks)
    {
        double percentage = (mathMarks + englishMarks + sciMarks + hindiMarks + marathiMarks) / 5;

        if (percentage >= 95)
        {
            return "O";
        }
        else if (percentage >= 85)
        {
            return "A+";
        }
        else if (percentage >= 75)
        {
            return "A";
        }
        else if (percentage >= 65)
        {
            return "B+";
        }
        else if (percentage >= 55)
        {
            return "B";
        }
        else if (percentage >= 45)
        {
            return "C";
        }
        else if (percentage >= 35)
        {
            return "D";
        }
        else
        {
            return "F";
        }
    }
}