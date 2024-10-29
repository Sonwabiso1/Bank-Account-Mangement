public class CheckingAccount extends BankAccount {

    public CheckingAccount(int accountNumber, Person accountHolder) {
        super(accountNumber, accountHolder);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into Checking Account.");
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient funds in Checking Account.");
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " from Checking Account.");
    }
}
