import java.util.LinkedList;
import java.util.Scanner;

class BankAccount {
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
}

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<BankAccount> list = new LinkedList<>();

        while (true) {
            System.out.println("---------------------------");
            System.out.println("1. Add a new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Search account by username");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter account number: ");
                int accountNumber2 = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter user name: ");
                String username2 = sc.nextLine();
                System.out.print("Enter balance: ");
                int balance2 = sc.nextInt();
                sc.nextLine();

                BankAccount acc = new BankAccount(accountNumber2, username2, balance2);
                list.add(acc);
                System.out.println("Account added successfully");

            } else if (choice == 2) {
                if (list.isEmpty()) {
                    System.out.println("No accounts.");
                } else {
                    System.out.println("Accounts List:");
                    int count = 1;
                    for (BankAccount a : list) {
                        System.out.println(count + ". " + a.getUsername() + " – Balance: " + a.getBalance());
                        count++;
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter username to search: ");
                String check = sc.nextLine();
                boolean found = false;
                for (BankAccount a : list) {
                    if (a.getUsername().equals(check)) {
                        System.out.println("Found: " + a.getUsername() + " – Account: " + a.getAccountNumber() + ", Balance: " + a.getBalance());
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Not found.");

            } else if (choice == 4) {
                System.out.println("Bye");
                break;
            } else {
                System.out.println("Invalid");
            }
        }
        sc.close();
    }
}


