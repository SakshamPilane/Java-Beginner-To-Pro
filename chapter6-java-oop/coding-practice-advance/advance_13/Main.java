package advance_13;

public class Main {
    public static void main(String[] args) {
        Bank bank;

        bank = new SBI();
        System.out.println(bank.getInterestRate());

        bank = new HDFC();
        System.out.println(bank.getInterestRate());

        bank = new ICICI();
        System.out.println(bank.getInterestRate());

    }
}
