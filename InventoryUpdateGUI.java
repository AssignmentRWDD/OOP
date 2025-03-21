import java.awt.*;
import javax.swing.*;

public class InventoryUpdateGUI extends JFrame {

    private final JTextField itemCodeField;
    private final JTextField quantityField;
    private final JTextField supplierOrHospitalField;
    private final JButton receiveButton;
    private final JButton distributeButton;

    public InventoryUpdateGUI(Point location) {
        setTitle("Update Inventory");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(5, 2));

        if (location != null) {
            setLocation(location); // Set the position to the previous window's location
        } else {
            setLocationRelativeTo(null); // Center the window if no location is provided
        }

        add(new JLabel("Item Code:"));
        itemCodeField = new JTextField();
        add(itemCodeField);

        add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        add(quantityField);

        add(new JLabel("Supplier/Hospital Code:"));
        supplierOrHospitalField = new JTextField();
        add(supplierOrHospitalField);

        receiveButton = new JButton("Receive PPE");
        distributeButton = new JButton("Distribute PPE");

        receiveButton.addActionListener(e -> updateInventory("Received"));
        distributeButton.addActionListener(e -> updateInventory("Distributed"));

        add(receiveButton);
        add(distributeButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose(); // Close this window
            new MainMenuGUI(getLocation()); // Reopen the main menu
        });
        add(backButton);

        setVisible(true);
    }

    private void updateInventory(String type) {
        String itemCode = itemCodeField.getText().trim();
        String supplierOrHospitalCode = supplierOrHospitalField.getText().trim();
        int quantity;

        try {
            quantity = Integer.parseInt(quantityField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (itemCode.isEmpty() || supplierOrHospitalCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (type.equals("Received")) {
            InventoryManager.updateInventory(itemCode, quantity, supplierOrHospitalCode, "Received");
        } else {
            InventoryManager.updateInventory(itemCode, -quantity, supplierOrHospitalCode, "Distributed");
        }

        JOptionPane.showMessageDialog(this, "Inventory Updated!");
    }

    public static void main(String[] args) {
        new InventoryUpdateGUI(null);
    }
}
