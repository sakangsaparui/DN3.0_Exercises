import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            System.out.println("\nInventory Management System:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Product");
            System.out.println("5. List All Products");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Product product = new Product(id, name, quantity, price);
                    inventory.addProduct(product);
                    break;

                case "2":
                    System.out.print("Enter Product ID to Update: ");
                    id = scanner.nextLine();
                    System.out.print("Enter New Product Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    quantity = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter New Price: ");
                    price = Double.parseDouble(scanner.nextLine());

                    Product updatedProduct = new Product(id, name, quantity, price);
                    inventory.updateProduct(id, updatedProduct);
                    break;

                case "3":
                    System.out.print("Enter Product ID to Delete: ");
                    id = scanner.nextLine();
                    inventory.deleteProduct(id);
                    break;

                case "4":
                    System.out.print("Enter Product ID to View: ");
                    id = scanner.nextLine();
                    Product foundProduct = inventory.getProduct(id);
                    if (foundProduct != null) {
                        System.out.println("Product Details: " + foundProduct);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case "5":
                    inventory.listAllProducts();
                    break;

                case "6":
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (!option.equals("6"));

        scanner.close();
    }
}
