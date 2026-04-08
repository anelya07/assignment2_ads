import java.util.Scanner;
import java.util.Stack;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        while (true) {
            System.out.println("1. Add transaction");
            System.out.println("2. Undo last transaction (pop)");
            System.out.println("3. Display last transaction (peek)");
            System.out.println("4. Show all");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter transaction (e.g., 'Deposit 50000 to Ali'): ");
                String transaction = sc.nextLine();
                stack.push(transaction);
                System.out.println("Added: " + transaction);

            } else if (choice == 2) {
                if (stack.isEmpty()) {
                    System.out.println("No transactions to undo.");
                } else {
                    String undo = stack.pop();
                    System.out.println("Undo → " + undo + " removed");
                }

            } else if (choice == 3) {
                if (stack.isEmpty()) {
                    System.out.println("No transactions.");
                } else {
                    System.out.println("Last transaction: " + stack.peek());
                }

            } else if (choice == 4) {
                if (stack.isEmpty()) {
                    System.out.println("Empty");
                } else {
                    System.out.println("All transactions:");
                    for (String display : stack) {
                        System.out.println(" - " + display);
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
