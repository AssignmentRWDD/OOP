import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    
    public MainView() {
        setTitle("PPE Inventory Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Create header
        JLabel headerLabel = new JLabel("Welcome to the PPE Inventory Management System", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        
        // Create buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 2));
        
        JButton userManagementButton = new JButton("User Management");
        JButton inventoryManagementButton = new JButton("Inventory Management");
        JButton supplierManagementButton = new JButton("Supplier Management");
        JButton hospitalManagementButton = new JButton("Hospital Management");
        JButton logoutButton = new JButton("Logout");
        
        buttonsPanel.add(userManagementButton);
        buttonsPanel.add(inventoryManagementButton);
        buttonsPanel.add(supplierManagementButton);
        buttonsPanel.add(hospitalManagementButton);
        buttonsPanel.add(logoutButton);
        
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        
        // Add action listeners
        userManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open User Management View
                new UserManagementView().setVisible(true);
                dispose();
            }
        });
        
        inventoryManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Inventory Management View
                new InventoryManagementView().setVisible(true);
                dispose();
            }
        });
        
        supplierManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Supplier Management View
                new SupplierManagementView().setVisible(true);
                dispose();
            }
        });
        
        hospitalManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Hospital Management View
                new HospitalManagementView().setVisible(true);
                dispose();
            }
        });
        
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logout and return to Login View
                new LoginView().setVisible(true);
                dispose();
            }
        });
        
        // Add main panel to frame
        add(mainPanel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }
}