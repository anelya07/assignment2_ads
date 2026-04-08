import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();

        while (true) {
            System.out.println("1. Add bill payment request");
            System.out.println("2. Process next bill payment");
            System.out.println("3. Display queue");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter bill description (e.g., Electricity Bill): ");
                String bills = sc.nextLine();
                queue.add(bills);
                System.out.println("Added: " + bills);

            } else if (choice == 2) {
                if (queue.isEmpty()) {
                    System.out.println("No bills to process.");
                } else {
                    String next = queue.poll();
                    System.out.println("Processing: " + next);
                    System.out.println("Remaining: " + queue);
                }

            } else if (choice == 3) {
                System.out.println("Current bill queue: " + queue);

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