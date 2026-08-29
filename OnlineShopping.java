import java.util.Scanner;

public class OnlineShopping {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("ONLINE SHOPPING");

            System.out.print("Enter product name: ");
            String product = sc.nextLine();

            System.out.print("Enter product quantity: ");
            int quantity = sc.nextInt();

            if (quantity <= 0) {
                throw new Exception("Invalid product quantity!");
            }

            System.out.println("\nOrder placed successfully!");
            System.out.println("Product  : " + product);
            System.out.println("Quantity : " + quantity);
        }

        catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}
