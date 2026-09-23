import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BankBalanceCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bank Balance Calculator");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblInitial = new JLabel("Initial Balance:");
        JTextField txtInitial = new JTextField();

        JLabel lblAmount = new JLabel("Transaction Amount:");
        JTextField txtAmount = new JTextField();

        JButton btnDeposit = new JButton("Deposit (+)");
        JButton btnWithdraw = new JButton("Withdraw (-)");

        JLabel lblBalance = new JLabel("Current Balance: $0.00");

        panel.add(lblInitial);
        panel.add(txtInitial);
        panel.add(lblAmount);
        panel.add(txtAmount);
        panel.add(btnDeposit);
        panel.add(btnWithdraw);
        panel.add(new JLabel("Status:"));
        panel.add(lblBalance);

        btnDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double initial = Double.parseDouble(txtInitial.getText());
                    double amount = Double.parseDouble(txtAmount.getText());
                    double updated = initial + amount;
                    
                    lblBalance.setText("Current Balance: $" + updated);
                    txtInitial.setText(String.valueOf(updated));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numeric amounts!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double initial = Double.parseDouble(txtInitial.getText());
                    double amount = Double.parseDouble(txtAmount.getText());

                    if (amount > initial) {
                        JOptionPane.showMessageDialog(frame, "Insufficient funds for withdrawal!", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        double updated = initial - amount;
                        lblBalance.setText("Current Balance: $" + updated);
                        txtInitial.setText(String.valueOf(updated)); 
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numeric amounts!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
