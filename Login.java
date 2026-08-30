import java.util.Scanner;

public class Login {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            String correctPassword = "java123";

            System.out.print("Enter your password: ");
            String password = sc.nextLine();

            try {
                if (!password.equals(correctPassword)) {
                    throw new Exception("Invalid password!");
                }

                System.out.println("Login successful!");
            }

            catch (Exception e) {
                System.out.println("Login failed: " + e.getMessage());
            }

            finally {
                System.out.println("Login process completed.");
            }
        }
    }
}
