package basic_25;

public abstract class Account {

    private String accHolderName;
    private double balance;
    private String accType;

    // common behavior
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Successfully deposited = " + amount);
        showBalance();
    }

    // behavior differs → abstract
    public abstract void withdraw(double amount);
    public abstract void showBalance();

    // getters & setters
    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }
}
