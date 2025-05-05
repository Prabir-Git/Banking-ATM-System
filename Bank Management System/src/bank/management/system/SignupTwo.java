package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    JLabel additionalDetails, religion, category, income, edu, qualification, occu, pan, adh, senCiti, existAcc;
    JTextField panTf, adharTf;
    JRadioButton syes, sno, eyes, eno;
    ButtonGroup scnCitizenGroup, existAccGroup;
    JButton next, back;
    JComboBox<String> religionjb, categoryjb, occujb, edujb, incomejb;
    String formno;

    SignupTwo(String formNo) {
        this.formno= formNo;
        setLayout(null);
        setTitle("NEW ACCOUNT FORM PAGE-2");

        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String[] valueOfReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionjb = new JComboBox<>(valueOfReligion);
        religionjb.setBounds(300, 140, 400, 30);
        religionjb.setBackground(Color.WHITE);
        add(religionjb);

        category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String[] valueOfCategory = {"General", "OBC", "SC", "ST", "Other"};
        categoryjb = new JComboBox<>(valueOfCategory);
        categoryjb.setBounds(300, 190, 400, 30);
        categoryjb.setBackground(Color.WHITE);
        add(categoryjb);

        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String[] valueOfIncome = {"null", "<1,50,000", "<2,50,000", "<5,00,000", "upto 10,00,000"};
        incomejb = new JComboBox<>(valueOfIncome);
        incomejb.setBounds(300, 240, 400, 30);
        incomejb.setBackground(Color.WHITE);
        add(incomejb);

        edu = new JLabel("Educational:");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);

        qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 320, 200, 30);
        add(qualification);

        String[] valueOfEducation = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        edujb = new JComboBox<>(valueOfEducation);
        edujb.setBounds(300, 315, 400, 30);
        edujb.setBackground(Color.WHITE);
        add(edujb);

        occu = new JLabel("Occupation:");
        occu.setFont(new Font("Raleway", Font.BOLD, 20));
        occu.setBounds(100, 390, 200, 30);
        add(occu);

        String[] valueOfOccupation = {"Salaried", "Self-Employed", "Entrepreneur", "Student", "Retired", "Other"};
        occujb = new JComboBox<>(valueOfOccupation);
        occujb.setBounds(300, 395, 400, 30);
        occujb.setBackground(Color.WHITE);
        add(occujb);

        pan = new JLabel("PAN No:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panTf = new JTextField();
        panTf.setFont(new Font("Raleway", Font.BOLD, 14));
        panTf.setBounds(300, 440, 400, 30);
        add(panTf);

        adh = new JLabel("Aadhar no:");
        adh.setFont(new Font("Raleway", Font.BOLD, 20));
        adh.setBounds(100, 490, 200, 30);
        add(adh);

        adharTf = new JTextField();
        adharTf.setFont(new Font("Raleway", Font.BOLD, 14));
        adharTf.setBounds(300, 490, 400, 30);
        add(adharTf);

        senCiti = new JLabel("Senior Citizen:");
senCiti.setFont(new Font("Raleway", Font.BOLD, 20));
senCiti.setBounds(100, 540, 200, 30); // Correctly positioned
add(senCiti);

// Radio buttons for Senior Citizen
syes = new JRadioButton("Yes");
syes.setBounds(300, 540, 100, 30); // Adjusted width for better visibility
syes.setBackground(Color.WHITE);
add(syes);

sno = new JRadioButton("No");
sno.setBounds(470, 540, 100, 30); // Adjusted positioning
sno.setBackground(Color.WHITE);
add(sno);

// Grouping the radio buttons for Senior Citizen
scnCitizenGroup = new ButtonGroup();
scnCitizenGroup.add(syes);
scnCitizenGroup.add(sno);


        existAcc = new JLabel("Existing Account:");
        existAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        existAcc.setBounds(100, 590, 200, 30);
        add(existAcc);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 60, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(470, 590, 120, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        existAccGroup = new ButtonGroup();
        existAccGroup.add(eyes);
        existAccGroup.add(eno);

        back = new JButton("cancel");
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

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Login().setVisible(true);
        } else if (ae.getSource() == next) {
            String religion = (String) religionjb.getSelectedItem();
            String category = (String) categoryjb.getSelectedItem();
            String income = (String) incomejb.getSelectedItem();
            String education = (String) edujb.getSelectedItem();
            String occupation = (String) occujb.getSelectedItem();
            String seniorCitizen = syes.isSelected() ? "Yes" : "No";
            String existingAccount = eyes.isSelected() ? "Yes" : "No";
            String pan = panTf.getText();
            String adhar = adharTf.getText();

            try {
                if (pan.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "PAN number is required.");
                } else if (adhar.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Aadhar number is required.");
                } else {
                    Conn c = new Conn();
                    String query = "INSERT INTO signupTwo (formno, religion, catagory, income, education, occupation, seniorCitizen, existingAccount, pan, adhar) " +
                                   "VALUES ('" + formno + "','" + religion + "', '" + category + "', '" + income + "', '" + education + "', '" + occupation + "', '" +
                                   seniorCitizen + "', '" + existingAccount + "', '" + pan + "', '" + adhar + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
                    setVisible(false);
                    new SignupThree(formno).setVisible(true);
                   // new SignupThree().setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
