package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    
    Long rn;
    
    JLabel          formno, personDetails, name, fname, dob, 
                    gender, email, marital ,address,city,state,
                    pincode; 
    JTextField      nameTf, fnameTf, emailTf,addressTf,
                    cityTf, stateTf, pinTf;
    JDateChooser    dateChoose;
    JRadioButton    male, female, other , married, unmarried , othermarsts; 
    ButtonGroup     gendergrp, maritalStsGrp; 
    
    JButton         next, back;
    
    
    SignupOne(){
         
        setLayout(null);
        
        
        Random ran = new Random();
        rn = Math.abs((ran.nextLong()%9000L) + 1000L);
        
        
        formno = new JLabel("APPLICATION FORM NO. " + rn) ;
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        personDetails = new JLabel("Page 1: Person Details ") ;
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290,80,400,30); 
        add(personDetails);
        
        name = new JLabel("Name: ") ;
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30); 
        add(name);
        
        nameTf = new JTextField();
        nameTf.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTf.setBounds(300, 140,400,30);
        add(nameTf);
        
        fname = new JLabel("Father's Name: ") ;
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30); 
        add(fname);
        
        fnameTf = new JTextField();
        fnameTf.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTf.setBounds(300, 190,400,30);
        add(fnameTf);
        
        dob = new JLabel("Date of Birth: ") ;
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30); 
        add(dob);
        
        dateChoose = new JDateChooser();
        dateChoose.setBounds(300,240,400,30);
        dateChoose.setForeground(new Color(105, 105, 105));
        add(dateChoose);
        
        gender = new JLabel("Gender: ") ;
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30); 
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30); 
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(470,290,120,30); 
        female.setBackground(Color.white);
        add(female);
        
        other = new JRadioButton("Others");
        other.setBounds(620,290,180,30); 
        other.setBackground(Color.white);
        add(other);
        
        gendergrp = new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);
        gendergrp.add(other);
        
        
        email = new JLabel("Email Address: ") ;
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30); 
        add(email);
        
        emailTf = new JTextField();
        emailTf.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTf.setBounds(300, 340,400,30);
        add(emailTf);
        
        marital = new JLabel("Marital Status: ") ;
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30); 
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,60,30); 
        married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(470,390,120,30); 
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        othermarsts = new JRadioButton("Others");
        othermarsts.setBounds(620,390,180,30); 
        othermarsts.setBackground(Color.white);
        add(othermarsts);
        
        maritalStsGrp = new ButtonGroup();
        maritalStsGrp.add(married);
        maritalStsGrp.add(unmarried);
        maritalStsGrp.add(othermarsts);
        
        
        address = new JLabel("Address: ") ;
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30); 
        add(address);
        
        addressTf = new JTextField();
        addressTf.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTf.setBounds(300, 440,400,30);
        add(addressTf);
        
        
        city = new JLabel("City: ") ;
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30); 
        add(city);
        
        cityTf = new JTextField();
        cityTf.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTf.setBounds(300, 490,400,30);
        add(cityTf);
        
        state = new JLabel("State: ") ;
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30); 
        add(state);
        
        stateTf = new JTextField();
        stateTf.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTf.setBounds(300, 540,400,30);
        add(stateTf);
        
        pincode = new JLabel("Pin Code: ") ;
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30); 
        add(pincode);
        
        pinTf = new JTextField();
        pinTf.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTf.setBounds(300, 590,400,30);
        add(pinTf);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(100, 660, 80, 30);
        back.addActionListener(this);
        add(back);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        //**********NO chhedkani************
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
    }
    //*********************************************************************
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==back){
            setVisible(false);
            new Login().setVisible(true);
        }else if(ae.getSource()==next){
        
        String formno = ""+ rn;//long
        String name = nameTf.getText();
        String fname = fnameTf.getText();
        String dob =((JTextField)dateChoose.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "male";
        }else if (female.isSelected()){
            gender = "female";
        }else if (other.isSelected()){
            gender = "Other";
        }
        
        String email = emailTf.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
        marital = "UnMarried";
        }else if(other.isSelected()){
        marital = "Other";
        }
        
        String addres = addressTf.getText();
        String city = cityTf.getText();
        String state = stateTf.getText();
        String pincode = pinTf.getText();
        
        try {
    if (name.equals("")) {
        JOptionPane.showMessageDialog(null, "Name is required");
    } else if (fname.equals("")) {
        JOptionPane.showMessageDialog(null, "Father's Name is required");
    } else if (dob.equals("")) {
        JOptionPane.showMessageDialog(null, "Date of Birth is required");
    } else if (!male.isSelected() && !female.isSelected() && !other.isSelected()) {
        JOptionPane.showMessageDialog(null, "Gender is required");
    } else if (email.equals("")) {
        JOptionPane.showMessageDialog(null, "Email is required");
    } else if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
        JOptionPane.showMessageDialog(null, "Invalid Email Address");
    } else if (!married.isSelected() && !unmarried.isSelected() && !othermarsts.isSelected()) {
        JOptionPane.showMessageDialog(null, "Marital Status is required");
    } else if (addres.equals("")) {
        JOptionPane.showMessageDialog(null, "Address is required");
    } else if (city.equals("")) {
        JOptionPane.showMessageDialog(null, "City is required");
    } else if (state.equals("")) {
        JOptionPane.showMessageDialog(null, "State is required");
    } else if (pincode.equals("")) {
        JOptionPane.showMessageDialog(null, "Pin Code is required");
    } else if (!pincode.matches("\\d{6}")) { // Pincode must be 6 digits
        JOptionPane.showMessageDialog(null, "Invalid Pin Code. It should be 6 digits.");
    } else {
        Conn c = new Conn();
        String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + addres + "', '" + city + "', '" + pincode + "', '" + state + "')";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
        setVisible(false); // Optionally close the current window
        new SignupTwo(formno).setVisible(true);
    }
} catch (Exception e) {
    System.out.println(e);
}
        
 }
    }
   
    public static void main(String args[]) {
        
        new SignupOne();
    }
}
