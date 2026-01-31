package coding_8;

import java.util.Scanner;

public class StudentPassFail {

    public static void marksGained(float percentage, String name) throws isPassException
    {
        if (percentage < 45)
        {
            throw new isPassException(name + " you have Failed the exam with F Grade!");
        } else if (percentage >= 45 && percentage < 55) {
            throw new isPassException(name + " you have Passed the exam with D Grade!");
        } else if (percentage >= 55 && percentage < 65) {
            throw new isPassException(name + " you have Passed the exam with C Grade!");
        } else if (percentage >= 65 && percentage < 75) {
            throw new isPassException(name + " you have Passed the exam with B Grade!");
        } else if (percentage >= 75 && percentage < 85) {
            throw new isPassException(name + " you have Passed the exam with A Grade!");
        } else if (percentage >= 85 && percentage <= 100) {
            throw new isPassException(name + " you have Passed the exam with O Grade!");
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in))
        {
            System.out.println("Enter name: ");
            String name = input.nextLine();
            System.out.println("Enter percentage: ");
            float percentage = input.nextFloat();
            marksGained(percentage,name);
        }
        catch (isPassException iPE)
        {
            System.out.println(iPE.getMessage());
        }
    }
}