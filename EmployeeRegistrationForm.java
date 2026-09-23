import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EmployeeRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Registration Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblEmpId = new JLabel("Employee ID:");
        JTextField txtEmpId = new JTextField();

        JLabel lblName = new JLabel("Name:");
        JTextField txtName = new JTextField();

        JLabel lblDept = new JLabel("Department:");
        JTextField txtDept = new JTextField();

        JLabel lblSalary = new JLabel("Salary:");
        JTextField txtSalary = new JTextField();

        JButton btnSubmit = new JButton("Submit");

        panel.add(lblEmpId);
        panel.add(txtEmpId);
        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblDept);
        panel.add(txtDept);
        panel.add(lblSalary);
        panel.add(txtSalary);
        panel.add(new JLabel());
        panel.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empId = txtEmpId.getText();
                String name = txtName.getText();
                String dept = txtDept.getText();
                String salary = txtSalary.getText();

                if (empId.isEmpty() || name.isEmpty() || dept.isEmpty() || salary.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled out!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    String message = "Employee Details Saved:\n\n" +
                                     "Employee ID: " + empId + "\n" +
                                     "Name: " + name + "\n" +
                                     "Department: " + dept + "\n" +
                                     "Salary: $" + salary;
                    JOptionPane.showMessageDialog(frame, message, "Employee Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
