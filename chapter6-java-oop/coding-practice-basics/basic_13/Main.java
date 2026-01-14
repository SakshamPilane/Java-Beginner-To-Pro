package basic_13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BankAccount account = new BankAccount(100000);

        while (true) {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();

                    if (depositAmount < 500) {
                        System.out.println("Cannot deposit less than 500!");
                    } else {
                        account.deposit(depositAmount);
                        System.out.println("Deposit Successful!");
                        System.out.println("Current Balance = " + account.getBalance());
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();

                    if (withdrawAmount < 500) {
                        System.out.println("Cannot withdraw less than 500!");
                    } else {
                        account.withdraw(withdrawAmount);
                        System.out.println("Current Balance = " + account.getBalance());
                    }
                    break;

                case 3:
                    System.out.println("Current Balance = " + account.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using our Bank!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }
}