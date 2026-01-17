package basic_25;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to OOP Banking System!");
        System.out.println("Choose Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter Choice: ");

        int choice = input.nextInt();
        input.nextLine();

        Account accObj;

        switch (choice) {
            case 1:
                accObj = new SavingsAccount();
                accObj.setAccType("Savings Account");
                break;

            case 2:
                accObj = new CurrentAccount();
                accObj.setAccType("Current Account");
                break;

            default:
                System.out.println("Invalid choice!");
                input.close();
                return;
        }

        System.out.print("Enter Account Holder Name: ");
        accObj.setAccHolderName(input.nextLine());

        System.out.print("Enter Initial Balance: ");
        accObj.deposit(input.nextDouble());

        System.out.println(accObj.getAccHolderName() + " " + accObj.getAccType() + " created successfully!");

        accObj.deposit(20000);
        accObj.withdraw(30000);
        accObj.showBalance();

        input.close();
    }
}
