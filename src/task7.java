import java.util.*;

class AccountFinal {
    int number;
    String name;
    int balance;
    public AccountFinal(int number, String name, int balance) {
        this.number = number;
        this.name = name;
        this.balance = balance;
    }
    String getName() { return name; }
    int getBalance() { return balance; }
    void setBalance(int b) { balance = b; }
}

class RequestFinal {
    String name;
    int deposit;
    RequestFinal(String name, int deposit) {
        this.name = name;
        this.deposit = deposit;
    }
}
public class task7 {
    static LinkedList<AccountFinal> list = new LinkedList<>();
    static Stack<String> stack = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<RequestFinal> requestQueue = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        list.add(new AccountFinal(1, "Ali", 150000));
        list.add(new AccountFinal(2, "Sara", 220000));

        while (true) {
            System.out.println("===== MAIN MENU =====");
            System.out.println("1 – Enter Bank");
            System.out.println("2 – Enter ATM");
            System.out.println("3 – Admin Area");
            System.out.println("4 – Exit");
            System.out.print("Choose: ");
            int m = sc.nextInt(); sc.nextLine();
            if (m == 1) bankMenu();
            else if (m == 2) atmMenu();
            else if (m == 3) adminMenu();
            else if (m == 4) { System.out.println("Bye"); break; }
            else System.out.println("Invalid");
        }
        sc.close();
    }

    static void bankMenu() {
        while (true) {
            System.out.println("--- Bank Menu ---");
            System.out.println("1. Submit account request");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Back");
            System.out.print("Choose: ");
            int c = sc.nextInt(); sc.nextLine();
            if (c == 1) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Initial deposit: ");
                int d = sc.nextInt(); sc.nextLine();
                requestQueue.add(new RequestFinal(u, d));
                System.out.println("Request sent.");
            } else if (c == 2) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                AccountFinal a = find(u);
                if (a == null) System.out.println("Not found");
                else {
                    System.out.print("Amount: ");
                    int amt = sc.nextInt(); sc.nextLine();
                    a.setBalance(a.getBalance() + amt);
                    stack.push("Deposit " + amt + " to " + u);
                    System.out.println("New balance: " + a.getBalance());
                }
            } else if (c == 3) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                AccountFinal a = find(u);
                if (a == null) System.out.println("Not found");
                else {
                    System.out.print("Amount: ");
                    int amt = sc.nextInt(); sc.nextLine();
                    if (amt > a.getBalance()) System.out.println("Insufficient");
                    else {
                        a.setBalance(a.getBalance() - amt);
                        stack.push("Withdraw " + amt + " from " + u);
                        System.out.println("New balance: " + a.getBalance());
                    }
                }
            } else if (c == 4) break;
            else System.out.println("Invalid");
        }
    }

    static void atmMenu() {
        System.out.print("Enter username: ");
        String u = sc.nextLine();
        AccountFinal a = find(u);
        if (a == null) {
            System.out.println("No account");
            return;
        }
        while (true) {
            System.out.println("--- ATM for " + u + " ---");
            System.out.println("1. Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Back");
            System.out.print("Choose: ");
            int c = sc.nextInt(); sc.nextLine();
            if (c == 1) {
                System.out.println("Balance: " + a.getBalance());
            } else if (c == 2) {
                System.out.print("Amount: ");
                int amt = sc.nextInt(); sc.nextLine();
                if (amt > a.getBalance()) System.out.println("Insufficient");
                else {
                    a.setBalance(a.getBalance() - amt);
                    stack.push("ATM Withdraw " + amt + " from " + u);
                    System.out.println("Take cash. New balance: " + a.getBalance());
                }
            } else if (c == 3) break;
            else System.out.println("Invalid");
        }
    }

    static void adminMenu() {
        while (true) {
            System.out.println("--- Admin Menu ---");
            System.out.println("1. Process account requests");
            System.out.println("2. Process bill payments");
            System.out.println("3. Show all accounts");
            System.out.println("4. Show transaction history");
            System.out.println("5. Back");
            System.out.print("Choose: ");
            int c = sc.nextInt(); sc.nextLine();
            if (c == 1) {
                if (requestQueue.isEmpty()) System.out.println("No requests");
                else {
                    RequestFinal r = requestQueue.poll();
                    int newNum = list.size() + 1;
                    list.add(new AccountFinal(newNum, r.name, r.deposit));
                    System.out.println("Processed " + r.name + " -> account #" + newNum);
                }
            } else if (c == 2) {
                if (billQueue.isEmpty()) System.out.println("No bills");
                else {
                    String b = billQueue.poll();
                    System.out.println("Processing: " + b);
                    System.out.println("Remaining: " + billQueue);
                }
            } else if (c == 3) {
                if (list.isEmpty()) System.out.println("No accounts");
                else {
                    int i = 1;
                    for (AccountFinal acc : list) {
                        System.out.println(i++ + ". " + acc.getName() + " – Balance: " + acc.getBalance());
                    }
                }
            } else if (c == 4) {
                if (stack.isEmpty()) System.out.println("Empty history");
                else {
                    System.out.println("Last transaction: " + stack.peek());
                    System.out.println("All:");
                    for (String s : stack) System.out.println(" - " + s);
                }
            } else if (c == 5) break;
            else System.out.println("Invalid");
        }
    }

    static AccountFinal find(String name) {
        for (AccountFinal a : list) {
            if (a.getName().equals(name)) return a;
        }
        return null;
    }
}