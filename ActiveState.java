public class ActiveState implements AccountState {

    @Override
    public void deposit(Account account, double amount) {
        account.balance += amount;
        System.out.println("Deposited: $" + amount + ". New balance: $" + account.balance);
    }

    @Override
    public void withdraw(Account account, double amount) {
        if (account.balance >= amount) {
            account.balance -= amount;
            System.out.println("Withdrew: $" + amount + ". New balance: $" + account.balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void suspend(Account account) {
        account.setState(new SuspendedState());
        System.out.println("Account suspended!");
    }

    @Override
    public void activate(Account account) {
        System.out.println("Account is already activated!");
    }

    @Override
    public void close(Account account) {
        account.setState(new ClosedState());
        System.out.println("Account closed!");
    }
}
