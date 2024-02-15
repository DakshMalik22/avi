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
