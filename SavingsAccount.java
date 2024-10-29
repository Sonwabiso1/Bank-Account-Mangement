public class SavingsAccount extends BankAccount {

    public SavingsAccount(int accountNumber, Person accountHolder) {
        super(accountNumber, accountHolder);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into Savings Account.");
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient funds in Savings Account.");
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " from Savings Account.");
    }
}