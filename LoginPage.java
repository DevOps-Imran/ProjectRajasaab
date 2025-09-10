package SamplePrograms;

    import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class LoginPage extends JFrame implements ActionListener {

	    // Components
	    private JLabel userLabel, passLabel;
	    private JTextField userText;
	    private JPasswordField passText;
	    private JButton loginButton, resetButton;
	    
	    // Hardcoded credentials
	    private final String USERNAME = "admin";
	    private final String PASSWORD = "password123";

	    public LoginPage() {
	        // Frame settings
	        setTitle("Login Page");
	        setSize(350, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null); // Center the frame

	        // Panel
	        JPanel panel = new JPanel();
	        panel.setLayout(null);
	        add(panel);

	        // Username label and text field
	        userLabel = new JLabel("Username:");
	        userLabel.setBounds(20, 20, 80, 25);
	        panel.add(userLabel);

	        userText = new JTextField(20);
	        userText.setBounds(100, 20, 200, 25);
	        panel.add(userText);

	        // Password label and field
	        passLabel = new JLabel("Password:");
	        passLabel.setBounds(20, 60, 80, 25);
	        panel.add(passLabel);

	        passText = new JPasswordField(20);
	        passText.setBounds(100, 60, 200, 25);
	        panel.add(passText);

	        // Login button
	        loginButton = new JButton("Login");
	        loginButton.setBounds(100, 100, 90, 25);
	        loginButton.addActionListener(this);
	        panel.add(loginButton);

	        // Reset button
	        resetButton = new JButton("Reset");
	        resetButton.setBounds(210, 100, 90, 25);
	        resetButton.addActionListener(e -> {
	            userText.setText("");
	            passText.setText("");
	        });
	        panel.add(resetButton);

	        setVisible(true);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String username = userText.getText();
	        String password = new String(passText.getPassword());

	        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
	            JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(this, "Invalid credentials.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public static void main(String[] args) {
	        new LoginPage();
	    }
	}


