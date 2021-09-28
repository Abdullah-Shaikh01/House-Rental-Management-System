package house.rental.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class NewCustomerLogin {  
    NewCustomerLogin() {
        JFrame signUp = new JFrame("Sign up Page"); 
        
        Font labelFont = new Font("Roman", Font.PLAIN, 17);
        Color buttonColor = new Color(150, 150, 150);
        Color frameColor = new Color(50, 50, 50);
        Color txtColor = new Color(255, 255, 255);
        Font titleFont = new Font("Serif",Font.BOLD,20);

        ImageIcon i1  = new ImageIcon("room.jfif");
        Image image = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(image);
        JLabel l15 = new JLabel();
        l15.setIcon(i1);
        l15.setBounds(500, 50,700,420);
        signUp.add(l15);
        
        JLabel title = new JLabel("Enter the Details ");
        title.setBounds(210, 30, 200, 40);
        title.setFont(titleFont);
        title.setBackground(frameColor);
        title.setForeground(txtColor);
        signUp.add(title);
        
        JLabel l_fName = new JLabel("First Name(Username): ");
        l_fName.setBounds(80, 100, 200, 30);
        l_fName.setFont(labelFont);
        l_fName.setBackground(frameColor);
        l_fName.setForeground(txtColor);
        signUp.add(l_fName);

        JTextField tf_fName = new JTextField();
        tf_fName.setBounds(260, 100, 200, 30);
        tf_fName.setFont(labelFont);
        signUp.add(tf_fName);
        
        JLabel l_lName = new JLabel("Last Name : ");
        l_lName.setBounds(80, 140, 200, 30);
        l_lName.setFont(labelFont);
        l_lName.setBackground(frameColor);
        l_lName.setForeground(txtColor);
        signUp.add(l_lName);

        JTextField tf_lName = new JTextField();
        tf_lName.setBounds(260, 140, 200, 30);
        tf_lName.setFont(labelFont);
        signUp.add(tf_lName);
        
        JLabel l_phoneNumber = new JLabel("Phone Number : ");
        l_phoneNumber.setBounds(80, 200, 200, 30);
        l_phoneNumber.setFont(labelFont);
        l_phoneNumber.setBackground(frameColor);
        l_phoneNumber.setForeground(txtColor);
        signUp.add(l_phoneNumber);

        JTextField tf_phoneNumber = new JTextField();
        tf_phoneNumber.setBounds(260, 200, 200, 30);
        tf_phoneNumber.setFont(labelFont);
        signUp.add(tf_phoneNumber);
        
        JLabel l_emailID = new JLabel("Email ID : ");
        l_emailID.setBounds(80, 240, 200, 30);
        l_emailID.setFont(labelFont);
        l_emailID.setBackground(frameColor);
        l_emailID.setForeground(txtColor);
        signUp.add(l_emailID);

        JTextField tf_emailID = new JTextField();
        tf_emailID.setBounds(260, 240, 200, 30);
        tf_emailID.setFont(labelFont);
        signUp.add(tf_emailID);
        
        JLabel l_aadhar = new JLabel("Aadhar card No: ");
        l_aadhar.setBounds(80, 300, 300, 30);
        l_aadhar.setFont(labelFont);
        l_aadhar.setBackground(frameColor);
        l_aadhar.setForeground(txtColor);
        signUp.add(l_aadhar);

        JTextField tf_aadhar = new JTextField();
        tf_aadhar.setBounds(260, 300, 200, 30);
        tf_aadhar.setFont(labelFont);
        signUp.add(tf_aadhar);
        
        JLabel l_members = new JLabel("Number of members: ");
        l_members.setBounds(80, 340, 300, 30);
        l_members.setFont(labelFont);
        l_members.setBackground(frameColor);
        l_members.setForeground(txtColor);
        signUp.add(l_members);

        JTextField tf_members = new JTextField();
        tf_members.setBounds(260, 340, 200, 30);
        tf_members.setFont(labelFont);
        signUp.add(tf_members);
        
        JLabel l_houseNo = new JLabel("Enter House Number: ");
        l_houseNo.setBounds(80, 390, 300, 30);
        l_houseNo.setFont(labelFont);
        l_houseNo.setBackground(frameColor);
        l_houseNo.setForeground(txtColor);
        signUp.add(l_houseNo);

        JTextField tf_houseNo = new JTextField();
        tf_houseNo.setBounds(260, 390, 200, 30);
        tf_houseNo.setFont(labelFont);
        signUp.add(tf_houseNo);
        
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(140, 460, 100, 30);
        submitButton.setBackground(buttonColor);
        signUp.add(submitButton);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(280, 460, 100, 30);
        cancelButton.setBackground(buttonColor);
        signUp.add(cancelButton);

        signUp.getContentPane().setBackground(frameColor);
        signUp.setLayout(null);
        signUp.setVisible(true);
        signUp.setBounds(150, 100, 1050, 560);
        signUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //Functioning
        submitButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
                
                //To check wether any field is empty
                String fName = tf_fName.getText();
                String lName = tf_lName.getText();
                String phone = tf_phoneNumber.getText();
                String email = tf_emailID.getText();
                String aadhar_no = tf_aadhar.getText();
                if(fName.isEmpty() || lName.isEmpty() || phone.isEmpty() || email.isEmpty() || aadhar_no.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Please enter all details");
                    return;
                }
                String member = tf_members.getText();
                if(member.isEmpty() || !(member.matches("-?\\d+"))) {
                    JOptionPane.showMessageDialog(null,"Please Enter the number of members correctly");
                    return;
                }
                int members = Integer.parseInt(member);
                
                String houseNo = tf_houseNo.getText();
                if(houseNo.isEmpty() || !(houseNo.matches("-?\\d+"))) {
                    JOptionPane.showMessageDialog(null,"Please Enter the house number correctly");
                    return;
                }
                int number = Integer.parseInt(houseNo);
                
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/customer_details";
                    Connection conn = DriverManager.getConnection(url, "root", "root");
                    System.out.println("Connection established");
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer_details (firstName, lastName, phone, emailID, aadhar_no, number_of_members, House_number) VALUES (?, ?, ?, ?, ?, ?, ?)");                    
                    stmt.setString(1, fName);
                    stmt.setString(2, lName);
                    stmt.setString(3, phone);
                    stmt.setString(4, email);
                    stmt.setString(5, aadhar_no);
                    stmt.setInt(6, members);
                    stmt.setInt(7, number);
                    stmt.executeUpdate();
                    ResultSet rs = stmt.executeQuery("SELECT id FROM customer_details ORDER BY id DESC LIMIT 1");
                    while(rs.next()) {
                         Class.forName("com.mysql.cj.jdbc.Driver");
                         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/house", "root", "root");
                         int customerId = rs.getInt(1);
                         System.out.println("Customer id is "+ customerId);
                         stmt = conn.prepareStatement("UPDATE house_details SET Availability='Occupied', Customer_ID='"+customerId+"' WHERE House_no=" + number);
                         stmt.executeUpdate();
                    }
                    JOptionPane.showMessageDialog(null, "Congratulations, you have successfully rented House " + number);
                    signUp.dispose();
                    
                    new HomePage();
                }
                catch(ClassNotFoundException | SQLException e) {
                    System.out.println(e);
                }
             }             
         });
//                 JOptionPane.showMessageDialog(null,"Registered Details Successfully!");
//            
        cancelButton.addActionListener((ActionEvent ae) -> {
            signUp.dispose();
            new HomePage();
        });
    }
}