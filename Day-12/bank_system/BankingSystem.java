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
