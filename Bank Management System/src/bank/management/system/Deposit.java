package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
        
    JLabel image, text;
    JTextField amount;
    JButton deposit, back;
    String pinno;
    Deposit(String pinno){
    this.pinno = pinno;
    setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Enter  the amout you want too deposit");
        image.add(text);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(230,350,200,25);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(amount);
    
        deposit =new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back =new JButton("back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
    
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true); 
}
       public void actionPerformed(ActionEvent ae){
           if (ae.getSource() == deposit){
               String  number  = amount.getText();
               Date date = new Date();
               if(number .equals("")){
                   JOptionPane.showMessageDialog(null,"Please Enter the amount you want to deposit");
               }else{
                   try{
                   Conn conn = new Conn();
                   String querry = "insert into bank values('"+pinno+"','"+date+"','Deposit','"+number+"')";
                   conn.s.executeUpdate(querry);
                   JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
                   setVisible(false);
                   new Transactions(pinno).setVisible(true);
                   }catch(Exception e){
                       System.out.println(e);
                  }
               }
               
           }else if (ae.getSource() == back){
               setVisible(false);
               new Transactions(pinno).setVisible(true);
           }
       }
  
    public static void main(String args[]) {
        // TODO code application logic here
        new Deposit("");
    }
}
