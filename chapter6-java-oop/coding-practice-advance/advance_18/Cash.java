package advance_18;

public class Cash implements PaymentMethod{
    @Override
    public void processPayment(String address) {
        System.out.print("Dear Customer, Your mandate with reference number - XXXXXX is shipped via our service to your address: ");
        System.out.println(address);
        System.out.println("Total price to be paid via cash 1008.90/- Rs.");
    }
}