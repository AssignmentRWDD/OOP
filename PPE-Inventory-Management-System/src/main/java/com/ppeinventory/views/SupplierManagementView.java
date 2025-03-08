import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupplierManagementView extends JFrame {
    private JTextField supplierCodeField;
    private JTextField supplierNameField;
    private JTextArea supplierListArea;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton viewButton;

    public SupplierManagementView() {
        setTitle("Supplier Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Supplier Code:"));
        supplierCodeField = new JTextField();
        inputPanel.add(supplierCodeField);

        inputPanel.add(new JLabel("Supplier Name:"));
        supplierNameField = new JTextField();
        inputPanel.add(supplierNameField);

        add(inputPanel, BorderLayout.NORTH);

        supplierListArea = new JTextArea();
        supplierListArea.setEditable(false);
        add(new JScrollPane(supplierListArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Supplier");
        updateButton = new JButton("Update Supplier");
        deleteButton = new JButton("Delete Supplier");
        viewButton = new JButton("View Suppliers");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSupplier();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSupplier();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSupplier();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSuppliers();
            }
        });
    }

    private void addSupplier() {
        // Logic to add supplier
    }

    private void updateSupplier() {
        // Logic to update supplier
    }

    private void deleteSupplier() {
        // Logic to delete supplier
    }

    private void viewSuppliers() {
        // Logic to view suppliers
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SupplierManagementView view = new SupplierManagementView();
            view.setVisible(true);
        });
    }
}