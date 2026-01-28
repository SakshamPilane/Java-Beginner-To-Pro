package advance_18;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class DebitCard implements PaymentMethod{

    private String debitCardNumber, cvv, expiryDate;

    public void setDebitCardNumber(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public void processPayment(String address) {
        if (checkExpiry(expiryDate))
        {
            System.out.println("Card Validity is Expired! Payment cannot be proceeded!");
            return;
        }
        System.out.print("Dear Customer, Your mandate with reference number - XXXXXX is shipped via our service to your address: ");
        System.out.println(address);
        System.out.print("Total price to be paid via UPI 1008.90/- Rs. and your Debit Card is: ");
        System.out.println("Card's last 3 digits = " + getCardHidden(debitCardNumber) + " with CVV = " + cvv);
    }

    public boolean checkExpiry(String expiryDate)
    {
        DateTimeFormatter dTM = DateTimeFormatter.ofPattern("MM-yyyy");
        YearMonth ym = YearMonth.parse(expiryDate, dTM);
        LocalDate expiry = ym.atEndOfMonth();
        return expiry.isBefore(LocalDate.now());
    }

    public String getCardHidden(String str)
    {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length - 3; i++) {
            charArray[i] = 'X';
        }
        return new String(charArray);
    }
}
