import java.util.Scanner;

public class ATM_Pin_Verification {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int correctPIN = 1234;

            System.out.print("Enter your ATM PIN: ");
            int pin = sc.nextInt();

            try {
                if (pin != correctPIN) {
                    throw new Exception("Invalid PIN!");
                }

                System.out.println("PIN verified successfully!");
            }

            catch (Exception e) {
                System.out.println("Verification failed: " + e.getMessage());
            }

            finally {
                System.out.println("PIN verification process completed.");
            }
        }
    }
}