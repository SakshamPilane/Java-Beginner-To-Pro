package basic_25;

public class SavingsAccount extends Account {

    @Override
    public void withdraw(double amount) {
        if (getBalance() < amount) {
            System.out.println("Insufficient balance! Withdrawal denied.");
            return;
        }
        setBalance(getBalance() - amount);
        System.out.println("Successfully withdrawn = " + amount);
        showBalance();
    }

    @Override
    public void showBalance() {
        System.out.println("Current Balance = " + getBalance());
    }
}
