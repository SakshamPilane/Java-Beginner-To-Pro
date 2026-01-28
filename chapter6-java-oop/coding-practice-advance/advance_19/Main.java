package advance_19;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Inventory inventoryObj = new Inventory();
        String productName;
        double price;
        while (true)
        {
            System.out.println("1. Add Product.");
            System.out.println("2. Remove Product.");
            System.out.println("3. Search Product.");
            System.out.println("4. View All Products.");
            System.out.println("5. Exit.");
            System.out.print("Enter Choice: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice)
            {
                case 1:
                    Product productObj = new Product();
                    System.out.print("Enter product name: ");
                    productName = input.nextLine();
                    System.out.print("Enter product price: ");
                    price = input.nextDouble();
                    productObj.setProductName(productName);
                    productObj.setPrice(price);
                    inventoryObj.addProduct(productObj);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    productName = input.nextLine();
                    inventoryObj.removeProduct(productName);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter product name: ");
                    productName = input.nextLine();
                    int pos = inventoryObj.searchProduct(productName);
                    if (pos == -1)
                    {
                        System.out.println("Product not found in inventory!");
                    }
                    else {
                        System.out.println("Product found at " + (pos + 1) + " position in inventory!");
                    }
                    System.out.println();
                    break;
                case 4:
                    inventoryObj.viewInventory();
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Exiting Menu..");
                    input.close();
                    return;
                default:
                    System.out.print("Wrong Choice Entered Try Again!");
                    System.out.println();
                    break;
            }
        }
    }
}
