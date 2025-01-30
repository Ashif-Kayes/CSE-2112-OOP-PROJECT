package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class FastCash extends JFrame implements ActionListener{
   JButton deposit,withdrawal,ministatement,pinchange,fastcash,balanceenquiry,exit;
   String pinnumber;

    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
       
       
        add(image);
       
        JLabel text=new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(210,300,700,35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
       
         deposit=new JButton("Tk 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
       
        withdrawal=new JButton("Tk 500");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
       
         fastcash=new JButton("Tk 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
       
         ministatement=new JButton("Tk 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
       
         pinchange=new JButton("Tk 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
       
         balanceenquiry=new JButton("Tk 10000");
        balanceenquiry.setBounds(355,485,150,30);
       balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
       
        exit=new JButton("BACK");
        exit.setBounds(355,520,150,30);
       exit.addActionListener(this);
        image.add(exit);
       
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
       
       
    }
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()== exit){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }else{
          String amount=((JButton)ae.getSource()).getText().substring(3); // Rs 500
          Conn c=new Conn();
          try{
             ResultSet tk= c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
             double balance =0;
             while(tk.next()){
                if(tk.getString("type").equals("Deposit")){
                    balance+=Double.parseDouble(tk.getString("amount"));
                }else{
                    balance-= Double.parseDouble(tk.getString("amount"));
                }
             }
             if(ae.getSource()!= exit && balance< Double.parseDouble(amount)){
              JOptionPane.showMessageDialog(null,"Insufficient Balance");
              return;
             }
             
             
             String query="insert into bank values('"+pinnumber+"', CURRENT_TIMESTAMP, 'Withdrawal', '"+amount+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Tk " +amount+ "Debited Successfully");
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
             
             
         }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
                }
          catch(Exception e){
             System.out.println(e);
         }
    }
  }

   
    public static void main(String [] args){
        new FastCash("");
    }
   
}
