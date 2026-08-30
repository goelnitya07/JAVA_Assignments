import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        double balance = 10000;

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("ATM MACHINE");
            System.out.println("Balance: Rs. " + balance);

            System.out.print("Enter withdrawal amount: Rs. ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                throw new Exception("Invalid withdrawal amount!");
            }

            if (amount > balance) {
                throw new Exception("Insufficient balance!");
            }

            balance = balance - amount;

            System.out.println("Withdrawal successful!");
            System.out.println("Withdrawn: Rs. " + amount);
            System.out.println("Remaining Balance: Rs. " + balance);
        }

        catch (Exception e) {
            System.out.println("Transaction failed!");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
