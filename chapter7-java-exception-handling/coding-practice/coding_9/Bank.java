package coding_9;

public class Bank {

    private double balance = 0;

    public void deposit(double amount) throws InvalidInputException {
        if (amount <= 0) {
            throw new InvalidInputException("Invalid deposit amount!");
        }
        balance += amount;
        System.out.println("Amount deposited successfully!");
    }

    public void withdraw(double amount)
            throws InvalidInputException, InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidInputException("Invalid withdrawal amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance -= amount;
        System.out.println("Amount withdrawn successfully!");
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}
