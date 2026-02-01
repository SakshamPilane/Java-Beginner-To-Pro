package coding_12;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        while (flag)
        {
            try
            {
                System.out.print("Enter User Name: ");
                String uName = input.nextLine();
                System.out.print("Enter password: ");
                String pwd = input.nextLine();
                if (uName.isEmpty() || pwd.isEmpty())
                {
                    throw new InvalidInputException("User Name and Password cannot be empty!");
                }
                else {
                    flag = false;
                    System.out.println("Hello " + uName + "! Logged In Successfully!");
                }
            }
            catch (InvalidInputException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
