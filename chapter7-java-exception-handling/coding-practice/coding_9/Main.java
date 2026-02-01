package coding_9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        bank.deposit(input.nextDouble());
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        bank.withdraw(input.nextDouble());
                        break;

                    case 3:
                        bank.checkBalance();
                        break;

                    case 4:
                        System.out.println("Thank you for banking!");
                        input.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
            catch (InvalidInputException | InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
