package coding_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)){
            System.out.print("Enter age: ");
            int age = input.nextInt();
            if (age >= 18)
            {
                throw new IsEligible("Is Eligible to Vote!");
            }
            else
            {
                throw new IsEligible("Is not Eligible to Vote!");
            }
        }
        catch (IsEligible iE)
        {
            System.out.println(iE.getMessage());
        }
        finally {
            System.out.println("Ending Program...");
        }
    }
}
