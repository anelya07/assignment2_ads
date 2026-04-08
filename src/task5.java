import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Request {
    String username;
    int initialDeposit;
    public Request(String username, int initialDeposit) {
        this.username = username;
        this.initialDeposit = initialDeposit;
    }
    public String toString() {
        return username + " (deposit: " + initialDeposit + ")";
    }
}

public class task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Request> queue = new LinkedList<>();
        LinkedList<BankAccount5> list = new LinkedList<>();

        while (true) {
            System.out.println("\n--- Admin Simulation ---");
            System.out.println("1. Add account request");
            System.out.println("2. Process next request");
            System.out.println("3. Display pending requests");
            System.out.println("4. Display all approved accounts");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter initial deposit: ");
                int initialDeposit = sc.nextInt(); sc.nextLine();
                queue.add(new Request(username, initialDeposit));
                System.out.println("Request submitted.");

            } else if (choice == 2) {
                if (queue.isEmpty()) {
                    System.out.println("No pending requests.");
                } else {
                    Request r = queue.poll();
                    int newNum = list.size() + 1;
                    BankAccount5 acc = new BankAccount5(newNum, r.username, r.initialDeposit);
                    list.add(acc);
                    System.out.println("Processed: " + r.username + " → account #" + newNum);
                }

            } else if (choice == 3) {
                if (queue.isEmpty()) {
                    System.out.println("No pending requests.");
                } else {
                    System.out.println("Pending: " + queue);
                }

            } else if (choice == 4) {
                if (list.isEmpty()) {
                    System.out.println("No accounts yet.");
                } else {
                    System.out.println("Approved accounts:");
                    int c = 1;
                    for (BankAccount5 a : list) {
                        System.out.println(c++ + ". " + a.getUsername() + " – Balance: " + a.getBalance());
                    }
                }

            } else if (choice == 5) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid");
            }
        }
        sc.close();
    }
}

class BankAccount5 {
    private int accountNumber;
    private String username;
    private int balance;
    public BankAccount5(int accountNumber, String username, int balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }
    public String getUsername() { return username; }
    public int getBalance() { return balance; }
}