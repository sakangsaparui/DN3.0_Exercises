import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "T-shirt", "Clothing"),
            new Product(4, "Headphones", "Accessories"),
            new Product(5, "Coffee Maker", "Appliances"),
            new Product(6, "Washing Machine", "Appliances"),
            new Product(7, "Refrigerator", "Appliances"),
            new Product(8, "Smartwatch", "Electronics"),
            new Product(9, "Jacket", "Clothing"),
            new Product(10, "Tablet", "Electronics")
        };

        Arrays.sort(products, (a, b) -> a.getProductName().compareToIgnoreCase(b.getProductName()));
        
        System.out.println("Enter the product name to search:");
        String targetName = scanner.nextLine();
        
        Product linearSearchResult = linearSearch(products, targetName);
        if (linearSearchResult != null) {
            System.out.println("Linear Search - Product found: " + linearSearchResult.getProductName() + " in " + linearSearchResult.getCategory());
        } else {
            System.out.println("Linear Search - Product not found.");
        }
        
        Product binarySearchResult = binarySearch(products, targetName);
        if (binarySearchResult != null) {
            System.out.println("Binary Search - Product found: " + binarySearchResult.getProductName() + " in " + binarySearchResult.getCategory());
        } else {
            System.out.println("Binary Search - Product not found.");
        }
        
        scanner.close();
    }

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = targetName.compareToIgnoreCase(products[mid].getProductName());
            if (result == 0) {
                return products[mid];
            } else if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
}
