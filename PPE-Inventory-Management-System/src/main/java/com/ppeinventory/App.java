package com.ppeinventory;

import javax.swing.SwingUtilities;
import com.ppeinventory.views.LoginView;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        });
    }
}