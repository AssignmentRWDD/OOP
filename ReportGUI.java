import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReportGUI extends JFrame {
    private JTextField startDateField, endDateField;

    public ReportGUI(Point location) {
        setTitle("PPE Inventory Reports");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(6, 1));

        if (location != null) {
            setLocation(location); // Set the position to the previous window's location
        } else {
            setLocationRelativeTo(null); // Center the window if no location is provided
        }

        JButton stockButton = new JButton("View Available Stock");
        JButton lowStockButton = new JButton("View Low Stock PPE");
        JButton trackButton = new JButton("Track PPE Received (Date Range)");
        JButton backButton = new JButton("Back");

        stockButton.addActionListener(e -> {
            Point newLocation = calculateNewPosition(getLocation());
            new InventoryGUI(newLocation); // Open Inventory GUI to display all stock
        });

        lowStockButton.addActionListener(e -> {
            List<PPEItem> lowStockItems = InventoryManager.getLowStockItems();
            if (lowStockItems.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No low stock PPE currently.", "Low Stock PPE", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Point newLocation = calculateNewPosition(getLocation());
                new LowStockGUI(newLocation, lowStockItems); // Open LowStockGUI to display low-stock items
            }
        });

        backButton.addActionListener(e -> {
            dispose(); // Close this window
            new MainMenuGUI(getLocation()); // Reopen the main menu
        });

        add(stockButton);
        add(lowStockButton);

        JPanel datePanel = new JPanel(new GridLayout(2, 2));
        datePanel.add(new JLabel("Start Date (YYYY-MM-DD):"));
        startDateField = new JTextField();
        datePanel.add(startDateField);

        datePanel.add(new JLabel("End Date (YYYY-MM-DD):"));
        endDateField = new JTextField();
        datePanel.add(endDateField);
        add(datePanel);

        trackButton.addActionListener(e -> {
            String start = startDateField.getText();
            String end = endDateField.getText();
            InventoryManager.trackReceivedItems(start, end);
        });

        add(trackButton);
        add(backButton);
        setVisible(true);
    }

    private Point calculateNewPosition(Point currentLocation) {
        if (currentLocation == null) {
            return null;
        }
        return new Point(currentLocation.x + 420, currentLocation.y); // Position the new window to the right
    }

    public static void main(String[] args) {
        new ReportGUI(null);
    }
}
