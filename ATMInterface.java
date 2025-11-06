import java.util.Scanner;

// Represents the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Amount deposited successfully!");
        } else {
            System.out.println("⚠️  Deposit amount must be greater than 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("⚠️  Withdrawal amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("💰 Amount withdrawn successfully!");
        }
    }
}

// Represents the ATM machine
class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n===================================");
            System.out.println("          🏧 ATM INTERFACE");
            System.out.println("===================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("⚠️  Please enter a valid number!");
                sc.next(); // clear invalid input
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> System.out.println("👋 Thank you for using our ATM!");
                default -> System.out.println("⚠️  Invalid choice! Please try again.");
            }

        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("💳 Current Balance: ₹" + String.format("%.2f", account.getBalance()));
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }
}

// Main program
public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("        💳 WELCOME TO ATM");
        System.out.println("===================================");
        System.out.print("Enter initial balance: ₹");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);
        atm.displayMenu();

        sc.close();
    }
}
