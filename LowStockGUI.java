import java.awt.*;
import java.util.List;
import javax.swing.*;

public class LowStockGUI extends JFrame {
    public LowStockGUI(Point location, List<PPEItem> lowStockItems) {
        setTitle("Low Stock PPE");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new BorderLayout());

        if (location != null) {
            setLocation(location); // Set the position to the previous window's location
        } else {
            setLocationRelativeTo(null); // Center the window if no location is provided
        }

        // Add a title label at the top
        JLabel titleLabel = new JLabel("Low Stock PPE Items", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

        // Display low-stock items in a text area
        JTextArea lowStockArea = new JTextArea();
        lowStockArea.setEditable(false); // Make the text area read-only
        StringBuilder sb = new StringBuilder();
        for (PPEItem item : lowStockItems) {
            sb.append(item.getItemCode()).append(" - ")
              .append(item.getSupplierCode()).append(" - ")
              .append(item.getQuantity()).append(" boxes\n");
        }
        lowStockArea.setText(sb.toString());
        add(new JScrollPane(lowStockArea), BorderLayout.CENTER);

        // Add a "Close" button at the bottom
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose()); // Close this window only
        add(closeButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
