package coding_4;

import java.util.Scanner;

public class MultiExceptionHandling {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            Class.forName("coding_4.IsEligible");

            System.out.print("Enter age: ");
            int age = input.nextInt();

            checkEligibility(age);

        } catch (ClassNotFoundException | IsEligible e) {
            // TRUE multi-catch
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    static void checkEligibility(int age) throws IsEligible {

        if (age >= 18) {
            throw new IsEligible("Eligible to vote");
        } else {
            throw new IsEligible("Not eligible to vote");
        }
    }
}
