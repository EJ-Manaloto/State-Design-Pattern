public class SuspendedState implements AccountState {

    @Override
    public void deposit(Account account, double amount) {
        System.out.println("Deposit not allowed for suspended account.");
    }

    @Override
    public void withdraw(Account account, double amount) {
        System.out.println("Withdrawal not allowed for suspended account.");
    }

    @Override
    public void suspend(Account account) {
        System.out.println("Account is already suspended!");
    }

    @Override
    public void activate(Account account) {
        account.setState(new ActiveState());
        System.out.println("Account activated!");
    }

    @Override
    public void close(Account account) {
        account.setState(new ClosedState());
        System.out.println("Account closed!");
    }
}
