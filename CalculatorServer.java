import java.rmi.Naming;
public class CalculatorServer {

    public static void main(String[] args) {
        try {
            CalculatorImpl obj = new CalculatorImpl();
            Naming.rebind("CalculatorService", obj);
            System.out.println("Calculator Server is running...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}