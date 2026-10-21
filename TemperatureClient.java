import java.rmi.Naming;
import java.util.Scanner;
public class TemperatureClient {
    public static void main(String[] args) {

        try {
            Temperature temp =
                (Temperature) Naming.lookup("TemperatureService");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter temperature: ");
            double value = sc.nextDouble();
            System.out.println(
                "Celsius to Fahrenheit: " +
                temp.celsiusToFahrenheit(value)
            );
            System.out.println(
                "Fahrenheit to Celsius: " +
                temp.fahrenheitToCelsius(value)
            );
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}