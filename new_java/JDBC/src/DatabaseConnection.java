import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Database connected successfully.");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Database connection failed.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}