import java.awt.*;
import javax.swing.*;

public class MainMenuGUI extends JFrame {

    public MainMenuGUI(Point location) {
        setTitle("Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        if (location != null) {
            setLocation(location); // Set the position to the previous window's location
        } else {
            setLocationRelativeTo(null); // Center the window if no location is provided
        }

        JButton updateInventoryButton = new JButton("Update Inventory");
        JButton viewInventoryButton = new JButton("View Inventory");
        JButton generateReportsButton = new JButton("Generate Reports");
        JButton manageSuppliersHospitalsButton = new JButton("Manage Suppliers & Hospitals");
        JButton logoutButton = new JButton("Logout");

        updateInventoryButton.addActionListener(e -> {
            dispose(); // Close the main menu
            new InventoryUpdateGUI(null); // Open Inventory Update GUI in the center
        });

        viewInventoryButton.addActionListener(e -> {
            Point newLocation = calculateNewPosition(getLocation());
            new InventoryGUI(newLocation); // Open Inventory GUI beside the current window
        });

        generateReportsButton.addActionListener(e -> {
            dispose(); // Close the main menu
            new ReportGUI(null); // Open Report GUI in the center
        });

        manageSuppliersHospitalsButton.addActionListener(e -> {
            dispose(); // Close the main menu
            new SupplierHospitalGUI(null); // Open Supplier & Hospital Management GUI in the center
        });

        logoutButton.addActionListener(e -> {
            System.exit(0); // Exit the application and close all windows
        });

        add(updateInventoryButton);
        add(viewInventoryButton);
        add(generateReportsButton);
        add(manageSuppliersHospitalsButton);
        add(logoutButton);

        setVisible(true);
    }

    private Point calculateNewPosition(Point currentLocation) {
        if (currentLocation == null) {
            return null;
        }
        return new Point(currentLocation.x + 420, currentLocation.y); // Position the new window to the right
    }

    public static void main(String[] args) {
        new MainMenuGUI(null);
    }
}
