package atm;

import java.util.Scanner;

public class ATM {
    // Method to perform a transaction (transfer money)
    public void transaction(Bank recipientBank, Account userAccount, Bank userBank, Scanner sc) throws AccountNotFoundException, InsufficientFundsException {
        // Prompting user to enter recipient account number
        System.out.println("Enter account number you want to transfer money to:");
        String recipientAccountNumber = sc.next();

        // Prompting user to enter amount to transfer
        System.out.println("Enter amount you want to transfer:");
        double amount = sc.nextDouble();
        
        // Depositing money into recipient account
        recipientBank.deposit(recipientAccountNumber, amount);
        
        // Deducting money from user's account
        userBank.deduct(userAccount, amount);
    }

    // Method to login to ATM using card number and PIN
    public Account login(Bank bank, Scanner sc) throws InvalidPinException, AccountNotFoundException {
        // Prompting user to enter card number
        System.out.println("Enter your card number:");
        String cardNumber = sc.next();
        Account loginAccount = null;

        // Looping through accounts in the bank to find the account associated with the card number
        for (Account account : bank.getAccounts()) {
            if (account != null && account.getCardNumber() != null && account.getCardNumber().equals(cardNumber)) {
                loginAccount = account;
                break;
            }
        }

        // If account is not found, throw AccountNotFoundException
        if (loginAccount == null)
            throw new AccountNotFoundException("Account not found");
        
        // Check if account is blocked
        if (loginAccount.getBlocked()) {
            throw new AccountNotFoundException("Account already blocked");
        }
        
        // Attempting to log in with PIN
        int count = 3;
        while (count > 0) {
            System.out.println("Enter your PIN:");
            System.out.println(count + " attempts left");
            --count;
            String pin = sc.next();
            // If PIN matches, log in and break the loop
            if (pin.equals(loginAccount.getPin())) {
                System.out.println("Logged in as " + loginAccount.getName());
                break;
            }
        }
        
        // If all attempts failed, block the account and throw InvalidPinException
        if (count == 0) {
            loginAccount.setBlocked();
            throw new InvalidPinException(" **********Pin incorrect 3 times.**********\n**********Your card has been blocked.**********");
        }

        return loginAccount;
    }
}
