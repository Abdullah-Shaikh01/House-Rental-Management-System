
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class tableClass {
    tableClass() {
        JFrame frame = new JFrame();
        frame.setTitle("Hello");
        String[] columns = {"Customer ID", "First name"};
        String[][] data = {
            {"1001", "Abdullah Shaikh"},
            {"1002", "Abdullah"}
        };
        JTable table = new JTable(data, columns);
        table.setFont(new Font("Serif", Font.BOLD, 16));
        //table.setBounds(0, 0, 200, 200);
        //table.getAutoscrolls();
        table.setRowHeight(25);
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        
        //frame.add(table);
        frame.setSize(1000, 800);
        //frame.setLayout(null);
        frame.setVisible(true);
        
    }
    public static void main(String[] args) {
        new tableClass();
    }
}
