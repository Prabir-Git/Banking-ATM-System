package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.sql.*;

public class MiniStatement  extends JFrame{

    String pinno;
    MiniStatement(String pinno){
        
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        
        this.pinno=pinno;
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
                
        JLabel bank = new JLabel("SBI Bank");
        bank.setBounds(130,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,180,400,20);
        add(balance);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinno+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardNumber").substring(0, 4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }   
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            Conn conn = new Conn();
             int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinno+"'");
            while(rs.next()){
               mini.setText(mini.getText() + "<html>" +rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br></html>");
        if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            balance.setText("Your current account balance is Rs "+ bal);
        }
            }
            catch(Exception e){
            System.out.println(e);
        }  
        setSize(400,600);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLocation(20,20);
    }
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
