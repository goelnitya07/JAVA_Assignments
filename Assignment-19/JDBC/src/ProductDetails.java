import java.sql.*;

public class ProductDetails {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String query = "SELECT product_id, product_name, quantity, price FROM products";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Product Details");
            System.out.printf("%-12s %-15s %-10s %-10s%n",
                    "Product ID", "Product Name", "Quantity", "Price");

            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                System.out.printf("%-12d %-15s %-10d %.2f%n",
                        id, name, quantity, price);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
