import java.util.*;

class Account {
    String name;
    int accountNumber;
    int balance;

    public Account(String name, int accountNumber, int balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(int amount) {
        balance += amount;
        System.out.println("Amount deposited successfully. Current Balance: " + balance);
    }

    void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully. Current Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = null;

        while (true) {
            System.out.println("1. Create account");
            System.out.println("2. Deposit amount");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (account == null) {
                        System.out.print("Enter name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Enter account number: ");
                        int accountNumber = sc.nextInt();
                        System.out.print("Enter initial balance: ");
                        int balance = sc.nextInt();
                        account = new Account(name, accountNumber, balance);
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Account already exists.");
                    }
                    break;

                case 2:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        int depositAmount = sc.nextInt();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        int withdrawAmount = sc.nextInt();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the banking system. Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
