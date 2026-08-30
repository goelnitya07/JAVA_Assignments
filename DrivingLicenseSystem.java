import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class DrivingLicenseSystem {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            try {
                if (age < 18) {
                    throw new InvalidAgeException(
                        "Age is below 18. You are not eligible for a driving license."
                    );
                }

                System.out.println("You are eligible for a driving license!");
            }

            catch (InvalidAgeException e) {
                System.out.println("License Error: " + e.getMessage());
            }
        }
    }
}