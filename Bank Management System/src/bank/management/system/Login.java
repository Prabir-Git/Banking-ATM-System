package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
        JLabel label;
        JLabel text;
        JLabel cardNo;
        JLabel pin;
        
        JButton login;
        JButton clear;
        JButton signup;
        
        
        JTextField cardTextField;
        JPasswordField pinTextField;
        
    
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        
        
        label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        
        cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD,28));
        cardNo.setBounds(120,150,150,30);
        add(cardNo);
        //text area
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        //for text area
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        //Login Buttons
        login = new JButton ("Sign in");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        //Clear Buttons
        clear = new JButton ("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
         //Clear Buttons
        signup = new JButton ("Sign up");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
         
          // for background      
         getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(550,200);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== login){
            Conn conn = new Conn();
            String cardnum = cardTextField.getText();
            String pinno = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnum+"' and pin = '"+ pinno+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorect Card Number or, pin");
                }
            }catch(Exception e){
                
            }
        } else if(ae.getSource()== signup){
            
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }else if (ae.getSource() == clear){
            
            cardTextField.setText("");
            pinTextField.setText("");
             
        }
    }
    
}
//demo card number - 5040936056584021 || pin - 5555
