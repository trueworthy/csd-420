// Lea Trueworthy
// May 6, 2025
// M10 Programming assignment
// Description: Write a program that connects to a MySQL database (databasedb) using user ID student1 and password pass, and manages fan records in a table called fans. 
// The GUI lets users enter an ID to display or update a fan's first name, last name, and favorite team. The program assumes the table exists but includes optional code to create and populate it for testing.

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class FanApp extends JFrame {

    static final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    static final String DB_USER = "student1";
    static final String DB_PASS = "pass";

    JTextField idField = new JTextField(5);
    JTextField firstNameField = new JTextField(20);
    JTextField lastNameField = new JTextField(20);
    JTextField teamField = new JTextField(20);
    JButton displayBtn = new JButton("Display");
    JButton updateBtn = new JButton("Update");

    public FanApp() {
        super("Fan Database Manager");

        // Frame size
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("First Name:"));
        add(firstNameField);
        add(new JLabel("Last Name:"));
        add(lastNameField);
        add(new JLabel("Favorite Team:"));
        add(teamField);
        add(displayBtn);
        add(updateBtn);

        displayBtn.addActionListener(e -> displayFan());
        updateBtn.addActionListener(e -> updateFan());

        // Center the frame
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    // Display record
    private void displayFan() {
        String idText = idField.getText().trim();
        if (idText.isEmpty()) {
            showError("ID is required.");
            return;
        }

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM fans WHERE ID = ?")) {

            stmt.setInt(1, Integer.parseInt(idText));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                teamField.setText(rs.getString("favoriteteam"));
            } else {
                showInfo("No record found for ID " + idText);
                clearFields();
            }

        } catch (SQLException e) {
            showError("Display failed: " + e.getMessage());
        }
    }

    private void updateFan() {
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                PreparedStatement stmt = con.prepareStatement(
                        "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?")) {

            stmt.setString(1, firstNameField.getText().trim());
            stmt.setString(2, lastNameField.getText().trim());
            stmt.setString(3, teamField.getText().trim());
            stmt.setInt(4, Integer.parseInt(idField.getText().trim()));

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                showInfo("Record updated.");
            } else {
                showInfo("No record updated. Make sure ID exists.");
            }

        } catch (SQLException e) {
            showError("Update failed: " + e.getMessage());
        }
    }

    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        teamField.setText("");
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showInfo(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Load JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found.");
            return;
        }

        SwingUtilities.invokeLater(FanApp::new);
    }
}
