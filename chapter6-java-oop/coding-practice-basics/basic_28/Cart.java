package basic_28;

public class Cart {
    CartItem[] cartItemArray = new CartItem[10];
    int count = 0;

    public CartItem[] getCartItemArray() {
        return cartItemArray;
    }

    public int getCount() {
        return count;
    }

    public void addToCart(Product productObj, int quantity)
    {
        int pos = searchCart(productObj);
        if (pos == -1)
        {
            CartItem cartItemObj = new CartItem();
            cartItemObj.setProductObj(productObj);
            cartItemObj.setQuantity(quantity);
            cartItemArray[count++] = cartItemObj;
            System.out.println("Product Added Successfully to Cart");
            return;
        }
        cartItemArray[pos].setQuantity(cartItemArray[pos].getQuantity()+quantity);
        System.out.println("Product Quantity Increased!");
    }
    
    public int searchCart(Product productObj)
    {
        for (int i = 0; i < count; i++) {
            if (cartItemArray[i].getProductObj() == productObj)
            {
                return i;
            }
        }
        return -1;
    }

    public void viewCart()
    {
        if (count == 0) {
            System.out.println("Cart is empty.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Product Name = " + cartItemArray[i].getProductObj().getProduct());
            System.out.println("Product Price = " + cartItemArray[i].getProductObj().getPrice());
            System.out.println("Product Quantity = " + cartItemArray[i].getQuantity());
        }
    }
}