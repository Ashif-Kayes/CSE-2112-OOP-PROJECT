package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

   
    JTextField bcnText,nidText;
    JButton next,back;
    JRadioButton syes, sno, eyes, eno;
   
    JComboBox religion, category, occupation, education, income;
    String formno;
    SignupTwo(String formno) {
        // Set null layout for manual positioning
        this.formno=formno;
        setLayout(null);
       
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
       
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
       
       
        // Create and configure JLabel for form number
       
       
        JLabel additionalDetails = new JLabel("Page 2:Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30); // Ensure bounds fit within the frame
        add(additionalDetails);
       
        JLabel name = new JLabel("Religion                   :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30); // Ensure bounds fit within the frame
        add(name);
        String valReligion[]={"Hindu", "Muslim", "Sikh", "Christian", "Other"};

         religion =new JComboBox(valReligion);
        religion.setBounds(320,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
         
       
        JLabel fname = new JLabel("Category                  :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30); // Ensure bounds fit within the frame
        add(fname);
       
        String valcategory[]={"General","OBC","SC","ST","Other"};
         category=new JComboBox(valcategory);
        category.setBounds(320,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
       
         
       
       JLabel incomeLabel = new JLabel("Income                     :");
       incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
       incomeLabel.setBounds(100, 240, 200, 30); // Correct bounds for "Income" label
        add(incomeLabel);

        String incomeCategory[] = {"NULL", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(320, 240, 400, 30); // Correct bounds for "Income" dropdown
        income.setBackground(Color.WHITE);
        add(income);


         
       
       JLabel educationLabel = new JLabel("Educational Status :");
educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
educationLabel.setBounds(100, 340, 200, 30); // Adjusted position
add(educationLabel);

      String educationValues[] = {"Non-Graduation", "Graduate", "Post-Graduation", "Doctorate", "Others"};
       education = new JComboBox(educationValues);
      education.setBounds(320, 340, 400, 30); // Adjusted position
      education.setBackground(Color.WHITE);
      add(education);

       
        JLabel marital = new JLabel("Occupation              :");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30); // Ensure bounds fit within the frame
        add(marital);
       
        String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired","Others"};
       occupation = new JComboBox(occupationValues);
      occupation.setBounds(320, 390, 400, 30); // Adjusted position
      occupation.setBackground(Color.WHITE);
      add(occupation);
         
         
         
       
       
       
        JLabel bcn = new JLabel("Birth Certificate No :" );
        bcn.setFont(new Font("Raleway", Font.BOLD, 20));
        bcn.setBounds(100, 440, 200, 30);
        add(bcn);
        bcnText =new JTextField();
        bcnText.setFont(new Font("Raleway",Font.BOLD,14));
        bcnText.setBounds(320,440,400,30);
        add(bcnText);
       
       JLabel chBcn=new JLabel("*");
       chBcn.setForeground(Color.red);
       chBcn.setBounds(90,445,5,10);
       add(chBcn);
       
       
        JLabel nid = new JLabel("NID Number             :");
        nid.setFont(new Font("Raleway", Font.BOLD, 20));
        nid.setBounds(100, 490, 200, 30);
        add(nid);
        nidText =new JTextField();
        nidText.setFont(new Font("Raleway",Font.BOLD,14));
        nidText.setBounds(320,490,400,30);
        add(nidText);
       
        JLabel chNid=new JLabel("*");
       chNid.setForeground(Color.red);
       chNid.setBounds(90,495,5,10);
       add(chNid);
       
       
        JLabel state = new JLabel("Senior Citizen          :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30); // Ensure bounds fit within the frame
        add(state);
          syes=new JRadioButton("Yes");
          syes.setBounds(320,540,100,30);
          syes.setBackground(Color.WHITE);
          add(syes);
         
        sno=new JRadioButton("No");
          sno.setBounds(480,540,100,30);
          sno.setBackground(Color.WHITE);
          add(sno);
         
          ButtonGroup maritalgroup=new ButtonGroup();
          maritalgroup.add(syes);
          maritalgroup.add(sno);
       
        JLabel pincode = new JLabel("Existing Account     :");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30); // Ensure bounds fit within the frame
        add(pincode);
          eyes=new JRadioButton("Yes");
          eyes.setBounds(320,590,100,30);
          eyes.setBackground(Color.WHITE);
          add(eyes);
         
        eno=new JRadioButton("No");
          eno.setBounds(480,590,100,30);
          eno.setBackground(Color.WHITE);
          add(eno);
         
          ButtonGroup emaritalgroup=new ButtonGroup();
          emaritalgroup.add(eyes);
          emaritalgroup.add(eno);
       
         next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
       
         back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setBounds(100,660,80,30);
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
            new SignupOne().setVisible(true);
        }else{
       
            String sreligion=(String)religion.getSelectedItem();
            String scategory=(String)category.getSelectedItem();
            String sincome =(String)income.getSelectedItem();
            String seducation=(String)education.getSelectedItem();
            String soccupation=(String)occupation.getSelectedItem();
            String seniorcitizen=null;

            if(syes.isSelected()){
                seniorcitizen="Yes";
            }else if(sno.isSelected()){
                seniorcitizen="No";
            }

            String existingaccount=null;
            if(eyes.isSelected()){
                existingaccount="Yes";
            }else if(eno.isSelected()){
                existingaccount="No";
            }
            String sbcn=bcnText.getText();
            String  snid=nidText.getText();


            try{
                    if(sbcn.equals("")){
                    JOptionPane.showMessageDialog(null,"Birth Certificate No is Required");
                }else if(snid.equals("")){
                    JOptionPane.showMessageDialog(null,"NID number is Required");
                } else{
                    Conn c=new Conn();
                    String query="insert into signuptwo values ('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+sbcn+"', '"+snid+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                     c.s.executeUpdate(query);
                     //signup3 object
                     setVisible(false);
                     new SignupThree(formno).setVisible(true);
                }

            }catch(Exception e){
                System.out.println(e);
            }
        }
       
    }
   
    public static void main(String[] args) {
        new SignupTwo("");  
    }
}
