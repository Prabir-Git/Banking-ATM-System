
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener{

    JLabel cdetails, l1, type, card,pnumber ,cnumber,pin, pdetails, services ;
    JRadioButton r1,r2,r3,r4 ; 
    ButtonGroup grpAcc;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel; 
    String formno;
    SignupThree(String formno){
        setLayout(null);
        this.formno= formno;
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        type = new JLabel("Accout Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16)); 
        r1.setBounds(100,180,150,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16)); 
        r2.setBounds(350,180,250,20);
        add(r2);
        
        r3 = new JRadioButton("current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16)); 
        r3.setBounds(100,220,150,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16)); 
        r4.setBounds(350,220,250,20);
        add(r4);
        
        grpAcc = new ButtonGroup();
        grpAcc.add(r1);
        grpAcc.add(r2);
        grpAcc.add(r3);
        grpAcc.add(r4);
        
        //card number 
        
        card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,300,200,30);
        add(card);

        cnumber = new JLabel("XXXX-XXXX-6947");
        cnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cnumber.setBounds(330,300,300,30);
        add(cnumber);
        
        cdetails = new JLabel("Your 16 Digit Card Number");
        cdetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cdetails.setBounds(100,330,300,20);
        add(cdetails);
        
        pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin .setBounds(100,370,200,30);
        add(pin);

        pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
        
        pdetails = new JLabel("Your 4 Digit password");
        pdetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pdetails.setBounds(100,400,300,20);
        add(pdetails);
        
        services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services .setBounds(100,450,400,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1 .setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2 .setBounds(350,500,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3 .setBounds(100,550,200,30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4 .setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5 .setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("Estatement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6 .setBounds(350,600,200,30);
        add(c6);
        
        c7 = new JCheckBox("I declare that the above entered details are correct");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7 .setBounds(100,680,600,30);
        add(c7);
        
        submit = new JButton ("Submit"); 
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit .setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton ("Cancel"); 
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel .setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        //****************************************************
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType  = "";
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if(r2.isSelected()){
                accountType = "Fixed Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }else if(r4.isSelected()){
                accountType = "Recurring Deposite Account";
            } 
            
            Random random = new Random();
            String cardnum = "" + Math.abs ((random.nextLong() %90000000L) + 5040936000000000L);
            String pinnum = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(c1.isSelected()) facility = facility + " ATM Card";
            if(c2.isSelected()) facility = facility + " Internet Banking";
            if(c3.isSelected()) facility = facility + " Mobile Banking";
            if(c4.isSelected()) facility = facility + " Email & Sms Alert";
            if(c5.isSelected()) facility = facility + " Cheque Book";
            if(c6.isSelected()) facility = facility + " E-statement";

            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "AccountType is Required");
                }else if (!c7.isSelected()){
                    JOptionPane.showMessageDialog(null, "Click on the declare chekBox");
                    setVisible(true);
                }
                else{
                    System.out.println(pin);
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnum+"','"+pinnum+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnum+"','"+pinnum+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnum + "\n Pin: " + pinnum);
                    setVisible(false);
                    new Deposit(pinnum).setVisible(true);
                }
                
                
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
   
    public static void main(String args[]) {
        new SignupThree("");
    }
}
