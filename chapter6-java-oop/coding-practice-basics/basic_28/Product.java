package basic_28;

public class Product {
    private String productName;
    private double price;

    public String getProduct() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProduct(String productName) {
        this.productName = productName;
    }
}
