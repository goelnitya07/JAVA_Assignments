import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class BookIssueTracking extends JFrame {

    JTextField txtBookId, txtStudent, txtIssueDate, txtReturnDate;
    JTable table;
    DefaultTableModel model;

    String url = "jdbc:mysql://localhost:3306/college";
    String dbUser = "root";
    String dbPassword = "root";

    public BookIssueTracking() {

        setTitle("Book Issue Tracking System");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Book ID:"));
        txtBookId = new JTextField();
        panel.add(txtBookId);

        panel.add(new JLabel("Student Name:"));
        txtStudent = new JTextField();
        panel.add(txtStudent);

        panel.add(new JLabel("Issue Date (YYYY-MM-DD):"));
        txtIssueDate = new JTextField();
        panel.add(txtIssueDate);

        panel.add(new JLabel("Return Date (YYYY-MM-DD):"));
        txtReturnDate = new JTextField();
        panel.add(txtReturnDate);

        JButton addButton = new JButton("Issue Book");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");

        panel.add(addButton);
        panel.add(updateButton);

        panel.add(deleteButton);
        panel.add(clearButton);

        add(panel, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new String[]{
                        "Book ID",
                        "Student Name",
                        "Issue Date",
                        "Return Date"
                }, 0);

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        addButton.addActionListener(e -> addRecord());
        updateButton.addActionListener(e -> updateRecord());
        deleteButton.addActionListener(e -> deleteRecord());
        clearButton.addActionListener(e -> clearFields());

        loadRecords();

        setVisible(true);
    }

    void addRecord() {

        String sql = "INSERT INTO book_issues VALUES (?, ?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(
                    url, dbUser, dbPassword);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtBookId.getText()));
            ps.setString(2, txtStudent.getText());
            ps.setDate(3, Date.valueOf(txtIssueDate.getText()));
            ps.setDate(4, Date.valueOf(txtReturnDate.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Book Issue Record Added Successfully!");

            ps.close();
            con.close();

            loadRecords();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage());
        }
    }

    void updateRecord() {

        String sql = "UPDATE book_issues SET student_name=?, " +
                    "issue_date=?, return_date=? WHERE book_id=?";

        try {
            Connection con = DriverManager.getConnection(
                    url, dbUser, dbPassword);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtStudent.getText());
            ps.setDate(2, Date.valueOf(txtIssueDate.getText()));
            ps.setDate(3, Date.valueOf(txtReturnDate.getText()));
            ps.setInt(4, Integer.parseInt(txtBookId.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Record Updated Successfully!");

            ps.close();
            con.close();

            loadRecords();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage());
        }
    }

    void deleteRecord() {

        String sql = "DELETE FROM book_issues WHERE book_id=?";

        try {
            Connection con = DriverManager.getConnection(
                    url, dbUser, dbPassword);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtBookId.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Record Deleted Successfully!");

            ps.close();
            con.close();

            loadRecords();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage());
        }
    }

    void loadRecords() {

        model.setRowCount(0);

        String sql = "SELECT * FROM book_issues";

        try {
            Connection con = DriverManager.getConnection(
                    url, dbUser, dbPassword);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("book_id"),
                        rs.getString("student_name"),
                        rs.getDate("issue_date"),
                        rs.getDate("return_date")
                });
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage());
        }
    }

    void clearFields() {
        txtBookId.setText("");
        txtStudent.setText("");
        txtIssueDate.setText("");
        txtReturnDate.setText("");
    }

    public static void main(String[] args) {
        new BookIssueTracking();
    }
}