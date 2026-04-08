public class BankAccount {
    private int accountNumber;
    private String username;
    private int balance;

    public BankAccount(int accountNumber, String username, int balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String getUsername() { return username; }
    public int getBalance() { return balance; }
    public int getAccountNumber() { return accountNumber; }
    public void setBalance(int b) { this.balance = b; }
}