import java.rmi.Naming;
import java.util.Scanner;
public class CalculatorClient {
    public static void main(String[] args) {

        try {
            Calculator_RMI calc =
                    (Calculator_RMI) Naming.lookup("CalculatorService");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter first number: ");
            int a = sc.nextInt();
            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.println("Addition: " + calc.add(a, b));
            System.out.println("Subtraction: " + calc.subtract(a, b));
            System.out.println("Multiplication: " + calc.multiply(a, b));
            System.out.println("Division: " + calc.divide(a, b));

            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}