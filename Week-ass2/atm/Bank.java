package atm;

import java.util.*;

// Abstract class representing a bank
public abstract class Bank {

    // Abstract method to get accounts
    public abstract List<Account> getAccounts();

    // Abstract method to deposit money to an account
    public abstract void deposit(String recipientAccountNumber, double amount) throws AccountNotFoundException;

    // Abstract method to deduct money from an account
    public abstract void deduct(Account userAccount, double amount) throws AccountNotFoundException, InsufficientFundsException;
}

// HDFC class extending Bank
class HDFC extends Bank {
    private static List<Account> hdfcAccounts = new ArrayList();

    // Method to add account to HDFC accounts list
    public static void addAccount(Account account) {
        hdfcAccounts.add(account);
    }

    // Method to get accounts list
    @Override
    public List<Account> getAccounts() {
        return hdfcAccounts;
    }

    // Method to deposit money to an account
    @Override
    public void deposit(String recipientAccountNumber, double amount) throws AccountNotFoundException {
        Account recipientAccount = null;
        for (Account account : getAccounts()) {
            if (account != null && account.getaccountNumber() != null && account.getaccountNumber().equals(recipientAccountNumber)) {
                recipientAccount = account;
                break;
            }
        }
        if (recipientAccount == null) {
            throw new AccountNotFoundException("Account of recipient does not exist");
        }
        recipientAccount.addBalance(amount);
    }

    // Method to deduct money from an account
    @Override
    public void deduct(Account userAccount, double amount) throws AccountNotFoundException, InsufficientFundsException {
        Account senderAccount = null;
        for (Account account : getAccounts()) {
            if (account != null && account == userAccount) {
                senderAccount = account;
                break;
            }
        }
        if (senderAccount == null) {
            throw new AccountNotFoundException("Account of sender does not exist");
        }
        senderAccount.deduct(amount, 0.01); // Assuming 1% charge for HDFC
    }
}

// SBI class extending Bank
class SBI extends Bank {
    private static List<Account> sbiAccounts = new ArrayList();

    // Method to add account to SBI accounts list
    public static void addAccount(Account account) {
        sbiAccounts.add(account);
    }

    // Method to get accounts list
    @Override
    public List<Account> getAccounts() {
        return sbiAccounts;
    }

    // Method to deposit money to an account
    @Override
    public void deposit(String recipientAccountNumber, double amount) throws AccountNotFoundException {
        Account recipientAccount = null;
        for (Account account : getAccounts()) {
            if (account != null && account.getaccountNumber() != null && account.getaccountNumber().equals(recipientAccountNumber)) {
                recipientAccount = account;
                break;
            }
        }
        if (recipientAccount == null) {
            throw new AccountNotFoundException("Account of recipient does not exist");
        }
        recipientAccount.addBalance(amount);
    }

    // Method to deduct money from an account
    @Override
    public void deduct(Account userAccount, double amount) throws AccountNotFoundException, InsufficientFundsException {
        Account senderAccount = null;
        for (Account account : getAccounts()) {
            if (account != null && account == userAccount) {
                senderAccount = account;
                break;
            }
        }
        if (senderAccount == null) {
            throw new AccountNotFoundException("Account of sender does not exist");
        }
        senderAccount.deduct(amount, 0.03); // Assuming 3% charge for SBI
    }
}

// ICICI class extending Bank
class ICICI extends Bank {
    private static List<Account> iciciAccounts = new ArrayList();

    // Method to add account to ICICI accounts list
    public static void addAccount(Account account) {
        iciciAccounts.add(account);
    }

    // Method to get accounts list
    @Override
    public List<Account> getAccounts() {
        return iciciAccounts;
    }

    // Method to deposit money to an account
    @Override
    public void deposit(String recipientAccountNumber, double amount) throws AccountNotFoundException {
        Account recipientAccount = null;
        for (Account account : getAccounts()) {
            if (account != null && account.getaccountNumber() != null && account.getaccountNumber().equals(recipientAccountNumber)) {
                recipientAccount = account;
                break;
            }
        }
        if (recipientAccount == null) {
            throw new AccountNotFoundException("Account of recipient does not exist");
        }
        recipientAccount.addBalance(amount);
    }

    // Method to deduct money from an account
    @Override
    public void deduct(Account userAccount, double amount) throws AccountNotFoundException, InsufficientFundsException {
        Account senderAccount = null;
        for (Account account : getAccounts()) {
            if (account != null && account == userAccount) {
                senderAccount = account;
                break;
            }
        }
        if (senderAccount == null) {
            throw new AccountNotFoundException("Account of sender does not exist");
        }
        senderAccount.deduct(amount, 0.02); // Assuming 2% charge for ICICI
    }
}
