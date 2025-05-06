package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
    
    JLabel image, text, pin, rpin;
    JTextField pintext, rpintext;
    JButton change, back;
    String pinno;
    
    PinChange(String pinno){
        this.pinno= pinno;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250,280,500,35);
        image.add(text);
        
        pin = new JLabel("New PIN:");
        pin.setForeground(Color.WHITE);
        pin.setFont(new Font("System", Font.BOLD, 16));
        pin.setBounds(165,320,180,25);
        image.add(pin);
        
        pintext = new JPasswordField();
        pintext.setBounds(330,320,180,25);
        pintext.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(pintext);
        
        rpin = new JLabel("Re-Enter New PIN:");
        rpin.setForeground(Color.WHITE);
        rpin.setFont(new Font("System", Font.BOLD, 16));
        rpin.setBounds(165,360,180,25);
        image.add(rpin);
        
        rpintext = new JPasswordField();
        rpintext.setBounds(330,360,180,25);
        rpintext.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(rpintext);
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true); 
    }
    
   
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change){
        try{
            String npin = pintext.getText();
            String rpin = rpintext.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            } 
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter New PIN");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Re-Enter PIN");
               return;
            }
            Conn conn = new Conn();
            String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinno+"'";
             String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinno+"'";
              String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinno+"'";
              
              conn.s.executeUpdate(q1);
              conn.s.executeUpdate(q2);
              conn.s.executeUpdate(q3);
              
              JOptionPane.showMessageDialog(null,"PIN Changed Sucsessfuly");
              setVisible(false);
              new Transactions(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        }else{
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
    }
  
    public static void main(String args[]) {
       new PinChange("").setVisible(true);
    }   
}
