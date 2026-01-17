package basic_22;

public class Test {
    public static void main(String[] args) {

        MobilePhone phone;

        phone = new IPhone();
        phone.features();

        System.out.println();

        phone = new Android();
        phone.features();
    }
}