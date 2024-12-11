package surenatalaga;

/*  Reeeeey Prject

*/
import java.awt.*;
import javax.swing.*;

public class loginnew {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new loginnew(); // Launch login window
            }
        });
    }

    public loginnew() {
        // Create the frame
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout()); // Use GridBagLayout for flexible positioning of components

        // Set layout constraints for components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title label configuration
        JLabel titleLabel = new JLabel("STORE INVENTORY", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20)); // Changed to a common font
        gbc.gridx = 0; // Position in column 0
        gbc.gridy = 0; // Position in row 0
        gbc.gridwidth = 2; // Span across 2 columns
        frame.add(titleLabel, gbc);

        // Add Username label and input field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        frame.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(usernameField, gbc);

        // Add Password label and input field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField();
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(passwordField, gbc);

        // Add Role dropdown
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(roleLabel, gbc);

        String[] roles = {"ADMINISTRATOR", "USER"};
        JComboBox<String> roleDropdown = new JComboBox<>(roles);
        roleDropdown.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 3;
        frame.add(roleDropdown, gbc);

        // Add Login button
        JButton loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Span across 2 columns
        frame.add(loginButton, gbc);

        // Action listener for the Login button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String role = (String) roleDropdown.getSelectedItem();

            // Check credentials for Admin or User role
            if ((username.equals("Admin") && password.equals("Admin") && role.equals("ADMINISTRATOR")) ||
                (username.equals("Rey") && password.equals("Pogi") && role.equals("USER"))) {
                frame.dispose(); // Close the login window

                // Launch the stabs window
                SwingUtilities.invokeLater(() -> {
                    JFrame loginFrame = new JFrame(); // Placeholder frame
                    new stabs(loginFrame, username, role).setVisible(true);
                });
            } else {
                // Show an error message if credentials are invalid
                JOptionPane.showMessageDialog(frame, "Password and Username is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Style the frame and its components
        frame.getContentPane().setBackground(Color.DARK_GRAY); // Background color
        titleLabel.setForeground(Color.WHITE); // Text color
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        roleLabel.setForeground(Color.WHITE);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Make the frame visible
    }
}
