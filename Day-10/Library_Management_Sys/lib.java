import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class Item
abstract class Item {
    private String id;
    private String title;
    private String author;
    private boolean checkedOut;
    private int quantity; // Add quantity field

    // Constructor
    public Item(String id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity; // Set quantity
        this.checkedOut = false;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    // Method to check out the item
    public void checkOut() {
        if (quantity > 0) {
            quantity--;
            checkedOut = true;
            System.out.println(title + " has been checked out.");
        } else {
            // If the quantity is 0 or less, printing a message indicating the item is out of stock
            System.out.println("Sorry, " + title + " is out of stock.");
        }
    }

    // Method to return the item
    public void returnItem() {
        if (checkedOut) {
            // If the item is checked out, increase the quantity by 1
            quantity++;

            checkedOut = false;
            System.out.println(title + " has been returned.");
        } else {
            // If the item is not checked out, print a message indicating it's already in the library
            System.out.println(title + " is already in the library.");
        }
    }

    // Abstract method to display item details
    public abstract void displayDetails();
}

// Book class inheriting from Item
class Book extends Item {
    private String ISBN;

    // Constructor
    public Book(String id, String title, String author, String ISBN, int quantity) {
        super(id, title, author, quantity);
        this.ISBN = ISBN;
    }

    // Override displayDetails method
    @Override
    public void displayDetails() {
        System.out.println("Book Details: ID: " + getId() + ", Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + ISBN + ", Quantity: " + getQuantity());
    }

}

// Magazine class inheriting from Item
class Magazine extends Item {
    private String issueNumber;

    // Constructor
    public Magazine(String id, String title, String author, String issueNumber, int quantity) {
        super(id, title, author, quantity);
        this.issueNumber = issueNumber;
    }

    // Override displayDetails method
    @Override
    public void displayDetails() {
        System.out.println("Magazine Details: ID: " + getId() + ", Title: " + getTitle() + ", Author: " + getAuthor() + ", Issue Number: " + issueNumber + ", Quantity: " + getQuantity());
    }

}

// LibraryMember class
class LibraryMember {
    private String memberId;
    private String name;

    // Constructor
    public LibraryMember(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Getters
    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    // Method to check out an item
    public void checkOutItem(Item item) {
        System.out.println(name + " checked out the item: " + item.getTitle());
    }

    // Method to return an item
    public void returnItem(Item item) {
        System.out.println(name + " returned the item: " + item.getTitle());
    }
}

// Library class
class Library {
    private List<Item> inventory;
    private List<LibraryMember> members;

    // Constructor
    public Library() {
        inventory = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Method to add items to inventory
    public void addItem(Item item) {
        inventory.add(item);
    }

    // Method to register members
    public void registerMember(LibraryMember member) {
        members.add(member);
    }

    // Method to display item details
    public void displayItemDetails() {
        for (Item item : inventory) {
            item.displayDetails();
        }
    }

    // Method to get the inventory
    public List<Item> getInventory() {
        return inventory;
    }

    public List<LibraryMember> getMembers() {
        return members;
    }
}

public class lib {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n1. Add book to library");
            System.out.println("2. Add magazine to library");
            System.out.println("3. Register a member");
            System.out.println("4. Display member details");
            System.out.println("5. Check out an item");
            System.out.println("6. Return an item");
            System.out.println("7. Display item details");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            try {
                switch (option) {
                    case 1:
                        System.out.println("Enter details of the book:");
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("ISBN: ");
                        String ISBN = scanner.nextLine();
                        System.out.print("Quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        Book book = new Book(id, title, author, ISBN, quantity);
                        library.addItem(book);
                        break;
                    case 2:
                        System.out.println("Enter details of the magazine:");
                        System.out.print("ID: ");
                        String magazineId = scanner.nextLine();
                        System.out.print("Title: ");
                        String magazineTitle = scanner.nextLine();
                        System.out.print("Author: ");
                        String magazineAuthor = scanner.nextLine();
                        System.out.print("Issue Number: ");
                        String issueNumber = scanner.nextLine();
                        System.out.print("Quantity: ");
                        int magazineQuantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        Magazine magazine = new Magazine(magazineId, magazineTitle, magazineAuthor, issueNumber, magazineQuantity);
                        library.addItem(magazine);
                        break;
                    case 3:
                        System.out.println("Enter details of the library member:");
                        System.out.print("Member ID: ");
                        String memberId = scanner.nextLine();
                        System.out.print("Member Name: ");
                        String name = scanner.nextLine();
                        LibraryMember member = new LibraryMember(memberId, name);
                        library.registerMember(member);
                        break;
                    case 4:
                        System.out.println("Details of the library member:");
                        for (LibraryMember i1 : library.getMembers()) {
                            String s = i1.getName();
                            String s1 = i1.getMemberId();
                            System.out.println("Name -> " + s);
                            System.out.println("Id of member -> " + s1);
                        }
                        break;
                    case 5:
                        System.out.println("Enter the ID of the item to be checked out:");
                        String checkoutId = scanner.nextLine();
                        for (Item item : library.getInventory()) {
                            if (item.getId().equals(checkoutId)) {
                                item.checkOut();
                                break;
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Enter the ID of the item to be returned:");
                        String returnId = scanner.nextLine();
                        for (Item item : library.getInventory()) {
                            if (item.getId().equals(returnId)) {
                                item.returnItem();
                                break;
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Item Details:  ");
                        library.displayItemDetails();
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Consume the newline character
            }
        }
    }
}
