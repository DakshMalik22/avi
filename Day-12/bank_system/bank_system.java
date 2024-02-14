// Import necessary packages
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define the BankAccount class
class BankAccount {
    // Declare private variables for account number and balance
    private final int accountNumber;
    private static int balance;

    // Constructor to initialize account number and balance
    public BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter method for account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Getter method for balance
    public int getBalance() {
        return balance;
    }

    // Method to deposit funds into the account
    public void deposit(int amount) throws BankException {
        // Check if the deposit amount is valid
        if (amount <= 0) {
            throw new NegativeAmountException("Deposit amount should be greater than Rs. 0");
        }
        // Update the balance
        balance += amount;
    }

    // Method to withdraw funds from the account
    public void withdraw(int amount) throws BankException {
        // Check if the withdrawal amount is negative
        if (amount < 0) {
            throw new NegativeAmountException("Withdraw amount cannot be negative");
        }
        // Check if there are sufficient funds for withdrawal
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        // Update the balance
        balance -= amount;
    }
}

// Define the Transaction class
class Transaction {
    // Declare private variables for transaction ID, type, and amount
    private int transactionId;
    private String transactionType;
    private int amount;

    // Constructor to initialize transaction details
    public Transaction(int transactionId, String transactionType, int amount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
    }
}

// Define the BankingSystem class
class BankingSystem {
    // Declare a list to store bank accounts
    private List<BankAccount> accounts;

    // Constructor to initialize the list of accounts
    public BankingSystem() {
        accounts = new ArrayList<>();
    }

    // Method to add a bank account to the system
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Method to find a bank account by its account number
    public BankAccount findAccount(int accountNumber) {
        // Iterate through the list of accounts
        for (BankAccount account : accounts) {
            // Check if the account number matches
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null; // Return null if account not found
    }

    // Method to transfer funds between accounts
    public void transfer(int fromAccountNumber, int toAccountNumber, int amount) throws BankException {
        // Find the source and destination accounts
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        // Check if the accounts are valid
        if (fromAccount == null || toAccount == null) {
            throw new BankException("Invalid account number");
        }

        // Check if the transfer amount is negative
        if (amount < 0) {
            throw new NegativeAmountException("Negative amount ");
        }

        // Check if there are sufficient funds in the source account
        if (amount > fromAccount.getBalance()) {
            throw new BankException("Not enough money in the source account");
        }

        // Perform the transfer
        if (fromAccountNumber == toAccountNumber) {
            toAccount.deposit(amount); // Deposit amount to the same account if transfer within the same account
        } else {
            // Otherwise, withdraw from the source and deposit into the destination account
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        }

        // Print transfer success message
        System.out.println("Transfer is Done");
    }
}

// Define the BankException class
class BankException extends Exception {
    // Constructor to initialize the exception with a message
    public BankException(String message) {
        super(message);
    }
}

// Define the NegativeAmountException class
class NegativeAmountException extends BankException {
    // Constructor to initialize the exception with a message
    public NegativeAmountException(String message) {
        super(message);
    }
}

// Define the InsufficientFundsException class
class InsufficientFundsException extends BankException {
    // Constructor to initialize the exception with a message
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Main class to demonstrate the functionality of the banking system
public class bank_system {
    public static void main(String[] args) {
        // Create an instance of BankingSystem
        BankingSystem bankingSystem = new BankingSystem();

        // Create some bank accounts and add them to the banking system
        BankAccount acc1 = new BankAccount(123, 10000);
        bankingSystem.addAccount(acc1);
        bankingSystem.addAccount(new BankAccount(123456, 1000));
        bankingSystem.addAccount(new BankAccount(789012, 500));

        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        try {
            // Perform a transfer
            bankingSystem.transfer(123456, 789012, 200);
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Attempt to deposit funds into acc1
            acc1.deposit(-1);
        } catch (BankException e) {
            System.out.println("Funds overflow");
        }

        try {
            // Attempt to withdraw funds from acc1
            acc1.withdraw(13000);
        } catch (BankException e) {
            System.out.println("Not enough funds available!!!");
        }

        // Prompt user for account number
        System.out.println("Enter your account number:");
        int accountNum = scanner.nextInt();

        // Check if the account exists
        BankAccount userAccount = bankingSystem.findAccount(accountNum);
        if (userAccount == null) {
            System.out.println("Account not found!");
            return; // Exit the program if the account doesn't exist
        }

        // Prompt user for withdrawal amount
        System.out.println("Enter the amount to withdraw:");
        int withdrawAmount = scanner.nextInt();

        try {
            // Attempt withdrawal
            userAccount.withdraw(withdrawAmount);
            System.out.println("Withdrawal successful. Updated balance: " + userAccount.getBalance());
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Prompt user for deposit amount
        System.out.println("Enter the amount to deposit:");
        int depositAmount = scanner.nextInt();
        try {
            // Attempt deposit
            userAccount.deposit(depositAmount);
            System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
