package basic_28;

public class BillGenerator {
    public void generateBill(Cart cart)
    {
        CartItem[] items = cart.getCartItemArray();
        if (cart.getCount() == 0)
        {
            System.out.println("Cart is empty. Nothing to bill.");
            return;
        }

        double total = 0;

        System.out.println("\n------ BILL ------");
        for (int i = 0; i < cart.getCount(); i++) {
            Product pObj = items[i].getProductObj();
            int qty = items[i].getQuantity();

            double subTotal = pObj.getPrice() * qty;
            total += subTotal;
            System.out.println(pObj.getProduct() + " | " + pObj.getPrice() + " x " + qty + " = " + subTotal);
        }
        System.out.println("------------------");
        System.out.println("TOTAL = " + total);
    }
}
