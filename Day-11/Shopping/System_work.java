import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Discount interface
interface Discountable {
    double applyDiscount(); // Method to apply discount
}

// Product class
abstract class Product implements Discountable {
    // Private fields for product details
    private int productId;
    private String productName;
    private double price;

    // Constructor to initialize product details
    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    // Getter methods for accessing product details
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method to display product details
    public abstract void displayDetails();
}

// Electronics class inheriting Product
class Electronics extends Product {
    private int warrantyPeriod; // Additional property for electronics

    // Constructor to initialize electronics details
    public Electronics(int productId, String productName, double price, int warrantyPeriod) {
        super(productId, productName, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    // Method to display electronics details
    @Override
    public void displayDetails() {
        System.out.println("Product Details: " + getProductId() + ", " + getProductName() + ", Price: $" + getPrice() + ", Warranty: " + warrantyPeriod + " years");
    }

    // Method to apply discount specifically for electronics
    @Override
    public double applyDiscount() {
        // Apply 10% discount on electronics
        return getPrice() * 0.9;
    }
}

// Clothing class inheriting Product
class Clothing extends Product {
    private String size; // Additional property for clothing
    private String color; // Additional property for clothing

    // Constructor to initialize clothing details
    public Clothing(int productId, String productName, double price, String size, String color) {
        super(productId, productName, price);
        this.size = size;
        this.color = color;
    }

    // Method to display clothing details
    @Override
    public void displayDetails() {
        System.out.println("Product Details: " + getProductId() + ", " + getProductName() + ", Price: $" + getPrice() + ", Size: " + size + ", Color: " + color);
    }

    // Method to apply discount for clothing (no discount)
    @Override
    public double applyDiscount() {
        // No discount on clothing
        return getPrice();
    }
}

// Order class
class Order {
    private List<Product> products; // List of products in the order
    private double totalAmount; // Total amount of the order

    // Constructor to initialize order with products
    public Order(List<Product> products) {
        this.products = products;
        calculateTotalAmount(); // Calculate total amount of the order
    }

    // Method to calculate total amount of the order
    private void calculateTotalAmount() {
        totalAmount = 0;
        for (Product product : products) {
            totalAmount += product.applyDiscount(); // Apply discount for each product and sum up the prices
        }
    }

    // Getter method for total amount of the order
    public double getTotalAmount() {
        return totalAmount;
    }
}

public class System_work {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Product> products = new HashMap<>(); // Map to store products
        List<Order> orders = new ArrayList<>(); // List to store orders

        while (true) {
            // Display menu options
            System.out.println("Choose operation:");
            System.out.println("1. Add Product");
            System.out.println("2. Browse Products");
            System.out.println("3. Place Order");
            System.out.println("4. Exit");
            int choice = scanner.nextInt(); // Get user choice

            switch (choice) {
                case 1:
                    // Add Product
                    System.out.println("Enter product details:");
                    System.out.println("Product ID:");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Product Name:");
                    String productName = scanner.nextLine();
                    System.out.println("Price:");
                    double price = scanner.nextDouble();
                    System.out.println("Enter category (1 for Electronics, 2 for Clothing):");
                    int category = scanner.nextInt();

                    if (category == 1) {
                        System.out.println("Warranty Period In years:");
                        int warrantyPeriod = scanner.nextInt();
                        products.put(productId, new Electronics(productId, productName, price, warrantyPeriod));
                    } else if (category == 2) {
                        System.out.println("Size:");
                        String size = scanner.next();
                        System.out.println("Color:");
                        String color = scanner.next();
                        products.put(productId, new Clothing(productId, productName, price, size, color));
                    } else {
                        System.out.println("Invalid category.");
                    }
                    System.out.println("Product added successfully");
                    break;
                case 2:
                    // Browse Products
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        System.out.println("Products available:");
                        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
                            System.out.print("Product Id : " + entry.getKey() + ", ");
                            entry.getValue().displayDetails(); // Display details of each product
                        }
                    }
                    break;
                case 3:
                    // Place Order
                    System.out.println("Enter product IDs (separated by spaces) to place order:");
                    scanner.nextLine(); // Consume newline character
                    String[] productIds = scanner.nextLine().split(" ");
                    List<Product> orderedProducts = new ArrayList<>();
                    for (String id : productIds) {
                        int pid = Integer.parseInt(id);
                        if (products.containsKey(pid)) {
                            orderedProducts.add(products.get(pid));
                        } else {
                            System.out.println("Product with ID " + pid + " not found.");
                        }
                    }
                    if (!orderedProducts.isEmpty()) {
                        Order order = new Order(orderedProducts);
                        orders.add(order);
                        System.out.println("Order placed successfully. Total amount: $" + order.getTotalAmount());
                    }
                    break;
                case 4:
                    System.out.println("Exiting Program");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
