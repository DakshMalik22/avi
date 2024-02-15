// Import necessary packages
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
