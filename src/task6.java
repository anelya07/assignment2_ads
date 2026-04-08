public class task6 {
    public static void main(String[] args) {
        BankAccount6[] arr = new BankAccount6[3];

        BankAccount6 acc0 = new BankAccount6(1, "Anelya", 55000);
        BankAccount6 acc1 = new BankAccount6(2, "Aliya", 75000);
        BankAccount6 acc2 = new BankAccount6(3, "Nurali", 15000);

        arr[0] = acc0;
        arr[1] = acc1;
        arr[2] = acc2;

        System.out.println("Array of BankAccount:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i+1) + ". " + arr[i].getUsername() + " – Balance: " + arr[i].getBalance());
        }
    }
}

class BankAccount6 {
    private int accountNumber;
    private String username;
    private int balance;
    public BankAccount6(int accountNumber, String username, int balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }
    public String getUsername() { return username; }
    public int getBalance() { return balance; }
}