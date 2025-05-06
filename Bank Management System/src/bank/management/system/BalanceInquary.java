package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.*;

public class BalanceInquary extends JFrame implements ActionListener{

    String pinno;
    JLabel image, text, baltext;
    JButton back;
    BalanceInquary(String pinno){
    this.pinno = pinno;
          
       setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back =new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
       
            Conn conn = new Conn();
            int balance = 0 ; 
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinno+"'");
                
                while(rs.next()){// each and every row in bank table, jisme required pin no he wo loop me aayega
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                } catch(Exception e){
                      System.out.println(e);
                }
        
                baltext = new JLabel("Your Current Account balance is Rs "+ balance);
                baltext.setBounds(170,300,400,30);
                baltext.setForeground(Color.WHITE);
                image.add(baltext);
               
                
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true); 
    }
    
    public static void main(String args[]) {
       new BalanceInquary("");
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
    }
}
