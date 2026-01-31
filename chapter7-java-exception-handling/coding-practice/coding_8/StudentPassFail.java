package coding_8;

import java.util.Scanner;

public class StudentPassFail {

    public static String marksGained(float percentage, String name)
            throws InvalidMarksException {

        if (percentage < 0 || percentage > 100) {
            throw new InvalidMarksException("Invalid Marks Entered!");
        }

        if (percentage < 45) {
            return name + " has Failed with F Grade";
        } else if (percentage < 55) {
            return name + " has Passed with D Grade";
        } else if (percentage < 65) {
            return name + " has Passed with C Grade";
        } else if (percentage < 75) {
            return name + " has Passed with B Grade";
        } else if (percentage < 85) {
            return name + " has Passed with A Grade";
        } else {
            return name + " has Passed with O Grade";
        }
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter name: ");
            String name = input.nextLine();

            System.out.print("Enter percentage: ");
            float percentage = input.nextFloat();

            String result = marksGained(percentage, name);
            System.out.println(result);

        } catch (InvalidMarksException e) {
            System.out.println(e.getMessage());
        }
    }
}
