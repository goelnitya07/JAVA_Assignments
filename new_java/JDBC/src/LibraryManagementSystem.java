import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class LibraryManagementSystem extends JFrame {

    JTextField txtId, txtName, txtAuthor, txtQuantity;
    JTable table;
    DefaultTableModel model;

    String url = "jdbc:mysql://localhost:3306/college";
    String dbUser = "root";
    String dbPassword = "root";

    public LibraryManagementSystem() {

        setTitle("Library Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Book ID:"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Book Name:"));
        txtName = new JTextField();
        panel.add(txtName);

        panel.add(new JLabel("Author:"));
        txtAuthor = new JTextField();
        panel.add(txtAuthor);

        panel.add(new JLabel("Quantity:"));
        txtQuantity = new JTextField();
        panel.add(txtQuantity);

        JButton addButton = new JButton("Add Book");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");

        panel.add(addButton);
        panel.add(updateButton);

        panel.add(deleteButton);
        panel.add(clearButton);

        add(panel, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new String[]{"Book ID", "Book Name", "Author", "Quantity"}, 0);

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        addButton.addActionListener(e -> addBook());
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());
        clearButton.addActionListener(e -> clearFields());

        loadBooks();

        setVisible(true);
    }

    void addBook() {

        String sql = "INSERT INTO books VALUES (?, ?, ?, ?)";

        try {
            Connection con = DriverManager.getConnection(
                    url, dbUser, dbPassword);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ps.setString(2, txtName.getText());
            ps.setString(3, txtAuthor.getText());
            ps.setInt(4, Integer.parseInt(txtQuantity.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Book Added Successfully!");

            ps.close();
            con.close();

            loadBooks();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage());
        }
    }

    void updateBook() {

        String sql = "UPDATE books SET book_name=?, author=?, quantity=? " +
                    "WHERE book_id=?";

        try {
            Connection con = DriverManager.getConnection(
                    url, dbUser, dbPassword);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtName.getText());
            ps.setString(2, txtAuthor.getText());
            ps.setInt(3, Integer.parseInt(txtQuantity.getText()));
            ps.setInt(4, Integer.parseInt(txtId.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Book Updated Successfully!");

            ps.close();
            con.close();

            loadBooks();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage());
        }
    }

    void deleteBook() {

        String sql = "DELETE FROM books WHERE book_id=?";

        try {
            Connection con = DriverManager.getConnection(
                    url, dbUser, dbPassword);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(txtId.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Book Deleted Successfully!");

            ps.close();
            con.close();

            loadBooks();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + e.getMessage());
        }
    }

    void loadBooks() {

        model.setRowCount(0);

        String sql = "SELECT * FROM books";

        try {
            Connection con = DriverManager.getConnection(
                    url, dbUser, dbPassword);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("author"),
                        rs.getInt("quantity")
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
        txtId.setText("");
        txtName.setText("");
        txtAuthor.setText("");
        txtQuantity.setText("");
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
}