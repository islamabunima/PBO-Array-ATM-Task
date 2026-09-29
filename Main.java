import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank myBank = new Bank();
        
        // إضافة عميل افتراضي للتجربة
        myBank.addCustomer("Islam", "Abunima");
        Customer customer = myBank.getCustomer(0);
        customer.setAccount(new Account(500.0)); // رصيد ابتدائي 500

        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n=== Welcome to the Simple ATM ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            Account activeAccount = customer.getAccount(0);
            
            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + activeAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depAmount = scanner.nextDouble();
                    if (activeAccount.deposit(depAmount)) {
                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withAmount = scanner.nextDouble();
                    if (activeAccount.withdraw(withAmount)) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using our ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}