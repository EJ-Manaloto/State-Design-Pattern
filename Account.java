public class Account {

    private String accountNumber;
    private double balance;
    private AccountState state;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.state = new ActiveState(); // Initial state
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public void changeState(AccountState newState) {
        this.state = newState;
    }

    public void deposit(double amount) {
        state.deposit(this, amount); // Delegate to current state
    }

    public void withdraw(double amount) {
        state.withdraw(this, amount); // Delegate to current state
    }

    public void suspend() {
        state.suspend(this); // Delegate to current state
    }

    public void activate() {
        state.activate(this); // Delegate to current state
    }

    public void close() {
        state.close(this); // Delegate to current state
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\nBalance: $" + balance;
    }
}
