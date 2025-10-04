import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    JLabel messageLabel;

    public LoginPage() {
        // Frame settings
        setTitle("Login Page");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        // Components
        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        add(loginButton);

        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);
        add(messageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (authenticateUser(username, password)) {
            messageLabel.setForeground(Color.GREEN);
            messageLabel.setText("Login successful!");
            // Open new window or dashboard here
        } else {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Invalid credentials!");
        }
    }

    private boolean authenticateUser(String username, String password) {
        boolean isValid = false;

        String url = "jdbc:mysql://localhost:3306/your_database";
        String dbUser = "root";
        String dbPassword = "your_db_password";

        try {
            Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            isValid = rs.next();

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isValid;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage());
    }
}

