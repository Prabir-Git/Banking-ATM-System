package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    JLabel text , image;
    JButton r100,r500 , r1000, r2000, r5000, r10000, back ;       
       String pinno;     
            
    FastCash(String pinno){
        this.pinno = pinno;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Please select withdrawl amount");
        text.setBounds(200,300,700,35);
        image.add(text);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        
        r100 =new JButton("100");
        r100.setBounds(170,415,150,30);
        r100.addActionListener(this);
        image.add(r100);
        
        r500 =new JButton("500");
        r500.setBounds(355,415,150,30);
        r500.addActionListener(this);
        image.add(r500);
        
        r1000 =new JButton("1000");
        r1000.setBounds(170,450,150,30);
        r1000.addActionListener(this);
        image.add(r1000);
        
        r2000 =new JButton("2000");
        r2000.setBounds(355,450,150,30);
        r2000.addActionListener(this);
        image.add(r2000);
        
        
        r5000 =new JButton("5000");
        r5000.setBounds(170,485,150,30);
        r5000.addActionListener(this);
        image.add(r5000);       
        
        r10000 =new JButton("10000");
        r10000.setBounds(355,485,150,30);
        r10000.addActionListener(this);
        image.add(r10000);
        
        back =new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }else{
            String amount =((JButton)ae.getSource()).getText();
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinno+"'");
                int balance = 0 ; 
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
                    
                }
                
                Date date = new Date();
                String querry = "insert into bank value('"+pinno+"','"+date+"','Withdrawl','"+amount+"')";
                conn.s.executeUpdate(querry);
                JOptionPane.showMessageDialog(null, "Debited Sucessfully");
                
                setVisible(false);
                new Transactions(pinno).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }           
    }
    public static void main(String args[]) {
       new FastCash("");
    }
}
