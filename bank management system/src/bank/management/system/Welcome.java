package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome extends JFrame implements ActionListener {

    JButton aboutProjectButton, aboutDevelopersButton, continueToLoginButton;
    JLabel imageLabel;

    Welcome() {
        setLayout(null); // Layout set to null for custom placement

        // Set title for the frame
        setTitle("Welcome Screen");
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/welcome.jpg"));
        Image i2 = i1.getImage().getScaledInstance(735, 490, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 735, 490);
        add(image);

        // Load the .jpg image from the file system
       

        // Create and configure the "About Project" button
        aboutProjectButton = new JButton("About Project");
        aboutProjectButton.setFont(new Font("Raleway", Font.BOLD, 14));
        aboutProjectButton.addActionListener(this);
        aboutProjectButton.setBackground(Color.blue);
        aboutProjectButton.setForeground(Color.white);
        
        aboutProjectButton.setOpaque(true);
        aboutProjectButton.setFocusPainted(false);
        aboutProjectButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); // Rounded border
        
        aboutProjectButton.setBounds(510, 54, 190, 40); // Adjusted to be higher (y = 170)
        add(aboutProjectButton); // Add button directly to the frame

        // Create and configure the "About Developers" button
        aboutDevelopersButton = new JButton("About Developers");
        aboutDevelopersButton.setFont(new Font("Raleway^", Font.BOLD, 14));
        aboutDevelopersButton.addActionListener(this);
         aboutDevelopersButton.setBackground(Color.blue);
        aboutDevelopersButton.setForeground(Color.white);
        aboutDevelopersButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        aboutDevelopersButton.setBounds(510,115 , 190, 40); // Adjusted to be higher (y = 230)
        add(aboutDevelopersButton); // Add button directly to the frame

        // Create and configure the "Continue to Login" button
        continueToLoginButton = new JButton("Continue to Login");
        continueToLoginButton.setFont(new Font("Arial", Font.BOLD, 14));
        continueToLoginButton.addActionListener(this);
        continueToLoginButton.setBackground(Color.blue);
        continueToLoginButton.setForeground(Color.white);
        continueToLoginButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        continueToLoginButton.setBounds(510, 175, 190, 40); // Adjusted to be higher (y = 290)
        add(continueToLoginButton); // Add button directly to the frame

        // Frame settings
        setSize(735, 490); // Set the frame size to 500x500
        setLocation(300, 150); // Set the frame's location on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on window close
        setVisible(true); // Make the window visible
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == aboutProjectButton) {
            // Display About Project info in a popup
            JOptionPane.showMessageDialog(this, "This is a bank management system project built using Java.\n"
                    + "It allows users to perform various banking transactions such as deposits, withdrawals, and balance inquiries.");
        } else if (ae.getSource() == aboutDevelopersButton) {
            // Display About Developers info in a popup
            JOptionPane.showMessageDialog(this, "Developed by:\n"
                    + "1. Md. Ashif Mahmud Kayes. Studies in department of Computer Science and Engineering at the University of Dhaka.\n"
                    + "2. Swapon Chandra Roy. Studies in department of Computer Science and Engineering at the University of Dhaka.");
        } else if (ae.getSource() == continueToLoginButton) {
            // Open the login screen (assuming Login class exists)
            setVisible(false); // Hide the current frame
            new Login(); // Assuming you have a Login class
        }
    }

    public static void main(String[] args) {
        new Welcome(); // Show the Welcome screen
    }
}
