package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField,  mobileTextField,emailTextField, addressTextField, cityTextField, stateTextField, htTextField;
    JButton next,back;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    SignupOne() {
        // Set null layout for manual positioning
        setLayout(null);
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
       
       JLabel bank=new JLabel("Dhaka City Bank Limited");
        bank.setFont(new Font("Raleway",Font.BOLD,32));
        bank.setBounds(230,5,400,40);
        add(bank);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/city.jpg"));
        Image i2 = i1.getImage().getScaledInstance(125, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(85, 0, 100, 100);
        add(label);
        // Generate random application form number
        Random ran = new Random();
         random = Math.abs((ran.nextLong() % 9000L) + 1000L);
       
        // Create and configure JLabel for form number
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 25));
        formno.setBounds(240, 60, 600, 40); // Ensure bounds fit within the frame
        add(formno);
       
        JLabel personDetails = new JLabel("Page 1:Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 110, 400, 30); // Ensure bounds fit within the frame
        add(personDetails);
       
        JLabel name = new JLabel("NAME               :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 170, 200, 30); // Ensure bounds fit within the frame
        add(name);
         nameTextField =new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(290,170,400,30);
        add(nameTextField);
       
       JLabel chName=new JLabel("*");
       chName.setForeground(Color.red);
       chName.setBounds(90,175,5,10);
       add(chName);
       
       
        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 215, 200, 30); // Ensure bounds fit within the frame
        add(fname);
          fnameTextField =new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(290,215,400,30);
        add(fnameTextField);
       
       
        JLabel dob = new JLabel("Date Of Birth    :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 260, 200, 30); // Ensure bounds fit within the frame
        add(dob);
        dateChooser=new JDateChooser();
        dateChooser.setBounds(290,260,400,30);
        dateChooser.setDateFormatString("dd-MM-yyyy");
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
       
        JLabel chDob=new JLabel("*");
       chDob.setForeground(Color.red);
       chDob.setBounds(90,265,5,10);
       add(chDob);
       
       
        JLabel gender = new JLabel("Gender             :");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 305, 200, 30); // Ensure bounds fit within the frame
        add(gender);
         male=new JRadioButton("Male");
        male.setBounds(290,305,60,30);
        male.setBackground(Color.WHITE);
        add(male);
       
         female=new JRadioButton("Female");
        female.setBounds(440,305,120,30);
        female.setBackground(Color.WHITE);
        add(female);
       
        other =new JRadioButton("Other");
         other.setBounds(590,305,120,30);
         other.setBackground(Color.WHITE);
         add(other);
       
        ButtonGroup gendergroup =new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
       
        JLabel mobile = new JLabel("Mobile Number :");
        mobile.setFont(new Font("Raleway", Font.BOLD, 20));
        mobile.setBounds(100, 350, 200, 30); // Ensure bounds fit within the frame
        add(mobile);
          mobileTextField =new JTextField();
        mobileTextField.setFont(new Font("Raleway",Font.BOLD,14));
        mobileTextField.setBounds(290,350,400,30);
        add(mobileTextField);
       
        JLabel chMobile=new JLabel("*");
       chMobile.setForeground(Color.red);
       chMobile.setBounds(90,355,5,10);
       add(chMobile);
       
 
       
        JLabel email = new JLabel("Email Address :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 400, 200, 30); // Ensure bounds fit within the frame
        add(email);
          emailTextField =new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(290,400,400,30);
        add(emailTextField);
       
       
        JLabel marital = new JLabel("Marital Status  :");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 445, 200, 30); // Ensure bounds fit within the frame
        add(marital);
          married=new JRadioButton("Married");
        married.setBounds(290,445,100,30);
        married.setBackground(Color.WHITE);
        add(married);
       
         unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(440,445,120,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
       
         other =new JRadioButton("Other");
         other.setBounds(590,445,120,30);
         other.setBackground(Color.WHITE);
         add(other);
         
          ButtonGroup martialgroup =new ButtonGroup();
        martialgroup.add(married);
        martialgroup.add(unmarried);
        martialgroup.add(other);
       
       
       
       
       
        JLabel address = new JLabel("Address           :" );
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 490, 200, 30); // Ensure bounds fit within the frame
        add(address);
          addressTextField =new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(290,490,400,30);
        add(addressTextField);
       
       
        JLabel city = new JLabel("City                   :");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 535, 200, 30); // Ensure bounds fit within the frame
        add(city);
          cityTextField =new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(290,535,400,30);
        add(cityTextField);
       
       
        JLabel state = new JLabel("Division           :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 580, 200, 30); // Ensure bounds fit within the frame
        add(state);
          stateTextField =new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(290,580,400,30);
        add(stateTextField);
       
       
        JLabel hometown = new JLabel("Home Town          :");
        hometown.setFont(new Font("Raleway", Font.BOLD, 20));
        hometown.setBounds(100, 625, 200, 30); // Ensure bounds fit within the frame
        add(hometown);
          htTextField =new JTextField();
        htTextField.setFont(new Font("Raleway",Font.BOLD,14));
        htTextField.setBounds(290,625,400,30);
        add(htTextField);
       
         next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,715,80,30);
        next.addActionListener(this);
        add(next);
       
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setBounds(100,715,80,30);
        back.addActionListener(this);
        add(back);
       
        JLabel end = new JLabel("© Dhaka City Bank PLC");
        end.setFont(new Font("Raleway", Font.BOLD, 7));
        end.setBounds(7, 740, 100, 30);
        add(end);

       
               
               
       
       
        // Set background color
        getContentPane().setBackground(Color.WHITE);
       
        // Configure frame
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back) {
            setVisible(false);
            new Login().setVisible(true);
        }else{
        String formno= ""+random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String mobile=mobileTextField.getText();
        String dob =((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }else if(other.isSelected()){
            gender="other";
        }
        String email=emailTextField.getText();
        String martial=null;
        if(married.isSelected()){
            martial="Married";
        }else if(unmarried.isSelected()){
            martial="Unmarried";
        }else if(other.isSelected()){
            martial="Other";
        }
        String address=addressTextField.getText();
        String  city=cityTextField.getText();
        String state=stateTextField.getText();
        String ht=htTextField.getText();
       
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date of Birth is Required");
               
            }else if (!isValidDate(dob)) {
                JOptionPane.showMessageDialog(null, "Invalid Date Format. Please select a valid date.");
                return;
            }
            else if(mobile.equals("")){
                JOptionPane.showMessageDialog(null,"Mobile Number is Required");
            } else if (!mobile.matches("\\d{11}")) {
        JOptionPane.showMessageDialog(null, "Invalid Mobile Number. It must be 11 digits.");
    }
            else{
                Conn c=new Conn();
                String query="insert into signup values ('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"','"+mobile+"', '"+email+"', '"+martial+"', '"+address+"', '"+city+"', '"+state+"', '"+ht+"')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new SignupTwo(formno).setVisible(true);
                 
            }
        }catch(Exception e){
            System.out.println(e);
        }
        }
       
    }
    public boolean isValidDate(String dob) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Adjust format if needed
    sdf.setLenient(false);
    try {
        Date date = sdf.parse(dob);
        return true;
    } catch (ParseException e) {
        return false;
    }
}
   
    public static void main(String[] args) {
        new SignupOne();
    }
 }