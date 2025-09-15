import java.util.Scanner;
public class StudentsGrades {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.next();

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

        double percentage = (mathMarks + englishMarks + sciMarks + hindiMarks + marathiMarks) / 5;

        if (percentage >= 95)
        {
            System.out.print(name + " you achieved O by scoring " + percentage + "% percentage");
        }
        else if (percentage >= 85)
        {
            System.out.print(name + " you achieved A+ by scoring " + percentage + "% percentage");
        }
        else if (percentage >= 75)
        {
            System.out.print(name + " you achieved A by scoring " + percentage + "% percentage");
        }
        else if (percentage >= 65)
        {
            System.out.print(name + " you achieved B+ by scoring " + percentage + "% percentage");
        }
        else if (percentage >= 55)
        {
            System.out.print(name + " you achieved B by scoring " + percentage + "% percentage");
        }
        else if (percentage >= 45)
        {
            System.out.print(name + " you achieved C by scoring " + percentage + "% percentage");
        }
        else if (percentage >= 35)
        {
            System.out.print(name + " you achieved D by scoring " + percentage + "% percentage");
        }
        else
        {
            System.out.print(name + " you achieved F by scoring " + percentage + "% percentage\n");
            System.out.print("Sorry You Failed Exam! Try Better Next Time");
        }
        input.close();
    }
}
