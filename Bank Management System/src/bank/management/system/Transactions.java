
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener{

    JLabel text , image;
    JButton deposit, withdrawl, fastcash, ministatement, pinChnage, balanceinq, exit ;       
       String pinno;     
            
    Transactions(String pinno){
        this.pinno = pinno;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Please select your Transaction");
        text.setBounds(200,300,700,35);
        image.add(text);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        
        deposit =new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl =new JButton("Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash =new JButton("Fast cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement =new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        
        pinChnage =new JButton("Pin Chnage");
        pinChnage.setBounds(170,485,150,30);
        pinChnage.addActionListener(this);
        image.add(pinChnage);       
        
        balanceinq =new JButton("Chek Balance");
        balanceinq.setBounds(355,485,150,30);
        balanceinq.addActionListener(this);
        image.add(balanceinq);
        
        exit =new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit) {
            System.exit(0);
        }else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinno).setVisible(true);
        }else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinno).setVisible(true);
         }else if (ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinno).setVisible(true);
         }else if (ae.getSource() == pinChnage){
            setVisible(false);
            new PinChange(pinno).setVisible(true);
         }else if (ae.getSource()== balanceinq){
             setVisible (false);
             new BalanceInquary(pinno).setVisible(true);
         }else if (ae.getSource()== ministatement){
           
             new MiniStatement(pinno).setVisible(true);
         }
    }
    public static void main(String args[]) {
       new Transactions("");
    }
}
