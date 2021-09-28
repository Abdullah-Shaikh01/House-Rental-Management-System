package house.rental.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ShowHouse {

    public ShowHouse() {
        JFrame frame = new JFrame("House Details");
        
        Color frameColor = new Color(50, 50, 50);
        Color buttonColor = new Color(150, 150, 150);
        Color txtColor = new Color(255, 255, 255);
        Font buttonFont = new Font("Serif",Font.ROMAN_BASELINE,25);
        Font titleFont = new Font("Serif",Font.BOLD,30);

        JLabel label = new JLabel("House details");
        label.setForeground(txtColor);
        label.setBackground(Color.GREEN);
        label.setFont(titleFont);
        label.setBounds(550, 40, 200, 40);
        frame.add(label);
        
        String[] columns = {"House number", "Area Size", "Address", "Availability", "Customer ID", "Price per month", "Number of bedrooms", "Other"};
        Object[][] data = getHouseDetails();       
        JTable houseTable = new JTable(data, columns);
        houseTable.setFont(new Font("Serif", Font.PLAIN, 16));
        houseTable.setRowHeight(35);
        houseTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 16));
        houseTable.setBackground(frameColor);
        houseTable.setForeground(txtColor);
        JScrollPane sp = new JScrollPane(houseTable);
        sp.setBounds(0, 100, 1200, 310);
        frame.add(sp);
        
        JButton addHouse = new JButton("Add House");
        addHouse.setBounds(200, 480, 200, 40);
        addHouse.setBackground(buttonColor);
        addHouse.setForeground(txtColor);
        addHouse.setFont(buttonFont);
        frame.add(addHouse);
        
        JButton delHouse = new JButton("Delete House");
        delHouse.setBounds(200, 540, 200, 40);
        delHouse.setBackground(buttonColor);
        delHouse.setForeground(txtColor);
        delHouse.setFont(buttonFont);
        frame.add(delHouse);
    
        ImageIcon i1  = new ImageIcon("a.jpg");
        Image image = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(image);
        JLabel l15 = new JLabel();
        l15.setIcon(i1);
        l15.setBounds(500,420,700,220);
        frame.add(l15);
        
        addHouse.addActionListener((ActionEvent ae) -> {
            frame.dispose();
            new AddHouse();            
        });
        delHouse.addActionListener((ActionEvent ae) -> {
            try {
                String number = JOptionPane.showInputDialog("Please Enter the House Number");       
                if(number.isEmpty() || !(number.matches("-?\\d+"))) {
                    JOptionPane.showMessageDialog(null,"Please Enter the house number correctly");
                    return;
                }
                int numbers = Integer.parseInt(number);
                frame.dispose();
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/house";
                Connection conn = DriverManager.getConnection(url, "root", "root");
                System.out.println("Connection established");
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM house_details WHERE House_no=" + numbers);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Details of House number: " + numbers + " deleted successfully");
                new ShowHouse();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ShowHouse.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ShowHouse.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        frame.getContentPane().setBackground(frameColor);
        frame.setLayout(null);
        frame.setBounds(150, 100, 1230, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private Object[][] getHouseDetails() {

        Object[][] data = null;

        final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
        final String CONNECTION_URL = "jdbc:mysql://localhost:3306/house";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        final String QUERY = "SELECT * FROM house_details";

        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(QUERY);
            int rowCount = getRowCount(rs); // Row Count
            int columnCount = getColumnCount(rs); // Column Count
            rs.beforeFirst();
            data = new Object[rowCount][columnCount];
            
            int i = 0;
            while (rs.next()) {
                for (int j = 0; j < columnCount; j++) {
                    if (j == 0 || j == 6) {
                        data[i][j] = rs.getInt(j + 1);
                    } else {
                        data[i][j] = rs.getString(j + 1);
                    }
                }
                i++;
            }
            // Closing the Resources;
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return data;
    }

    // Method to get Row Count from ResultSet Object
    private int getRowCount(ResultSet rs) {

        try {

            if (rs != null) {

                rs.last();

                return rs.getRow();
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return 0;
    }

    // Method to get Column Count from ResultSet Object
    private int getColumnCount(ResultSet rs) {

        try {

            if (rs != null) {
                return rs.getMetaData().getColumnCount();
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return 0;
    }
    
//    public static void main(String[] args) {
//        new ShowHouse();
//    }
}