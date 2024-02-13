import java.util.*;

// Define a Vehicle class
abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    protected double rentalPrice;

    // Constructor
    public Vehicle(String make, String model, int year, double rentalPrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    // Abstract method to calculate rental cost
    public abstract double calculateRentalCost(int days);

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

// Car class extending Vehicle
class Car extends Vehicle {
    private int numSeats;
    private String fuelType;

    // Car constructor
    public Car(String make, String model, int year, double rentalPrice, int numSeats, String fuelType) {
        super(make, model, year, rentalPrice);
        this.numSeats = numSeats;
        this.fuelType = fuelType;
    }

    // Override method to calculate rental cost
    @Override
    public double calculateRentalCost(int days) {
        return rentalPrice * days;
    }
}

// Customer class
class Customer {
    private String name;
    private String email;
    private Map<Integer, Vehicle> rentedVehicles;

    // Constructor
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.rentedVehicles = new HashMap<>();
    }

   
    public String getName() {
        return name;
    }

    public Map<Integer, Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    // Method to rent a vehicle
    public void rentVehicle(Vehicle vehicle, int vehicleId) {
        rentedVehicles.put(vehicleId, vehicle);
    }

    // Method to return a vehicle
    public void returnVehicle(int vehicleId) {
        rentedVehicles.remove(vehicleId);
    }
}

class RentalAgency {

    private List<Vehicle> availableVehicles;
  
    private Map<Customer, Map<Integer, Vehicle>> rentedVehiclesMap;


    public RentalAgency() {
        // Initialize the availableVehicles list and rentedVehiclesMap
        this.availableVehicles = new ArrayList<>();
        this.rentedVehiclesMap = new HashMap<>();
    }

    // Method to add a vehicle
    public void addVehicle(Vehicle vehicle) {
        // Add the vehicle to the available vehicles list
        availableVehicles.add(vehicle);
    }

    // Method to rent a vehicle
    public void rentVehicle(Customer customer, Vehicle vehicle, int days, int vehicleId) {
        // Checking if the requested vehicle is available for rent
        if (!availableVehicles.contains(vehicle)) {
            // Throw an exception if the vehicle is not available
            throw new IllegalArgumentException("The requested vehicle is not available for rent.");
        }
        // Calculating the rental cost for the vehicle
        double cost = vehicle.calculateRentalCost(days);
        // Printing the rental cost information
        System.out.println("Rental cost for " + vehicle.getMake() + " " + vehicle.getModel() + " for " + days + " days: Rs." + cost);
        // Rent the vehicle to the customer
        customer.rentVehicle(vehicle, vehicleId);
        // Remove the rented vehicle from the available vehicles list
        availableVehicles.remove(vehicle);

        // Store the rented vehicle information in the rentedVehiclesMap
        rentedVehiclesMap.putIfAbsent(customer, new HashMap<>());
        rentedVehiclesMap.get(customer).put(vehicleId, vehicle);
    }

    // Method to return a vehicle
    public void returnVehicle(Customer customer, int vehicleId) {
        // Get the rented vehicles map for the customer
        Map<Integer, Vehicle> customerRentedVehicles = rentedVehiclesMap.get(customer);
        // Check if the customer has rented any vehicles
        if (customerRentedVehicles == null || !customerRentedVehicles.containsKey(vehicleId)) {
            // Throw an exception if the vehicle with the given ID was not rented by the customer
            throw new IllegalArgumentException("The vehicle with ID " + vehicleId + " was not rented by this customer.");
        }
        // Return the vehicle
        customer.returnVehicle(vehicleId);
        // Adding the returned vehicle back to the available vehicles list
        availableVehicles.add(customerRentedVehicles.remove(vehicleId));
      
        System.out.println("The vehicle with ID " + vehicleId + " has been returned successfully.");

        // Remove the customer from rentedVehiclesMap if they have no more rented vehicles
        if (customerRentedVehicles.isEmpty()) {
            rentedVehiclesMap.remove(customer);
        }
    }

    // Method to get rented vehicles by customer
    public Map<Integer, Vehicle> getRentedVehiclesByCustomer(Customer customer) {
        return rentedVehiclesMap.getOrDefault(customer, new HashMap<>());
    }

    // Method to get available vehicles
    public List<Vehicle> getAvailableVehicles() {
        return availableVehicles;
    }
}

