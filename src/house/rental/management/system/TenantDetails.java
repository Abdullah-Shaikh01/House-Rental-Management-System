
package house.rental.management.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;

public class TenantDetails {

    public TenantDetails() {
        JFrame frame = new JFrame("Customer Details");
        
        JLabel label = new JLabel("Tenant details");
        label.setForeground(new Color(0, 0, 0));
        label.setBackground(new Color(40, 40, 40));
        label.setFont(new Font("Roman", Font.BOLD, 22));
        label.setBounds(550, 40, 200, 40);
        frame.add(label);
        
        String[] columns = {"Customer ID", "First Name", "Last name", "Phone number", "Email ID", "Aadhar number", "Number of members", "House number"};
        Object[][] data = getCustomerDetails();       
        JTable customerTable = new JTable(data, columns);
        customerTable.setFont(new Font("Serif", Font.PLAIN, 16));
        customerTable.setRowHeight(35);
        customerTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 16));
        customerTable.setBounds(0, 100, 100, 600);
        JScrollPane sp = new JScrollPane(customerTable);
        sp.setBounds(0, 100, 1200, 600);
        frame.add(sp);
        
        frame.setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setBounds(150, 100, 1200, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private Object[][] getCustomerDetails() {

        Object[][] data = null;

        final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
        final String CONNECTION_URL = "jdbc:mysql://localhost:3306/customer_details";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        final String QUERY = "SELECT * FROM customer_details";

        try {

            // Loading the Driver
            Class.forName(DRIVER_NAME);

            // Getting Database Connection Object by Passing URL, Username and Password
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

}