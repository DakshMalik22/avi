package atm;

import java.util.*;

// Main class to simulate ATM operations
public class Main {

    public static void main(String[] args) {

        // Creating arrays to hold accounts for different banks
        Account[] hdfcAccounts = new Account[10];
        Account[] sbiAccounts = new Account[10];
        Account[] iciciAccounts = new Account[10];
        
        // Random object to generate random balance
        Random random = new Random();

        Scanner sc = new Scanner(System.in);

        // ATM object to perform various operations in the ATM
        ATM atm = new ATM();
        Account account = null;
        Bank userBank = null;

        // Making objects of accounts of different types
        for (int i = 0; i < 20; ++i) {
            String name = String.format("Customer" + (i + 1));
            String pin = String.format("%04d", i + 1);
            String accountNumber = String.format("%010d", i + 200000);
            String ifsc = (i / 7 + 1) + "000000000" + (i % 7 + 1);
            double balance = 500000 * random.nextDouble();

            String cardNumber = generateUniqueNumber();
            hdfcAccounts[i] = new Account(accountNumber, pin, cardNumber, name, balance, "HDFC" + ifsc);
            HDFC.addAccount(hdfcAccounts[i]);

            cardNumber = generateUniqueNumber();
            sbiAccounts[i] = new Account(accountNumber, pin, cardNumber, name, balance, "SBI" + ifsc);
            SBI.addAccount(sbiAccounts[i]);

            cardNumber = generateUniqueNumber();
            iciciAccounts[i] = new Account(accountNumber, pin, cardNumber, name, balance, "ICICI" + ifsc);
            ICICI.addAccount(iciciAccounts[i]);
        }

        // User interaction loop
        char choice;
        do {
            // Display ATM menu
            System.out.println("*****************ATM***************** ");
            System.out.println("Press 1: Login with card number and PIN");
            System.out.println("Press 2: Perform a transaction");
            System.out.println("Press 3: Withdraw");
            System.out.println("Press 4: Logout or end session");
            choice = sc.next().charAt(0);
            switch (choice) {
                case '1':
                    try {
                        // User login process
                        boolean loop = true;
                        do {
                            System.out.println("Select your bank:");
                            System.out.println("1. HDFC\n2. SBI\n3. ICICI\n4. Exit");
                            char choice1 = sc.next().charAt(0);
                            switch (choice1) {
                                case '1':
                                    userBank = new HDFC();
                                    account = atm.login(userBank, sc);
                                    loop = false;
                                    break;
                                case '2':
                                    userBank = new SBI();
                                    account = atm.login(userBank, sc);
                                    loop = false;
                                    break;
                                case '3':
                                    userBank = new ICICI();
                                    account = atm.login(userBank, sc);
                                    loop = false;
                                    break;
                                case '4':
                                    System.exit(0);
                                default:
                                    System.out.println("Enter a valid choice");
                            }
                        } while (loop);
                    } catch (InvalidPinException | AccountNotFoundException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case '2':
                    // Performing transaction
                    if (account == null) {
                        System.out.println("Login first...");
                        break;
                    }
                    try {
                        Bank recipientBank;
                        boolean loop = true;
                        do {
                            System.out.println("Select recipient bank:");
                            System.out.println("1. HDFC\n2. SBI\n3. ICICI\n4. Exit");
                            char choice1 = sc.next().charAt(0);
                            if (userBank == null) {
                                System.out.println("Please login first");
                                break;
                            }

                            switch (choice1) {
                                case '1':
                                    recipientBank = new HDFC();
                                    atm.transaction(recipientBank, account, userBank, sc);
                                    loop = false;
                                    break;
                                case '2':
                                    recipientBank = new SBI();
                                    atm.transaction(recipientBank, account, userBank, sc);
                                    break;
                                case '3':
                                    recipientBank = new ICICI();
                                    atm.transaction(recipientBank, account, userBank, sc);
                                    loop = false;
                                    break;
                                case '4':
                                    System.exit(0);
                                default:
                                    System.out.println("Enter a valid choice");
                            }
                        } while (loop);
                    } catch (AccountNotFoundException | InsufficientFundsException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case '3':
                    try {
                        // Withdrawing money
                        if (account == null) {
                            throw new AccountNotFoundException("Please log in first...");
                        }
                        account.withdraw(sc);
                    } catch (InsufficientFundsException | AccountNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case '4':
                    // Logging out
                    account = null;
                    System.out.println("Logged out successfully");
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }

        } while (choice != '0');
    }

    // Generates a unique card number string
    public static String generateUniqueNumber() {
        StringBuilder sb = new StringBuilder();

        // Generate the first 3 groups of numbers
        for (int i = 0; i < 3; i++) {
            sb.append(generateRandomGroup());
            sb.append("-");
        }

        // Generate the last group of numbers
        sb.append(String.format("%04d", new Random().nextInt(10000)));

        return sb.toString();
    }

    // Generates a random group of numbers
    public static String generateRandomGroup() {
        Random random = new Random();
        StringBuilder group = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            group.append(random.nextInt(10));
        }

        return group.toString();
    }
}