// Main class
public class system {
    public static void main(String[] args) {
        RentalAgency rentalAgency = new RentalAgency();
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;

        while (true) {
            System.out.println("Car Rental System Menu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Add a customer");
            System.out.println("3. Rent a vehicle");
            System.out.println("4. Return a vehicle");
            System.out.println("5. View available vehicles");
            System.out.println("6. Display rented vehicles of the current customer");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter rental price per day: ");
                    double rentalPrice = scanner.nextDouble();
                    System.out.print("Enter number of seats: ");
                    int numSeats = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter fuel type: ");
                    String fuelType = scanner.nextLine();

                    rentalAgency.addVehicle(new Car(make, model, year, rentalPrice, numSeats, fuelType));
                    System.out.println("The vehicle has been added successfully.");
                    break;

                case 2:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String customerEmail = scanner.nextLine();

                    customer = new Customer(customerName, customerEmail);
                    customers.add(customer);
                    System.out.println("The customer has been added successfully.");
                    break;

                case 3:
                    System.out.print("Enter customer name: ");
                    String customerNameRent = scanner.nextLine();
                    Customer rentingCustomer = null;

                    for (Customer existingCustomer : customers) {
                        if (existingCustomer.getName().equalsIgnoreCase(customerNameRent)) {
                            rentingCustomer = existingCustomer;
                            break;
                        }
                    }

                    if (rentingCustomer == null) {
                        System.out.println("Customer not found. Please add the customer first.");
                        break;
                    }

                    List<Vehicle> availableVehicles = rentalAgency.getAvailableVehicles();
                    if (availableVehicles.isEmpty()) {
                        System.out.println("No vehicles available for rent.");
                        break;
                    }

                    System.out.println("Available vehicles:");
                    for (int i = 0; i < availableVehicles.size(); i++) {
                        Vehicle vehicle = availableVehicles.get(i);
                        System.out.println(i + ". " + vehicle.getMake() + " " + vehicle.getModel());
                    }
                    System.out.print("Enter the index of the vehicle to rent: ");
                    int vehicleIndex = scanner.nextInt();
                    System.out.print("Enter the rental duration (in days): ");
                    int rentalDays = scanner.nextInt();
                    System.out.print("Enter vehicle ID: ");
                    int vehicleId = scanner.nextInt();

                    rentalAgency.rentVehicle(rentingCustomer, availableVehicles.get(vehicleIndex), rentalDays, vehicleId);
                    break;

                case 4:
                    if (customer == null) {
                        System.out.println("Please add a customer first.");
                        break;
                    }
                    Map<Integer, Vehicle> rentedVehicles = rentalAgency.getRentedVehiclesByCustomer(customer);
                    if (rentedVehicles.isEmpty()) {
                        System.out.println("No vehicles rented by this customer.");
                        break;
                    }
                    System.out.println("Rented vehicles:");
                    for (Map.Entry<Integer, Vehicle> entry : rentedVehicles.entrySet()) {
                        System.out.println(entry.getKey() + ". " + entry.getValue().getMake() + " " + entry.getValue().getModel());
                    }
                    System.out.print("Enter the vehicle ID to return: ");
                    int returnVehicleId = scanner.nextInt();
                    rentalAgency.returnVehicle(customer, returnVehicleId);
                    break;

                case 5:
                    List<Vehicle> vehicles = rentalAgency.getAvailableVehicles();
                    if(vehicles.size()==0){
                        System.out.println("No vehicles are available at the moment.");
                        break;
                    }
                    System.out.println("Available vehicles:");
                    for (int i = 0; i < vehicles.size(); i++) {
                        Vehicle vehicle = vehicles.get(i);
                        System.out.println(i + ". " + vehicle.getMake() + " " + vehicle.getModel());
                    }
                    break;

                case 6:
                    if (customer == null) {
                        System.out.println("Please add a customer first.");
                        break;
                    }
                    Map<Integer, Vehicle> rentedVehiclesByCustomer = rentalAgency.getRentedVehiclesByCustomer(customer);
                    if (rentedVehiclesByCustomer.isEmpty()) {
                        System.out.println("This customer hasn't rented any vehicles yet.");
                    } else {
                        System.out.println("Rented vehicles by " + customer.getName() + ":");
                        for (Map.Entry<Integer, Vehicle> entry : rentedVehiclesByCustomer.entrySet()) {
                            System.out.println(entry.getKey() + ". " + entry.getValue().getMake() + " " + entry.getValue().getModel());
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting the Car Rental System...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
