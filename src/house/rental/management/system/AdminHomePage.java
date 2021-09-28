package house.rental.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AdminHomePage {
    AdminHomePage() {
        JFrame homePage = new JFrame("Admin Home Page");        
        JLabel welcome = new JLabel("Welcome Admin");
        JButton tenantDetails = new JButton("Tenant Details");
        JButton customerApplications = new JButton("Applications");
        JButton houseRecords = new JButton("House records");
        JButton logOut = new JButton("Log out");
        //Positioning
        customerApplications.setToolTipText("Applications of new Customers can be seen here");
        welcome.setBounds(240, 70, 400, 40);
        tenantDetails.setBounds(250, 150, 200, 40);
        customerApplications.setBounds(250, 220, 200, 40);
        houseRecords.setBounds(250, 290, 200, 40);
        logOut.setBounds(250, 360, 200, 40);
        
        //Functioning
        //Editing
        Color buttonColor = new Color(150, 150, 150);
        Color frameColor = new Color(50, 50, 50);
        Color txtColor = new Color(255, 255, 255);
        Font titleFont = new Font("Serif",Font.BOLD,30);
        Font buttonFont = new Font("Serif",Font.ROMAN_BASELINE,25);
        homePage.getContentPane().setBackground(frameColor);
        welcome.setFont(titleFont);
        welcome.setForeground(Color.GREEN);
        tenantDetails.setFont(buttonFont);
        tenantDetails.setBackground(buttonColor);
        tenantDetails.setForeground(txtColor);
        customerApplications.setFont(buttonFont);
        customerApplications.setBackground(buttonColor);
        customerApplications.setForeground(txtColor);
        houseRecords.setFont(buttonFont);
        houseRecords.setBackground(buttonColor);
        houseRecords.setForeground(txtColor);
        logOut.setFont(buttonFont);
        logOut.setBackground(buttonColor);
        logOut.setForeground(txtColor);
        
        tenantDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new TenantDetails();
            }            
        });
        customerApplications.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Sorry, Not Implemented Yet");
            }            
        });
        houseRecords.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new ShowHouse();
            } 
        });
        logOut.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                homePage.dispose();
            } 
        });
        
        homePage.add(welcome);
        homePage.add(customerApplications);
        homePage.add(tenantDetails);
        homePage.add(houseRecords);
        homePage.add(logOut);
        
        homePage.setLayout(null);
        homePage.setVisible(true);
        homePage.setBounds(200, 150, 700, 500);
        homePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
