package advance_18;

public class UPI implements PaymentMethod{
    private String upiId;

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void processPayment(String address) {
        System.out.print("Dear Customer, Your mandate with reference number - XXXXXX is shipped via our service to your address: ");
        System.out.println(address);
        System.out.print("Total price to be paid via UPI 1008.90/- Rs. and your UPI id is: ");
        System.out.println(upiId);
    }
}
