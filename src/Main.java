import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MyLinkedList accounts = new MyLinkedList();
        accounts.add(new BankAccount(1, "Ali", 150000));
        accounts.add(new BankAccount(2, "Sara", 220000));

        MyStack history = new MyStack(100);

        MyQueue billQueue = new MyQueue(100);
        billQueue.add("Electricity Bill");
        billQueue.add("Internet Bill");

        RequestQueue requestQueue = new RequestQueue(100);

        BankAccount[] fixedAccounts = new BankAccount[3];
        fixedAccounts[0] = new BankAccount(101, "Anelya", 55000);
        fixedAccounts[1] = new BankAccount(102, "Aliya", 75000);
        fixedAccounts[2] = new BankAccount(103, "Nurali", 15000);
        for (int i = 0; i < fixedAccounts.length; i++) {
            System.out.println((i+1) + ". " + fixedAccounts[i].getUsername() + " – Balance: " + fixedAccounts[i].getBalance());
        }

        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1 – Enter Bank");
            System.out.println("2 – Enter ATM");
            System.out.println("3 – Admin Area");
            System.out.println("4 – Exit");
            System.out.print("Choose: ");
            int m = sc.nextInt(); sc.nextLine();

            if (m == 1) bankMenu(accounts, history, requestQueue);
            else if (m == 2) atmMenu(accounts, history);
            else if (m == 3) adminMenu(accounts, history, billQueue, requestQueue);
            else if (m == 4) { System.out.println("Goodbye!"); break; }
            else System.out.println("Invalid option.");
        }
        sc.close();
    }

    static void bankMenu(MyLinkedList accounts, MyStack history, RequestQueue requestQueue) {
        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Submit account request (Task5)");
            System.out.println("2. Deposit money (Task2)");
            System.out.println("3. Withdraw money (Task2)");
            System.out.println("4. Back");
            System.out.print("Choose: ");
            int c = sc.nextInt(); sc.nextLine();

            if (c == 1) {
                System.out.print("Username: "); String u = sc.nextLine();
                System.out.print("Initial deposit: "); int d = sc.nextInt(); sc.nextLine();
                requestQueue.add(new Request(u, d));
                System.out.println("Request sent.");
            } else if (c == 2) {
                System.out.print("Username: "); String u = sc.nextLine();
                BankAccount a = accounts.findByUsername(u);
                if (a == null) System.out.println("Not found");
                else {
                    System.out.print("Amount: "); int amt = sc.nextInt(); sc.nextLine();
                    a.setBalance(a.getBalance() + amt);
                    history.push("Deposit " + amt + " to " + u);
                    System.out.println("New balance: " + a.getBalance());
                }
            } else if (c == 3) {
                System.out.print("Username: "); String u = sc.nextLine();
                BankAccount a = accounts.findByUsername(u);
                if (a == null) System.out.println("Not found");
                else {
                    System.out.print("Amount: "); int amt = sc.nextInt(); sc.nextLine();
                    if (amt > a.getBalance()) System.out.println("Insufficient");
                    else {
                        a.setBalance(a.getBalance() - amt);
                        history.push("Withdraw " + amt + " from " + u);
                        System.out.println("New balance: " + a.getBalance());
                    }
                }
            } else if (c == 4) break;
            else System.out.println("Invalid");
        }
    }

    static void atmMenu(MyLinkedList accounts, MyStack history) {
        System.out.print("Enter username: ");
        String u = sc.nextLine();
        BankAccount a = accounts.findByUsername(u);
        if (a == null) {
            System.out.println("No account");
            return;
        }
        while (true) {
            System.out.println("\n--- ATM for " + u + " ---");
            System.out.println("1. Balance enquiry");
            System.out.println("2. Withdraw (Task2)");
            System.out.println("3. Back");
            System.out.print("Choose: ");
            int c = sc.nextInt(); sc.nextLine();

            if (c == 1) {
                System.out.println("Balance: " + a.getBalance());
            } else if (c == 2) {
                System.out.print("Amount: "); int amt = sc.nextInt(); sc.nextLine();
                if (amt > a.getBalance()) System.out.println("Insufficient");
                else {
                    a.setBalance(a.getBalance() - amt);
                    history.push("ATM Withdraw " + amt + " from " + u);
                    System.out.println("Take cash. New balance: " + a.getBalance());
                }
            } else if (c == 3) break;
            else System.out.println("Invalid");
        }
    }

    static void adminMenu(MyLinkedList accounts, MyStack history, MyQueue billQueue, RequestQueue requestQueue) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Process account requests (Task5)");
            System.out.println("2. Process bill payments (Task4)");
            System.out.println("3. Show all accounts (Task1)");
            System.out.println("4. Show transaction history (Task3)");
            System.out.println("5. Back");
            System.out.print("Choose: ");
            int c = sc.nextInt(); sc.nextLine();

            if (c == 1) {
                if (requestQueue.isEmpty()) System.out.println("No requests");
                else {
                    Request r = requestQueue.poll();
                    int newNum = accounts.size() + 1;
                    accounts.add(new BankAccount(newNum, r.username, r.initialDeposit));
                    System.out.println("Processed " + r.username + " -> account #" + newNum);
                }
            } else if (c == 2) {
                if (billQueue.isEmpty()) System.out.println("No bills");
                else {
                    String b = billQueue.poll();
                    System.out.println("Processing: " + b);
                    System.out.print("Remaining: ");
                    billQueue.printQueue();
                }
            } else if (c == 3) {
                if (accounts.isEmpty()) System.out.println("No accounts");
                else accounts.printAll();
            } else if (c == 4) {
                history.printAll();
            } else if (c == 5) break;
            else System.out.println("Invalid");
        }
    }
}



















