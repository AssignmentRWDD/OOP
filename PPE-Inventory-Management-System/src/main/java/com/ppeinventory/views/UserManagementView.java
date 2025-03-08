import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserManagementView extends JFrame {
    private JTextField userIdField;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox;
    private JTextArea userListArea;

    public UserManagementView() {
        setTitle("User Management");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("User ID:"));
        userIdField = new JTextField();
        inputPanel.add(userIdField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        inputPanel.add(passwordField);

        inputPanel.add(new JLabel("User Type:"));
        userTypeComboBox = new JComboBox<>(new String[]{"Admin", "Staff"});
        inputPanel.add(userTypeComboBox);

        JButton addButton = new JButton("Add User");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });
        inputPanel.add(addButton);

        JButton modifyButton = new JButton("Modify User");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyUser();
            }
        });
        inputPanel.add(modifyButton);

        JButton deleteButton = new JButton("Delete User");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });
        inputPanel.add(deleteButton);

        userListArea = new JTextArea();
        userListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(userListArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void addUser() {
        // Logic to add user
        String userId = userIdField.getText();
        String name = nameField.getText();
        String password = new String(passwordField.getPassword());
        String userType = (String) userTypeComboBox.getSelectedItem();
        
        // Add user to the system (to be implemented)
        userListArea.append("Added User: " + userId + ", " + name + ", " + userType + "\n");
    }

    private void modifyUser() {
        // Logic to modify user
        // Modify user in the system (to be implemented)
        userListArea.append("Modified User: " + userIdField.getText() + "\n");
    }

    private void deleteUser() {
        // Logic to delete user
        // Delete user from the system (to be implemented)
        userListArea.append("Deleted User: " + userIdField.getText() + "\n");
    }

    public static void main(String[] args) {
        new UserManagementView();
    }
}