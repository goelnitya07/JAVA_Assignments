import java.sql.*;
import java.util.Scanner;

public class EmployeeCRUD {

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

                System.out.println("\nEmployee Management");
                System.out.println("1. Create Employee");
                System.out.println("2. Read Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        // CREATE
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String department = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        String insertQuery =
                                "INSERT INTO employees VALUES (?, ?, ?, ?)";

                        PreparedStatement insert =
                                con.prepareStatement(insertQuery);

                        insert.setInt(1, id);
                        insert.setString(2, name);
                        insert.setString(3, department);
                        insert.setDouble(4, salary);

                        insert.executeUpdate();

                        System.out.println("Employee added successfully.");
                        break;

                    case 2:
                        // READ
                        Statement stmt = con.createStatement();

                        ResultSet rs = stmt.executeQuery(
                                "SELECT * FROM employees");

                        System.out.println("\nEmployee Records");
                        System.out.println("----------------------------------------");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("employee_id") + "  " +
                                    rs.getString("employee_name") + "  " +
                                    rs.getString("department") + "  " +
                                    rs.getDouble("salary"));
                        }

                        break;

                    case 3:
                        // UPDATE
                        System.out.print("Enter Employee ID to update: ");
                        int updateId = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Department: ");
                        String newDepartment = sc.nextLine();

                        System.out.print("Enter New Salary: ");
                        double newSalary = sc.nextDouble();

                        String updateQuery =
                                "UPDATE employees SET employee_name=?, " +
                                "department=?, salary=? WHERE employee_id=?";

                        PreparedStatement update =
                                con.prepareStatement(updateQuery);

                        update.setString(1, newName);
                        update.setString(2, newDepartment);
                        update.setDouble(3, newSalary);
                        update.setInt(4, updateId);

                        int updated = update.executeUpdate();

                        if (updated > 0)
                            System.out.println("Employee updated successfully.");
                        else
                            System.out.println("Employee not found.");

                        break;

                    case 4:
                        // DELETE
                        System.out.print("Enter Employee ID to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery =
                                "DELETE FROM employees WHERE employee_id=?";

                        PreparedStatement delete =
                                con.prepareStatement(deleteQuery);

                        delete.setInt(1, deleteId);

                        int deleted = delete.executeUpdate();

                        if (deleted > 0)
                            System.out.println("Employee deleted successfully.");
                        else
                            System.out.println("Employee not found.");

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