package house.rental.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class AdminLogin {
    AdminLogin() {
    JFrame loginFrame = new JFrame("Admin Login");
    
    Color buttonColor = new Color(150, 150, 150);
    Color frameColor = new Color(50, 50, 50);
    Color txtColor = new Color(255, 255, 255);
    
    JLabel usernameLabel = new JLabel("Username: ");
    Font boldFont = new Font("Arial", Font.BOLD, 16);
    usernameLabel.setFont(boldFont);
    usernameLabel.setBackground(frameColor);
    usernameLabel.setForeground(txtColor);
    usernameLabel.setBounds(70, 120, 100, 30);
    
    JTextField usernameField = new JTextField();
    usernameField.setFont(boldFont);
    usernameField.setBounds(170, 120, 150, 30);
    

    JLabel passwordLabel = new JLabel("Password: ");
    passwordLabel.setFont(boldFont);
    passwordLabel.setBounds(70, 190, 100, 30);
    passwordLabel.setBackground(frameColor);
    passwordLabel.setForeground(txtColor);
    
    JPasswordField passwordField = new JPasswordField();
    passwordField.setBounds(170, 190, 150, 30);
    
    
    JButton loginButton = new JButton("Login");
    loginButton.setBounds(80, 270, 100, 30);
    loginButton.setBackground(buttonColor);
    
    JButton cancelButton = new JButton("Cancel");
    cancelButton.setBounds(190, 270, 100, 30);
    cancelButton.setBackground(buttonColor);
    
    ImageIcon i1  = new ImageIcon("owner.jfif");
    JLabel l15 = new JLabel(i1);
    l15.setBounds(300,30,480,400);
    loginFrame.add(l15);
    
    loginButton.addActionListener(new ActionListener() {
            @Override    
            public void actionPerformed(ActionEvent ae) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                if( username.equals("admin") && password.equals("ADMIN") ) {
                    loginFrame.dispose();
                    new AdminHomePage();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }            
    });
    
    cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new HomePage();
                loginFrame.dispose();
            }            
    });
    
    loginFrame.add(loginButton);
    loginFrame.add(cancelButton);
    loginFrame.add(usernameLabel);
    loginFrame.add(usernameField);
    loginFrame.add(passwordLabel);
    loginFrame.add(passwordField);
    
    loginFrame.getContentPane().setBackground(frameColor);
    loginFrame.setBounds(200, 150, 700, 500);
    loginFrame.setLayout(null);
    loginFrame.setVisible(true);
    }
}
