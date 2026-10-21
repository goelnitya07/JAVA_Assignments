import java.rmi.Naming;
public class TemperatureServer {
    public static void main(String[] args) {
        try {
            TemperatureImpl obj = new TemperatureImpl();
            Naming.rebind("TemperatureService", obj);
            System.out.println(
                "Temperature Server is running..."
            );
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}