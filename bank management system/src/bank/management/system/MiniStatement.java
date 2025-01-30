package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JTextArea statement = new JTextArea();
        statement.setFont(new Font("Monospaced", Font.PLAIN, 14));
        statement.setEditable(false);

        JScrollPane scroll = new JScrollPane(statement);
        scroll.setBounds(100, 250, 700, 300);
        image.add(scroll);

        try {
            Conn conn = new Conn();
            double balance = 0;
            ResultSet tk = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            statement.append("\tDate\t\t Type\t\t\tAmount\t\tBalance\n");
            statement.append("-----------------------------------------------------------------------------\n");

            while (tk.next()) {
                String date = tk.getString("date");
                String type = tk.getString("type");
                double amount = Double.parseDouble(tk.getString("amount"));

                if (type.equals("Deposit")) {
                    balance += amount;
                } else if (type.equals("Withdrawal")) {
                    balance -= amount;
                }

                statement.append(date + "\t" );
                if(type.equals("Deposit")){    
                    statement.append(type + "\t\t\t" );
                }else if(type.equals("Withdrawal")){
                    statement.append(type + "\t\t" );
                }
                statement.append(amount + "\t\t"+balance+"\n" );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(355, 600, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MiniStatement(""); // Test with a dummy pin number
    }
}
