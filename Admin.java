public class Admin extends Person {
    public Admin(String name, int id) {
        super(name, id);
    }

    public void displayAllAccounts(Bank bank) {
        System.out.println("All Bank Accounts:");
        for (BankAccount account : bank.getAccounts()) {
            System.out.println("Account Number: " + account.accountNumber +
                               ", Account Holder: " + account.accountHolder.name +
                               ", Balance: " + account.balance);
        }
    }

    public void deleteAccount(Bank bank, int accountNumber) {
        BankAccount account = bank.findAccountByNumber(accountNumber);
        if (account != null) {
            bank.getAccounts().remove(account);
            System.out.println("Account " + accountNumber + " deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }
}
