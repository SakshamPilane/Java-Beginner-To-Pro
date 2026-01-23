package basic_28;

public class ProductCatalog {

    public String getUserName()
    {
        return "User1234";
    }

    public String getPwd() { return "User1234"; }

    Product[] productArray = new Product[10];
    int count = 0;

    //addProduct()
    public void addProduct(Product productObj) {
        int pos = searchProduct(productObj.getProduct());
        if (pos != -1) {
            System.out.println("Product exists! Cannot add duplicate this product.");
            return;
        }
        productArray[count++] = productObj;
        System.out.println("Product Added Successfully!");
    }

    //removeProdcut()
    public boolean removeProduct(String product) {
        int pos = searchProduct(product);
        if (pos == -1)
        {
            return false;
        }
        for (int i = pos; i < count - 1; i++) {
            productArray[i] = productArray[i+1];
        }
        productArray[--count] = null;
        return true;
    }

    public int searchProduct(String product)
    {
        for (int i = 0; i < count; i++) {
            if (productArray[i].getProduct().equalsIgnoreCase(product))
            {
                return i;
            }
        }
        return -1;
    }

    public void showProduct() {
        if (count == 0) {
            System.out.println("No products available.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Product number " + (i + 1));
            System.out.println("Product Name = " + productArray[i].getProduct());
            System.out.println("Product Price = " + productArray[i].getPrice());
            System.out.println();
        }
    }
}
