package house.rental.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class TenantLogin {
    TenantLogin() {
    JFrame loginFrame = new JFrame("Tenant Login");
    
    Color buttonColor = new Color(150, 150, 150);
    Color frameColor = new Color(50, 50, 50);
    Color txtColor = new Color(255, 255, 255);
    
    JLabel idLabel = new JLabel("    ID: ");
    Font boldFont = new Font("Arial", Font.BOLD, 16);
    idLabel.setFont(boldFont);
    idLabel.setBounds(70, 70, 100, 30);
    idLabel.setBackground(frameColor);
    idLabel.setForeground(txtColor);
    JTextField idField = new JTextField();
    idField.setFont(boldFont);
    idField.setBounds(170, 70, 150, 30);

    JLabel passwordLabel = new JLabel("Password: ");
    passwordLabel.setFont(boldFont);
    passwordLabel.setBounds(70, 140, 100, 30);
    passwordLabel.setBackground(frameColor);
    passwordLabel.setForeground(txtColor);
    JPasswordField passwordField = new JPasswordField();
    passwordField.setBounds(170, 140, 150, 30);
    
    JButton loginButton = new JButton("Login");
    loginButton.setBounds(80, 220, 100, 30);
    loginButton.setBackground(buttonColor);
    JButton cancelButton = new JButton("Cancel");
    cancelButton.setBounds(190, 220, 100, 30);
    cancelButton.setBackground(buttonColor);
    
    loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
//                 if(idField.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(null,"Please enter your id");
//                    return;
//                }
                int id;
                try {
                    id = Integer.parseInt(idField.getText());
                }
                catch(Exception e) {
                    JOptionPane.showMessageDialog(null,"Your ID should be a positive integer");
                    return;
                }
                String password = passwordField.getText();
                try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/customer_details";
                Connection conn = DriverManager.getConnection(url, "root", "root");
                System.out.println("Connection established");
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customer_details WHERE id=? AND password=?");
                stmt.setInt(1, id);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()) {
                    System.out.println("Logged IN");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Your id or password is invalid");   
                }
                }
                catch (ClassNotFoundException | SQLException e) {
                    System.out.println(e);
                }
            }            
    });
    
    cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                loginFrame.dispose();
                new HomePage();
            }            
    });
    
    loginFrame.add(loginButton);
    loginFrame.add(cancelButton);
    loginFrame.add(idLabel);
    loginFrame.add(idField);
    loginFrame.add(passwordLabel);
    loginFrame.add(passwordField);
    
    loginFrame.getContentPane().setBackground(frameColor);
    loginFrame.setBounds(200, 150, 400, 400);
    loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    loginFrame.setLayout(null);
    loginFrame.setVisible(true);
    }
}
