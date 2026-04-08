import java.util.LinkedList;
import java.util.Scanner;

class BankAccount
{
    private int accountNumber;
    private String userName;
    private int balance;

    public BankAccount(int accountNumber, String userName, int balance)
    {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.balance = balance;
    }
    public int getAccountNumber()
    {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }
    public String getUserName()
    {
        return userName;
    }
}

class task1 {
    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<BankAccount> list = new LinkedList<>();
        while (true) {
            System.out.println("1. Add a new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Search account by username");
            System.out.print("Choose option: ");

            int choice =  sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("Enter account number");
                int accountNumber2 = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter user name");
                String userName2 = sc.nextLine();
                System.out.println("Enter balance");
                int balance2 = sc.nextInt();
                sc.nextLine();

                BankAccount account = new BankAccount(accountNumber2, userName2, balance2);
                list.add(account);
            } else if (choice == 2) {
                System.out.println("Account list: ");
                System.out.println(list);
            } else if (choice == 3) {
                System.out.println("Enter user name");
                String userNameFind = sc.nextLine();
            } else {
                System.out.println("Неверный выбор, попробуй снова");
            }
        }




    }
}