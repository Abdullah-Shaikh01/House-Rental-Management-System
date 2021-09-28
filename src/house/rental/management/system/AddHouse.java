package house.rental.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class AddHouse {  
    AddHouse() {
        JFrame addHouse = new JFrame("Adding a House"); 
        
        Font labelFont = new Font("Roman", Font.PLAIN, 17);
        Color buttonColor = new Color(150, 150, 150);
        Color frameColor = new Color(50, 50, 50);
        Color txtColor = new Color(255, 255, 255);
        Font titleFont = new Font("Serif",Font.BOLD,20);
        
        ImageIcon i1  = new ImageIcon("b.jfif");
        JLabel l15 = new JLabel(i1);
        l15.setBounds(480,30,280,200);
        addHouse.add(l15);
        
        JLabel title = new JLabel("Enter House Details ");
        title.setBounds(210, 30, 200, 40);
        title.setFont(titleFont);
        title.setBackground(frameColor);
        title.setForeground(txtColor);
        addHouse.add(title);
        
        JLabel l_size = new JLabel("Size of House: ");
        l_size.setBounds(80, 100, 200, 30);
        l_size.setFont(labelFont);
        l_size.setBackground(frameColor);
        l_size.setForeground(txtColor);
        addHouse.add(l_size);

        JTextField tf_size = new JTextField();
        tf_size.setBounds(260, 100, 200, 30);
        tf_size.setFont(labelFont);
        addHouse.add(tf_size);
        
        
        JLabel l_price = new JLabel("Price per month : ");
        l_price.setBounds(80, 200, 200, 30);
        l_price.setFont(labelFont);
        l_price.setBackground(frameColor);
        l_price.setForeground(txtColor);
        addHouse.add(l_price);

        JTextField tf_price = new JTextField();
        tf_price.setBounds(260, 200, 200, 30);
        tf_price.setFont(labelFont);
        addHouse.add(tf_price);
        
        JLabel l_bedrooms = new JLabel("Number of bedrooms : ");
        l_bedrooms.setBounds(80, 150, 200, 30);
        l_bedrooms.setFont(labelFont);
        l_bedrooms.setBackground(frameColor);
        l_bedrooms.setForeground(txtColor);
        addHouse.add(l_bedrooms);

        JTextField tf_bedrooms = new JTextField();
        tf_bedrooms.setBounds(260, 150, 200, 30);
        tf_bedrooms.setFont(labelFont);
        addHouse.add(tf_bedrooms);
        
        JLabel l_address = new JLabel("Address : ");
        l_address.setBounds(80, 250, 200, 30);
        l_address.setFont(labelFont);
        l_address.setBackground(frameColor);
        l_address.setForeground(txtColor);
        addHouse.add(l_address);

        JTextArea tf_address = new JTextArea();
        tf_address.setBounds(260, 250, 400, 60);
        tf_address.setFont(labelFont);
        addHouse.add(tf_address);
        
        JLabel l_other = new JLabel("Other specifications : ");
        l_other.setBounds(80, 330, 300, 30);
        l_other.setFont(labelFont);
        l_other.setBackground(frameColor);
        l_other.setForeground(txtColor);
        addHouse.add(l_other);

        JTextArea tf_other = new JTextArea();
        tf_other.setBounds(260, 330, 400, 100);
        tf_other.setFont(labelFont);
        addHouse.add(tf_other);
        
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(140, 460, 100, 30);
        submitButton.setBackground(buttonColor);
        addHouse.add(submitButton);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(280, 460, 100, 30);
        cancelButton.setBackground(buttonColor);
        addHouse.add(cancelButton);

        addHouse.getContentPane().setBackground(frameColor);
        addHouse.setLayout(null);
        addHouse.setVisible(true);
        addHouse.setBounds(200, 150, 800, 560);
        addHouse.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       //Functioning
        submitButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
                
                //To check wether any field is empty
                String size = tf_size.getText();
                String address = tf_address.getText();
                String price = tf_price.getText();
                String other = tf_other.getText();
                if(size.isEmpty() || address.isEmpty() || price.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Please enter all details");
                    return;
                }
                if(tf_bedrooms.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Please enter the number of bedrooms");
                    return;
                }
                int bedrooms = Integer.parseInt(tf_bedrooms.getText());
                
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/house";
                    Connection conn = DriverManager.getConnection(url, "root", "root");
                    System.out.println("Connection established");
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO house_details (area_size, Address, Price_per_month, No_of_bedrooms, other ) VALUES (?, ?, ?, ?, ? )");                    
                    stmt.setString(1, size);
                    stmt.setString(2, address);
                    stmt.setString(3, price);
                    stmt.setInt(4, bedrooms);
                    stmt.setString(5, other);
//                    stmt.setString(7, password);
//                    stmt.setInt(6, members);
                    stmt.executeUpdate();
                    //message
//                    ResultSet rs = stmt.executeQuery("SELECT id, password FROM customer_details ORDER BY id DESC LIMIT 1");
//                    while(rs.next()) {
                     //   JOptionPane.showMessageDialog(null,"Registered data successfully\n Please remember your id: " + rs.getInt(1) + " and password : " + rs.getString(2));
                    //}
                        JOptionPane.showMessageDialog(null,"Registered data successfully");
                        
                    addHouse.dispose();
                    new ShowHouse();
//                    signUp.dispose();
//                    new HomePage();
                }
                catch(ClassNotFoundException | SQLException e) {
                    System.out.println(e);
                }
             }             
         });
//                 JOptionPane.showMessageDialog(null,"Registered Details Successfully!");
//            
        cancelButton.addActionListener((ActionEvent ae) -> {
            addHouse.dispose();
            new ShowHouse();
           // new HomePage();
        });
    }
//    public static void main(String[] args) {
//        new AddHouse();
//    }
}
