package coding_15;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ATM atmObj = new ATM();
        boolean loggedIn = false;
        Scanner input = new Scanner(System.in);
        double amount;

        while (true) {

            if (!loggedIn) {
                try {
                    System.out.print("Enter PIN: ");
                    String pin = input.next();

                    if (Objects.equals(pin, atmObj.getPinNumber())) {
                        loggedIn = true;
                        System.out.println("User logged in successfully!");
                    } else {
                        throw new InvalidPinException("Invalid PIN! Try again.");
                    }
                }
                catch (InvalidPinException e) {
                    System.out.println(e.getMessage());
                }
            }

            else {
                try {
                    System.out.println("\n1. Deposit Money");
                    System.out.println("2. Withdraw Money");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");

                    int choice = input.nextInt();

                    switch (choice) {

                        case 1:
                            System.out.print("Enter amount to deposit: ");
                            amount = input.nextDouble();
                            atmObj.deposit(amount);
                            break;

                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            amount = input.nextDouble();
                            atmObj.withdraw(amount);
                            break;

                        case 3:
                            atmObj.checkBalance();
                            break;

                        case 4:
                            System.out.println("Thank you for banking with us!");
                            input.close();
                            return;

                        default:
                            System.out.println("Invalid choice!");
                    }
                }
                catch (InvalidInputException |
                       InsufficientBalanceException e) {
                    System.out.println(e.getMessage());
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input! Numbers only.");
                    input.next();
                }
            }
        }
    }
}
