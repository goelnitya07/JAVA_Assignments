import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    static String url = "jdbc:mysql://localhost:3306/college";
    static String username = "root";
    static String password = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            while (true) {

                System.out.println("\nStudent Management");
                System.out.println("1. Create Student");
                System.out.println("2. Read Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        // CREATE
                        System.out.print("Enter Roll Number: ");
                        int rollNo = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        String insertQuery =
                                "INSERT INTO student_crud VALUES (?, ?, ?, ?)";

                        PreparedStatement insert =
                                con.prepareStatement(insertQuery);

                        insert.setInt(1, rollNo);
                        insert.setString(2, name);
                        insert.setString(3, course);
                        insert.setDouble(4, marks);

                        insert.executeUpdate();

                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        // READ
                        Statement stmt = con.createStatement();

                        ResultSet rs = stmt.executeQuery(
                                "SELECT * FROM student_crud");

                        System.out.println("\nStudent Records");
                        System.out.println("----------------------------------------");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("roll_no") + "  " +
                                    rs.getString("name") + "  " +
                                    rs.getString("course") + "  " +
                                    rs.getDouble("marks"));
                        }

                        break;

                    case 3:
                        // UPDATE
                        System.out.print("Enter Roll Number to update: ");
                        int updateRoll = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Course: ");
                        String newCourse = sc.nextLine();

                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();

                        String updateQuery =
                                "UPDATE student_crud SET name=?, " +
                                "course=?, marks=? WHERE roll_no=?";

                        PreparedStatement update =
                                con.prepareStatement(updateQuery);

                        update.setString(1, newName);
                        update.setString(2, newCourse);
                        update.setDouble(3, newMarks);
                        update.setInt(4, updateRoll);

                        int updated = update.executeUpdate();

                        if (updated > 0)
                            System.out.println("Student updated successfully.");
                        else
                            System.out.println("Student not found.");

                        break;

                    case 4:
                        // DELETE
                        System.out.print("Enter Roll Number to delete: ");
                        int deleteRoll = sc.nextInt();

                        String deleteQuery =
                                "DELETE FROM student_crud WHERE roll_no=?";

                        PreparedStatement delete =
                                con.prepareStatement(deleteQuery);

                        delete.setInt(1, deleteRoll);

                        int deleted = delete.executeUpdate();

                        if (deleted > 0)
                            System.out.println("Student deleted successfully.");
                        else
                            System.out.println("Student not found.");

                        break;

                    case 5:
                        con.close();
                        sc.close();
                        System.out.println("Program ended.");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
