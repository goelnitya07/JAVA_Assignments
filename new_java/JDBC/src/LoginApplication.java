import java.sql.*;
import java.util.Scanner;

public class LoginApplication {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String dbUser = "root";
        String dbPassword = "root";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, dbUser, dbPassword);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful!");
                System.out.println("Welcome, " + username);
            } else {
                System.out.println("Invalid username or password.");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}
