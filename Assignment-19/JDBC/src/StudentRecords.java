import java.sql.*;

public class StudentRecords {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM students";

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Student Records");

            while (rs.next()) {

                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                int age = rs.getInt("age");
                String course = rs.getString("course");

                System.out.println(
                    id + "  " + name + "  " +
                    age + "  " + course
                );
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
