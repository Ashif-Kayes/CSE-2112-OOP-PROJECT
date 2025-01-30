package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Withdrawal extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    Withdrawal(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdraw = new JButton("Withdrawal");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amount.getText();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else {
                try {
                    double withdrawalAmount = Double.parseDouble(number);

                    if (withdrawalAmount <= 0) {
                        JOptionPane.showMessageDialog(null, "Cannot withdraw negative or zero amount");
                        return;
                    }

                    Conn conn = new Conn();

                    // Calculate the current balance
                    ResultSet tk = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
                    double balance = 0;

                    while (tk.next()) {
                        String type = tk.getString("type");
                        double amount = Double.parseDouble(tk.getString("amount"));

                        if (type.equals("Deposit")) {
                            balance += amount;
                        } else if (type.equals("Withdrawal")) {
                            balance -= amount;
                        }
                    }

                    // Check if the withdrawal amount exceeds the balance
                    if (withdrawalAmount > balance) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        return;
                    }

                    // Update the database with the withdrawal
                    String query = "INSERT INTO bank VALUES('" + pinnumber + "', CURRENT_TIMESTAMP, 'Withdrawal', '" + withdrawalAmount + "')";
                    conn.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Tk " + withdrawalAmount + " Withdrawn Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}