import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Login extends JFrame implements ActionListener {
	
	JPanel mainPanel = new JPanel();
	JPanel logoPanel = new JPanel(new BorderLayout());
	JLabel logoLabel = new JLabel("CakeLAnd", SwingConstants.CENTER);
	JPanel userPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	JLabel userLabel = new JLabel("Username", SwingConstants.CENTER);
	JTextField userField = new JTextField();
	JPanel passPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	JLabel passLabel = new JLabel("Password", SwingConstants.CENTER);
	JPasswordField passField = new JPasswordField();
	
	JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton loginButton = new JButton("Login");
	JPanel regPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JButton regButton = new JButton("Don't have account? Register");
	
	public static User userLog;
	
	public Login() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(20,20,20,20));
		mainPanel.setBackground(Color.pink);
		setTitle("Login");
		setSize(350, 550);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.png"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		initLogo();
		initUser();
		initPass();
		initLogButton();
		initRegButton();
		
		add(mainPanel);
		setVisible(true);
	}
	
	private void initLogo() {
		logoLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		logoLabel.setForeground(new Color(130, 70, 77));
		logoPanel.add(logoLabel, BorderLayout.SOUTH);
		logoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, logoPanel.getMinimumSize().height));
		logoPanel.setBackground(Color.pink);
		logoPanel.setBorder(new EmptyBorder(0,0,10,0));
		mainPanel.add(logoPanel);
	}
	
	private void initRegButton() {
		regButton.setBorderPainted(false);
		regButton.setFocusPainted(false);
		regButton.setContentAreaFilled(false);
		regButton.setOpaque(false);
		regButton.setForeground(Color.BLUE);
		regButton.setFont(new Font("Calibri", Font.ITALIC, 16));
		regButton.addActionListener(this);
		regPanel.setBackground(Color.pink);
		regPanel.add(regButton);
		mainPanel.add(regPanel);
	}

	private void initLogButton() {
		loginButton.setPreferredSize(new Dimension(100, 50));
		loginButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		loginButton.setForeground(new Color(27, 44, 99));
		loginButton.setBackground(new Color(255, 217, 229));
		loginButton.setBorder(null);
		loginButton.addActionListener(this);
		loginPanel.add(loginButton);
		loginPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
		loginPanel.setBackground(Color.pink);
		mainPanel.add(loginPanel);
	}

	private void initPass() {
		passLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		passLabel.setForeground(new Color(27, 44, 99));
		passField.setFont(new Font("Segoe UI", Font.BOLD, 15));
		passField.setForeground(new Color(27, 44, 99));
		passField.setBackground(Color.pink);
		passField.setBorder(new CompoundBorder(new MatteBorder(0, 0, 2, 0, new Color(53, 43, 89)), new EmptyBorder(5, 5, 5, 5)));
		passPanel.setBackground(Color.pink);
		passPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
		passPanel.add(passLabel);
		passPanel.add(passField);
		mainPanel.add(passPanel);
	}

	private void initUser() {
		userLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		userLabel.setForeground(new Color(27, 44, 99));
		userField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		userField.setForeground(new Color(27, 44, 99));
		userField.setBackground(Color.pink);
		userField.setBorder(new CompoundBorder(new MatteBorder(0, 0, 2, 0, new Color(53, 43, 89)), new EmptyBorder(5, 5, 5, 5)));
		userPanel.setBackground(Color.pink);
		userPanel.add(userLabel);
		userPanel.add(userField);
		mainPanel.add(userPanel);
	}
	
	private JOptionPane paneLayout(String msg) {
		UIManager UI=new UIManager();
		UI.put("OptionPane.background", new Color(255, 217, 229));
		UI.put("Panel.background", new Color(255, 217, 229));
		UIManager.put("Button.background", new Color(207, 248, 255));
		JOptionPane pane = new JOptionPane();
		pane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
		return pane;
	}
	
	private JOptionPane successPaneLayout(String msg) {
		UIManager UI=new UIManager();
		UI.put("OptionPane.background", new Color(255, 217, 229));
		UI.put("Panel.background", new Color(255, 217, 229));
		UIManager.put("Button.background", new Color(207, 248, 255));
		JOptionPane pane = new JOptionPane();
		pane.showMessageDialog(null, msg, "Success", JOptionPane.INFORMATION_MESSAGE);
		return pane;
	}

	private void validation() {
		if (userField.getText().isEmpty()) {
			paneLayout("Username cannot be empty!");
		}
		else if (passField.getText().isEmpty()) {
			paneLayout("Password cannot be empty!");
		}
		else if (UserModel.checkLogin(userField.getText(), String.valueOf(passField.getText())) == null) {
			paneLayout("Wrong username / password!");
		}
		else {
			userLog = UserModel.checkLogin(userField.getText(), String.valueOf(passField.getText()));
			successPaneLayout("Login Success!");
			this.setVisible(false);
			if (userField.getText().equals("admin")) {
				new AdminMain();
			}
			else {
				new UserMain();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == regButton) {
			this.setVisible(false);
			new Register();
		}
		if (e.getSource() == loginButton) {
			validation();
		}
	}
}
