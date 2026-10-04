import java.sql.*;
import java.util.Scanner;

public class HospitalLogin {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String dbUser = "root";
        String dbPassword = "root";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Hospital Login ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String sql = "SELECT role FROM hospital_staff " +
                    "WHERE login_id = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, dbUser, dbPassword);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, loginId);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String role = rs.getString("role");

                System.out.println("Authentication Successful!");

                if (role.equalsIgnoreCase("Doctor")) {
                    System.out.println("Welcome Doctor.");
                    System.out.println("You have access to patient records,");
                    System.out.println("prescriptions and medical reports.");

                } else if (role.equalsIgnoreCase("Nurse")) {
                    System.out.println("Welcome Nurse.");
                    System.out.println("You have access to patient care");
                    System.out.println("and nursing-related information.");

                } else {
                    System.out.println("Welcome Hospital Staff.");
                }

            } else {
                System.out.println("Authentication Failed!");
                System.out.println("Invalid Login ID or Password.");
                System.out.println("Access Denied.");
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