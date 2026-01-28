import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CrimeGUI {
    private CrimeDatabase db = new CrimeDatabase();

    public CrimeGUI() {
        JFrame frame = new JFrame("Crime Record System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField typeField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField locationField = new JTextField();
        JTextField statusField = new JTextField();
        JButton addBtn = new JButton("Add Crime");
        JButton viewBtn = new JButton("View Crimes");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        frame.setLayout(new GridLayout(8, 2));
        frame.add(new JLabel("Crime ID:")); frame.add(idField);
        frame.add(new JLabel("Suspect Name:")); frame.add(nameField);
        frame.add(new JLabel("Crime Type:")); frame.add(typeField);
        frame.add(new JLabel("Date:")); frame.add(dateField);
        frame.add(new JLabel("Location:")); frame.add(locationField);
        frame.add(new JLabel("Status:")); frame.add(statusField);
        frame.add(addBtn); frame.add(viewBtn);
        frame.add(new JScrollPane(output));

        addBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                Crime c = new Crime(id, nameField.getText(), typeField.getText(), dateField.getText(),
                        locationField.getText(), statusField.getText());
                db.saveCrime(c);
                output.setText("✅ Crime added successfully!");
            } catch (Exception ex) {
                output.setText("❌ Error: " + ex.getMessage());
            }
        });

        viewBtn.addActionListener(e -> {
            List<Crime> list = db.getAllCrimes();
            StringBuilder sb = new StringBuilder();
            for (Crime c : list) sb.append(c.toString()).append("\n");
            output.setText(sb.toString());
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CrimeGUI();
    }
}
