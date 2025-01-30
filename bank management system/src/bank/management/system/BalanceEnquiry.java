package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    JLabel balanceLabel;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

          back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        balanceLabel = new JLabel("Your current balance is: Rs ");
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setFont(new Font("System", Font.BOLD, 20)); // Adjusted font size for better fitting
        balanceLabel.setBounds(170, 300, 400, 30); // Adjusted the position to fit the text
        image.add(balanceLabel);

        // Fetch the current balance from the database
        fetchBalance();

       

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    private void fetchBalance() {
        try {
            Conn conn = new Conn();
            double balance = 0;

            // Query to get the balance from the database
            ResultSet tk = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while (tk.next()) {
                String type = tk.getString("type");
                double amount = Double.parseDouble(tk.getString("amount"));

                // Calculate the balance based on the transaction type
                if (type.equals("Deposit")) {
                    balance += amount;
                } else if (type.equals("Withdrawal")) {
                    balance -= amount;
                }
            }

            // Update the balance label to show the current balance
            balanceLabel.setText("Your current balance is: Tk " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry(""); // Test with a dummy pin number
    }
}
