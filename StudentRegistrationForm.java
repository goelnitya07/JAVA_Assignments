import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StudentRegistrationForm {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblName = new JLabel("Name:");
        JTextField txtName = new JTextField();

        JLabel lblRoll = new JLabel("Roll Number:");
        JTextField txtRoll = new JTextField();

        JLabel lblCourse = new JLabel("Course:");
        JTextField txtCourse = new JTextField();

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();

        JButton btnSubmit = new JButton("Register");

        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblRoll);
        panel.add(txtRoll);
        panel.add(lblCourse);
        panel.add(txtCourse);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(new JLabel());
        panel.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String roll = txtRoll.getText();
                String course = txtCourse.getText();
                String email = txtEmail.getText();

                if (name.isEmpty() || roll.isEmpty() || course.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String message = "Student Registered Successfully!\n\n"
                            + "Name: " + name + "\n"
                            + "Roll Number: " + roll + "\n"
                            + "Course: " + course + "\n"
                            + "Email: " + email;
                    JOptionPane.showMessageDialog(frame, message, "Registration Details", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
