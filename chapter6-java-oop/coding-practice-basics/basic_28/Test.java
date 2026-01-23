package basic_28;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ProductCatalog productCatalog = new ProductCatalog();
        Cart cart = new Cart();
        BillGenerator billGenerator = new BillGenerator();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (!username.equals(productCatalog.getUserName()) ||
                !password.equals(productCatalog.getPwd())) {

            System.out.println("Invalid login!");
            return;
        }

        boolean flag = true;

        while (flag) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Product to Catalog");
            System.out.println("2. Remove Product from Catalog");
            System.out.println("3. View Product Catalog");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Generate Bill");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1: {
                    Product p = new Product();
                    System.out.print("Enter product name: ");
                    p.setProduct(input.nextLine());
                    System.out.print("Enter price: ");
                    p.setPrice(input.nextDouble());
                    productCatalog.addProduct(p);
                    break;
                }

                case 2: {
                    System.out.print("Enter product name to remove: ");
                    String name = input.nextLine();
                    System.out.println(
                            productCatalog.removeProduct(name)
                                    ? "Product removed."
                                    : "Product not found."
                    );
                    break;
                }

                case 3:
                    productCatalog.showProduct();
                    break;

                case 4: {
                    System.out.print("Enter product name to add to cart: ");
                    String name = input.nextLine();

                    int pos = productCatalog.searchProduct(name);
                    if (pos == -1) {
                        System.out.println("Product not found in catalog!");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int qty = input.nextInt();

                    Product product = productCatalog.productArray[pos];
                    cart.addToCart(product, qty);
                    break;
                }

                case 5:
                    cart.viewCart();
                    break;

                case 6:
                    billGenerator.generateBill(cart);
                    break;

                case 7:
                    flag = false;
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        input.close();
    }
}
