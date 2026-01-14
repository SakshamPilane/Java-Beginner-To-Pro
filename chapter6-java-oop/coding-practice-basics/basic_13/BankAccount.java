package basic_13;

public class BankAccount {
    private double bankMoney;

    public BankAccount(double m) {
        System.out.println("Welcome to our Bank");
        bankMoney = m;
    }

    public void deposit(double d) {
        bankMoney += d;
    }

    public void withdraw(double w) {
        if (w > bankMoney) {
            System.out.println("Insufficient Balance!");
            return;
        }
        bankMoney -= w;
    }

    public double getBalance() {
        return bankMoney;
    }
}