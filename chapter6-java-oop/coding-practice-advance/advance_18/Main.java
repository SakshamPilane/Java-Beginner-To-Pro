package advance_18;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String address, cvv, expiryDate;
        System.out.print("Enter Shipping address: ");
        address = input.nextLine();
        System.out.println("1. Pay Using Cash.");
        System.out.println("2. Pay Using UPI.");
        System.out.println("3. Pay Using Debit Card.");
        System.out.println("4. Pay Using Credit Card.");
        System.out.print("Enter a choice: ");
        int choice = input.nextInt();
        input.nextLine();
        PaymentMethod pay;
        switch (choice)
        {
            case 1:
                pay = new Cash();
                pay.processPayment(address);
                break;
            case 2:
                pay = new UPI();
                System.out.print("Enter your UPI ID: ");
                String upiId = input.nextLine();
                ((UPI) pay).setUpiId(upiId);
                pay.processPayment(address);
                break;

            case 3:
                pay = new DebitCard();
                System.out.print("Enter your Debit Card number: ");
                String debitCardNumber = input.nextLine();
                System.out.print("Enter your Debit Card CVV number: ");
                cvv = input.nextLine();
                System.out.print("Enter your Debit Card Expiry Date in format (MM-YYYY): ");
                expiryDate = input.nextLine();
                ((DebitCard) pay).setDebitCardNumber(debitCardNumber);
                ((DebitCard) pay).setCvv(cvv);
                ((DebitCard) pay).setExpiryDate(expiryDate);
                pay.processPayment(address);
                break;

            case 4:
                pay = new CreditCard();
                System.out.print("Enter your Debit Card number: ");
                String creditCardNumber = input.nextLine();
                System.out.print("Enter your Debit Card CVV number: ");
                cvv = input.nextLine();
                System.out.print("Enter your Debit Card Expiry Date in format (MM-YYYY): ");
                expiryDate = input.nextLine();
                ((CreditCard) pay).setCreditCardNumber(creditCardNumber);
                ((CreditCard) pay).setCvv(cvv);
                ((CreditCard) pay).setExpiryDate(expiryDate);
                pay.processPayment(address);
                break;
        }
    }
}
