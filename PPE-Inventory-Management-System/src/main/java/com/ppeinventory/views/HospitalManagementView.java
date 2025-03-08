import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospitalManagementView extends JFrame {
    private JTextField hospitalCodeField;
    private JTextField hospitalNameField;
    private JTextArea hospitalListArea;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton viewButton;

    public HospitalManagementView() {
        setTitle("Hospital Management");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Hospital Code:"));
        hospitalCodeField = new JTextField();
        inputPanel.add(hospitalCodeField);

        inputPanel.add(new JLabel("Hospital Name:"));
        hospitalNameField = new JTextField();
        inputPanel.add(hospitalNameField);

        addButton = new JButton("Add Hospital");
        updateButton = new JButton("Update Hospital");
        deleteButton = new JButton("Delete Hospital");
        viewButton = new JButton("View Hospitals");

        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);
        inputPanel.add(viewButton);

        add(inputPanel, BorderLayout.NORTH);

        hospitalListArea = new JTextArea();
        hospitalListArea.setEditable(false);
        add(new JScrollPane(hospitalListArea), BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addHospital();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateHospital();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteHospital();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHospitals();
            }
        });
    }

    private void addHospital() {
        // Logic to add hospital
    }

    private void updateHospital() {
        // Logic to update hospital
    }

    private void deleteHospital() {
        // Logic to delete hospital
    }

    private void viewHospitals() {
        // Logic to view hospitals
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HospitalManagementView view = new HospitalManagementView();
            view.setVisible(true);
        });
    }
}