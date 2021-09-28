package house.rental.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HomePage {
    HomePage() { 
        //Creation
        JFrame homePage = new JFrame("Home Page");        
        JLabel title = new JLabel("House Rental Management System");
        JLabel welcome = new JLabel("WELCOME");
        JButton admin = new JButton("Owner");
        JButton tenant = new JButton("Tenant");
        JButton newCustomer = new JButton("New customer");
        //Positioning
        title.setBounds(130, 10, 700, 50);
        welcome.setBounds(270, 70, 200, 40);
        admin.setBounds(50, 150, 200, 40);
        tenant.setBounds(50, 220, 200, 40);
        newCustomer.setBounds(50, 290, 200, 40);
        
        //Functioning
        //Editing
        ImageIcon i1  = new ImageIcon("rent.jfif");
        JLabel l15 = new JLabel(i1);
        l15.setBounds(200, 30, 500, 600);
        homePage.add(l15);
        
        Color frameColor = new Color(50, 50, 50);
        Font titleFont = new Font("Serif",Font.BOLD,30);
        Color buttonColor = new Color(150, 150, 150);
        Color txtColor = new Color(255, 255, 255);
        Font buttonFont = new Font("Serif",Font.ROMAN_BASELINE,25);
        homePage.getContentPane().setBackground(frameColor);
        title.setFont(titleFont);
        title.setForeground(Color.GREEN);
        welcome.setFont(titleFont);
        welcome.setForeground(Color.GREEN);
        admin.setFont(buttonFont);
        admin.setBackground(buttonColor);
        admin.setForeground(txtColor);
        tenant.setFont(buttonFont);
        tenant.setBackground(buttonColor);
        tenant.setForeground(txtColor);
        newCustomer.setFont(buttonFont);
        newCustomer.setBackground(buttonColor);
        newCustomer.setForeground(txtColor);
//        admin.setBackground(Color.BLACK);
//        admin.setBackground(Color.BLACK);
         //Adding
        homePage.add(title);
        homePage.add(welcome);
        homePage.add(tenant);
        homePage.add(admin);
        homePage.add(newCustomer);
        
        admin.addActionListener((ActionEvent ae) -> {
            new AdminLogin();            
        });
        tenant.addActionListener((ActionEvent ae) -> {
            homePage.dispose();
            new TenantLogin();            
        });
        newCustomer.addActionListener((ActionEvent ae) -> {
            homePage.dispose();
            new ShowAvailableHouse(); 
        });
        
        homePage.setLayout(null);
        homePage.setVisible(true);
        homePage.setBounds(200, 150, 700, 500);
        homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {        
        new HomePage();
    }  
}

