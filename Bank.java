import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccountByNumber(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void transferFunds(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = findAccountByNumber(fromAccountNumber);
        BankAccount toAccount = findAccountByNumber(toAccountNumber);

        if (fromAccount == null) {
            System.out.println("Source account not found.");
            return;
        }
        if (toAccount == null) {
            System.out.println("Destination account not found.");
            return;
        }

        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " from Account " + fromAccountNumber +
                               " to Account " + toAccountNumber);
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
    }

    public void run(Person person) {
        Scanner scanner = new Scanner(System.in);
        boolean isAdmin = person instanceof Admin;
        try {
            while (true) {
                System.out.println("\n1. Add Account\n2. Deposit\n3. Withdraw\n4. Display Account Info\n5. Transfer Funds");
                if (isAdmin) {
                    System.out.println("6. Display All Accounts\n7. Delete Account\n8. Exit");
                } else {
                    System.out.println("6. Exit");
                }
                
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        Person accountHolder = new Person(name, id);

                        System.out.print("Enter account type (1 for Savings, 2 for Checking): ");
                        int accountType = scanner.nextInt();
                        System.out.print("Enter account number: ");
                        int accountNumber = scanner.nextInt();

                        if (accountType == 1) {
                            addAccount(new SavingsAccount(accountNumber, accountHolder));
                        } else if (accountType == 2) {
                            addAccount(new CheckingAccount(accountNumber, accountHolder));
                        } else {
                            System.out.println("Invalid account type.");
                        }
                        break;

                    case 2:
                        System.out.print("Enter account number: ");
                        int depositAccount = scanner.nextInt();
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        depositToAccount(depositAccount, depositAmount);
                        break;

                    case 3:
                        System.out.print("Enter account number: ");
                        int withdrawAccount = scanner.nextInt();
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawFromAccount(withdrawAccount, withdrawAmount);
                        break;

                    case 4:
                        System.out.print("Enter account number: ");
                        int infoAccount = scanner.nextInt();
                        displayAccountInfo(infoAccount);
                        break;

                    case 5:
                        System.out.print("Enter source account number: ");
                        int fromAccountNumber = scanner.nextInt();
                        System.out.print("Enter destination account number: ");
                        int toAccountNumber = scanner.nextInt();
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        transferFunds(fromAccountNumber, toAccountNumber, transferAmount);
                        break;

                    case 6:
                        if (isAdmin) {
                            ((Admin) person).displayAllAccounts(this);
                        } else {
                            System.out.println("Exiting...");
                            return;
                        }
                        break;

                    case 7:
                        if (isAdmin) {
                            System.out.print("Enter account number to delete: ");
                            int deleteAccountNumber = scanner.nextInt();
                            ((Admin) person).deleteAccount(this, deleteAccountNumber);
                        }
                        break;

                    case 8:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct data.");
        } finally {
            scanner.close();
        }
    }

    public void depositToAccount(int accountNumber, double amount) {
        BankAccount account = findAccountByNumber(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount) {
        BankAccount account = findAccountByNumber(accountNumber);
        try {
            if (account != null) {
                account.withdraw(amount);
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAccountInfo(int accountNumber) {
        BankAccount account = findAccountByNumber(accountNumber);
        if (account != null) {
            account.displayBalance();
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        
        // Creating an admin user and running the app
        Admin admin = new Admin("AdminUser", 0);
        bank.run(admin);
    }
}
