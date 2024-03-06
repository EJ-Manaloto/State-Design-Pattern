public class ActiveState implements AccountState {

    @Override
    public void deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount); // Access balance through getter and setter
        System.out.println("Deposited: $" + amount + ". New balance: $" + account.getBalance());
    }

    @Override
    public void withdraw(Account account, double amount) {
        if (account.getBalance() >= amount) {  // Access balance through getter
            account.setBalance(account.getBalance() - amount); // Access balance through getter and setter
            System.out.println("Withdrew: $" + amount + ". New balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void suspend(Account account) {
        account.changeState(new SuspendedState());
        System.out.println("Account suspended!");
    }

    @Override
    public void activate(Account account) {
        System.out.println("Account is already activated!");
    }

    @Override
    public void close(Account account) {
        account.changeState(new ClosedState());
        System.out.println("Account closed!");
    }
}
