import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String name;
    private double balance;
    private ArrayList<String> transactions;

    // Constructor
    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
        transactions = new ArrayList<>();
        transactions.add("Account created with Rs" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited Rs" + amount);
            System.out.println("Deposited successfully!");
        } else {
            System.out.println("Enter a valid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew Rs" + amount);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Not enough balance or invalid amount!");
        }
    }

    public void showBalance() {
        System.out.println("Current balance: Rs" + balance);
    }

    public void showTransactions() {
        System.out.println("Transaction History:");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: Rs");
        double balance = sc.nextDouble();

        Account acc = new Account(name, balance);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Deposit amount: Rs");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;
                case 2:
                    System.out.print("Withdraw amount: Rs");
                    double wd = sc.nextDouble();
                    acc.withdraw(wd);
                    break;
                case 3:
                    acc.showBalance();
                    break;
                case 4:
                    acc.showTransactions();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thanks for using our bank!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
