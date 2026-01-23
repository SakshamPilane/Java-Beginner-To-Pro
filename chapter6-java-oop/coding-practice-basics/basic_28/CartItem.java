package basic_28;

public class CartItem {
    private int quantity;
    private Product productObj;

    public int getQuantity() {
        return quantity;
    }

    public Product getProductObj() {
        return productObj;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductObj(Product productObj) {
        this.productObj = productObj;
    }
}
