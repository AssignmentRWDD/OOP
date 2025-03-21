import java.awt.*;
import javax.swing.*;

public class LoginGUI extends JFrame {
    private final JTextField userIdField;
    private final JPasswordField passwordField;

    public LoginGUI() {
        setTitle("PPE Inventory - Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Center the window on the screen
        setLocationRelativeTo(null);

        add(new JLabel("User ID:"));
        userIdField = new JTextField();
        add(userIdField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Login");
        add(loginButton);

        // Set the login button as the default button
        getRootPane().setDefaultButton(loginButton);

        loginButton.addActionListener(e -> handleLogin());

        setVisible(true);
    }

    private void handleLogin() {
        String userId = userIdField.getText();
        String password = new String(passwordField.getPassword());

        User user = UserManager.searchUser(userId);
        if (user != null && user.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            dispose(); // Close the login window
            new MainMenuGUI(null); // Open the main menu with no specific location
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}
