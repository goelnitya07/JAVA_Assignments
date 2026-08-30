import java.util.Scanner;

class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}

public class VotingSystem {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            try {
                if (age < 18) {
                    throw new UnderAgeException(
                        "You are not eligible to vote. Age must be 18 or above."
                    );
                }

                System.out.println("You are eligible to vote!");
            }

            catch (UnderAgeException e) {
                System.out.println("Voting Error: " + e.getMessage());
            }
        }
    }
}
