import java.util.Scanner;

class ATM {
    int pin = 1234;
    double balance = 1000;
    Scanner scanner = new Scanner(System.in);

    void start() {
        int attempt = 3;
        while (attempt > 0) {
            System.out.println("Enter your PIN:");
            int userPin = scanner.nextInt();
            if (userPin == pin) {
                System.out.println("Welcome!");
                menu();
                break;
            } else {
                attempt--;
                System.out.println("Incorrect PIN. You have " + attempt + " attempts left.");
            }
        }
        if (attempt == 0) {
            System.out.println("Your account is blocked. Please contact the bank.");
        }
    }

    void menu() {
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    void withdrawMoney() {
        System.out.println("Enter the amount you want to withdraw:");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("You have withdrawn: $" + amount);
            System.out.println("Your new balance is: $" + balance);
        }
    }

    void depositMoney() {
        System.out.println("Enter the amount you want to deposit:");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("You have deposited: $" + amount);
        System.out.println("Your new balance is: $" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}