public abstract class BankAccount {
    protected int accountNumber;
    protected double balance;
    protected Person accountHolder;

    public BankAccount(int accountNumber, Person accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws Exception;

    public void displayBalance() {
        System.out.println(accountHolder.name + ", " + "Account Number: " + accountNumber + ", Balance: " + balance);
    }
}