package basic_25;

public class CurrentAccount extends Account {

    private double overdraft = 0;

    @Override
    public void withdraw(double amount) {
        if (getBalance() < amount) {
            overdraft += (amount - getBalance());
        }
        setBalance(getBalance() - amount);
        System.out.println("Successfully withdrawn = " + amount);
        showBalance();
    }

    @Override
    public void showBalance() {
        System.out.println("Current Balance = " + getBalance());
        System.out.println("Overdraft Used = " + overdraft);
    }
}
