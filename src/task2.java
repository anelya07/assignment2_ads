import java.util.LinkedList;
import java.util.Scanner;

class BankAccount2 {
    private int accountNumber;
    private String username;
    private int balance;

    public BankAccount2(int accountNumber, String username, int balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String getUsername() { return username; }
    public int getBalance() { return balance; }
    public void setBalance(int b) { this.balance = b; }
}

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<BankAccount2> list = new LinkedList<>();

        list.add(new BankAccount2(1, "Ali", 150000));
        list.add(new BankAccount2(2, "Sara", 220000));

        while (true) {
            System.out.println("\n1. Add account");
            System.out.println("2. Display all");
            System.out.println("3. Search");
            System.out.println("4. Deposit money");
            System.out.println("5. Withdraw money");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Account number: ");
                int accNum = sc.nextInt();
                sc.nextLine();
                System.out.print("Username: ");
                String name = sc.nextLine();
                System.out.print("Balance: ");
                int bal = sc.nextInt();
                sc.nextLine();
                list.add(new BankAccount2(accNum, name, bal));
                System.out.println("Added.");

            } else if (choice == 2) {
                if (list.isEmpty()) System.out.println("Empty");
                else {
                    int c = 1;
                    for (BankAccount2 a : list) {
                        System.out.println(c++ + ". " + a.getUsername() + " – Balance: " + a.getBalance());
                    }
                }

            } else if (choice == 3) {
                System.out.print("Username: ");
                String search = sc.nextLine();
                boolean found = false;
                for (BankAccount2 a : list) {
                    if (a.getUsername().equals(search)) {
                        System.out.println("Balance: " + a.getBalance());
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Not found");

            } else if (choice == 4) {
                System.out.print("Enter username: ");
                String name = sc.nextLine();
                BankAccount2 target = null;
                for (BankAccount2 a : list) {
                    if (a.getUsername().equals(name)) {
                        target = a;
                        break;
                    }
                }
                if (target == null) {
                    System.out.println("User not found");
                } else {
                    System.out.print("Deposit amount: ");
                    int deposit = sc.nextInt();
                    sc.nextLine();
                    int newBal = target.getBalance() + deposit;
                    target.setBalance(newBal);
                    System.out.println("New balance: " + newBal);
                }

            } else if (choice == 5) {
                System.out.print("Enter username: ");
                String name = sc.nextLine();
                BankAccount2 target = null;
                for (BankAccount2 a : list) {
                    if (a.getUsername().equals(name)) {
                        target = a;
                        break;
                    }
                }
                if (target == null) {
                    System.out.println("User not found");
                } else {
                    System.out.print("Withdraw amount: ");
                    int withdraw = sc.nextInt();
                    sc.nextLine();
                    if (withdraw > target.getBalance()) {
                        System.out.println("Insufficient balance");
                    } else {
                        int newBal = target.getBalance() - withdraw;
                        target.setBalance(newBal);
                        System.out.println("New balance: " + newBal);
                    }
                }
            }
        }
    }
}