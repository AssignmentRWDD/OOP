import java.awt.*;
import javax.swing.*;

public class SupplierHospitalGUI extends JFrame {
    private final JTextField supplierCodeField;
    private final JTextField supplierNameField;
    private final JTextField hospitalCodeField;
    private final JTextField hospitalNameField;

    public SupplierHospitalGUI(Point location) {
        setTitle("Manage Suppliers & Hospitals");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLayout(new GridLayout(7, 2));

        if (location != null) {
            setLocation(location); // Set the position to the previous window's location
        } else {
            setLocationRelativeTo(null); // Center the window if no location is provided
        }

        // Supplier section
        add(new JLabel("Supplier Code:"));
        supplierCodeField = new JTextField();
        add(supplierCodeField);

        add(new JLabel("Supplier Name:"));
        supplierNameField = new JTextField();
        add(supplierNameField);

        JButton addSupplierButton = new JButton("Add Supplier");
        addSupplierButton.addActionListener(e -> addSupplier());
        add(addSupplierButton);

        // Hospital section
        add(new JLabel("Hospital Code:"));
        hospitalCodeField = new JTextField();
        add(hospitalCodeField);

        add(new JLabel("Hospital Name:"));
        hospitalNameField = new JTextField();
        add(hospitalNameField);

        JButton addHospitalButton = new JButton("Add Hospital");
        addHospitalButton.addActionListener(e -> addHospital());
        add(addHospitalButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose(); // Close this window
            new MainMenuGUI(getLocation()); // Reopen the main menu
        });
        add(backButton);

        setVisible(true);
    }

    private void addSupplier() {
        String code = supplierCodeField.getText();
        String name = supplierNameField.getText();
        if (!code.isEmpty() && !name.isEmpty()) {
            SupplierManager.addSupplier(new Supplier(code, name));
            JOptionPane.showMessageDialog(this, "Supplier added successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter all fields!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addHospital() {
        String code = hospitalCodeField.getText();
        String name = hospitalNameField.getText();
        if (!code.isEmpty() && !name.isEmpty()) {
            HospitalManager.addHospital(new Hospital(code, name));
            JOptionPane.showMessageDialog(this, "Hospital added successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter all fields!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new SupplierHospitalGUI(null);
    }
}
