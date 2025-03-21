import java.awt.*;
import java.util.List;
import javax.swing.*;

public class InventoryGUI extends JFrame {
    private final JTextArea inventoryArea;

    public InventoryGUI(Point location) {
        setTitle("PPE Inventory Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new BorderLayout());

        if (location != null) {
            setLocation(location); // Set the position to the previous window's location
        } else {
            setLocationRelativeTo(null); // Center the window if no location is provided
        }

        // Add a title label at the top
        JLabel titleLabel = new JLabel("PPE Inventory", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel, BorderLayout.NORTH);

        inventoryArea = new JTextArea();
        inventoryArea.setEditable(false); // Make the text area read-only
        add(new JScrollPane(inventoryArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        JButton refreshButton = new JButton("Refresh Inventory");
        JButton backButton = new JButton("Back");
        buttonPanel.add(refreshButton, BorderLayout.WEST);
        buttonPanel.add(backButton, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        refreshButton.addActionListener(e -> displayInventory());
        backButton.addActionListener(e -> dispose()); // Close this window only

        displayInventory();
        setVisible(true);
    }

    private Point calculateNewPosition(Point currentLocation) {
        if (currentLocation == null) {
            return null;
        }
        return new Point(currentLocation.x - 420, currentLocation.y); // Position the new window to the left
    }

    private void displayInventory() {
        List<PPEItem> items = InventoryManager.loadInventory();
        StringBuilder sb = new StringBuilder();
        for (PPEItem item : items) {
            sb.append(item.getItemCode()).append(" - ")
              .append(item.getSupplierCode()).append(" - ")
              .append(item.getQuantity()).append(" boxes\n");
        }
        inventoryArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new InventoryGUI(null);
    }
}
