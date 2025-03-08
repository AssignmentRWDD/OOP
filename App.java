package com.ppeinventory;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // Create and set up the main window
        JFrame frame = new JFrame("PPE Inventory Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Add the main panel
        JPanel mainPanel = new JPanel();
        frame.add(mainPanel);

        // Display the window
        frame.setVisible(true);
    }
}
