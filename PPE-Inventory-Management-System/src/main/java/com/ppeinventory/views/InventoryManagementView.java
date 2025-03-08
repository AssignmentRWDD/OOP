package com.ppeinventory.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryManagementView extends JFrame {
    private JTextField itemCodeField;
    private JTextField supplierCodeField;
    private JTextField quantityField;
    private JTextArea inventoryDisplayArea;

    public InventoryManagementView() {
        setTitle("Inventory Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Item Code:"));
        itemCodeField = new JTextField();
        inputPanel.add(itemCodeField);

        inputPanel.add(new JLabel("Supplier Code:"));
        supplierCodeField = new JTextField();
        inputPanel.add(supplierCodeField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        JButton updateButton = new JButton("Update Inventory");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateInventory();
            }
        });
        inputPanel.add(updateButton);

        inventoryDisplayArea = new JTextArea();
        inventoryDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(inventoryDisplayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void updateInventory() {
        String itemCode = itemCodeField.getText();
        String supplierCode = supplierCodeField.getText();
        String quantityText = quantityField.getText();

        // Logic to update inventory goes here
        // For now, just displaying the input in the text area
        inventoryDisplayArea.append("Updated Item: " + itemCode + ", Supplier: " + supplierCode + ", Quantity: " + quantityText + "\n");

        // Clear fields after update
        itemCodeField.setText("");
        supplierCodeField.setText("");
        quantityField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InventoryManagementView view = new InventoryManagementView();
            view.setVisible(true);
        });
    }
}