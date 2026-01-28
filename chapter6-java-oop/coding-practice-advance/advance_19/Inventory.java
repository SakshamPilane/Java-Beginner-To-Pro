package advance_19;

public class Inventory {
    private final Product[] products = new Product[10];
    private int count = 0;

    public void addProduct(Product productObj)
    {
        int pos = searchProduct(productObj.getProductName());
        if (count >= products.length)
        {
            System.out.println("Maximum Limit Reached of Inventory cannot add more products!");
            return;
        }
        if (pos != -1)
        {
            System.out.println("Product exists in Inventory!");
            return;
        }
        products[count++] = productObj;
        System.out.println("Product added to inventory!");
    }

    public int searchProduct(String productName)
    {
        for (int i = 0; i < count; i++) {
            if (products[i].getProductName().equalsIgnoreCase(productName))
            {
                return i;
            }
        }
        return -1;
    }

    public void removeProduct(String productName)
    {
        if (count == 0)
        {
            System.out.println("Inventory is Empty!");
            return;
        }
        int pos = searchProduct(productName);
        if (pos == -1)
        {
            System.out.println("Product not found in Inventory!");
            return;
        }
        for (int i = pos; i < count - 1; i++) {
            products[i] = products[i+1];
        }
        count--;
        System.out.println("Product removed from inventory!");
    }

    public void viewInventory()
    {
        if (count == 0)
        {
            System.out.println("Inventory is Empty!");
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Product Number = " + (i + 1));
            System.out.println("Product name = " + products[i].getProductName());
            System.out.println("Product Price = " + products[i].getPrice());
            System.out.println("X--------------------------------------------X");
        }
    }
}
