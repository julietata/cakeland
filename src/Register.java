import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Register extends JFrame implements ActionListener {

	JPanel mainPanel = new JPanel();
	JPanel logoPanel = new JPanel();
	JLabel logoLabel = new JLabel("CakeLAnd");
	JPanel titlePanel = new JPanel();
	JLabel titleLabel = new JLabel("Create your own account!");
	JPanel namePanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel nameLabel = new JLabel("Username");
	JTextField nameField = new JTextField();
	JPanel emailPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel emailLabel = new JLabel("Email");
	JTextField emailField = new JTextField();
	JPanel passPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel passLabel = new JLabel("Password");
	JPasswordField passField = new JPasswordField();
	JPanel conpassPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel conpassLabel = new JLabel("Confirm Password");
	JPasswordField conpassField = new JPasswordField();
	JPanel genderPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel genderLabel = new JLabel("Gender");
	JPanel genderButton = new JPanel(new GridLayout(1, 2, 5, 5));
	JRadioButton maleButton = new JRadioButton("Male");
	JRadioButton femaleButton = new JRadioButton("Female");
	ButtonGroup gender = new ButtonGroup();
	JPanel dobPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel dobLabel = new JLabel("Date of Birth");
	JPanel ddmmyyyy = new JPanel();
	JTextField dd = new JTextField();
	JLabel dStrip = new JLabel("-");
	JTextField mm = new JTextField();
	JLabel mStrip = new JLabel("-");
	JTextField yyyy = new JTextField();
	JPanel phonePanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel phoneLabel = new JLabel("Phone Number");
	JPanel phoneValid = new JPanel();
	JTextField phoneField = new JTextField();
	JLabel msgLabel = new JLabel("!");
	JPanel addressPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel addressLabel = new JLabel("Address");
	JTextArea addressArea = new JTextArea();
	JPanel checkBox = new JPanel();
	JCheckBox termsCon = new JCheckBox("Agree to Terms & Conditions");
	JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton regButton = new JButton("Register");
	JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JButton loginButton = new JButton("Already have an account? Login");
	
	Random rand = new Random();
	
	public Register() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(20,40,20,40));
		mainPanel.setBackground(Color.pink);
		setTitle("Register");
		setSize(600, 750);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.png"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		initLogo();
		initTitle();
		initName();
		initEmail();
		initGender();
		initDob();
		initPhone();
		initAddress();
		initPass();
		initConPass();
		initCheck();
		initRegButton();
		initLoginButton();
		
		add(mainPanel);
		setVisible(true);
	}
	
	private void initLogo() {
		logoLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		logoLabel.setForeground(new Color(130, 70, 77));
		logoPanel.add(logoLabel);
		logoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, logoPanel.getMinimumSize().height));
		logoPanel.setBackground(Color.pink);
		logoPanel.setBorder(new EmptyBorder(0,0,10,0));
		mainPanel.add(logoPanel);
	}
	
	private void initTitle() {
		titleLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		titleLabel.setForeground(new Color(27, 44, 99));
		titlePanel.add(titleLabel);
		titlePanel.setBackground(Color.pink);
		titlePanel.setBorder(new EmptyBorder(10,0,20,0));
		titlePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, titlePanel.getMinimumSize().height));
		mainPanel.add(titlePanel);
	}
	
	private void initName() {
		nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		nameLabel.setForeground(new Color(27, 44, 99));
		nameField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		nameField.setForeground(new Color(27, 44, 99));
		nameField.setBackground(new Color(255, 224, 229));
		nameField.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		namePanel.setBackground(Color.pink);
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		namePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, namePanel.getMinimumSize().height));
		namePanel.setBorder(new EmptyBorder(0,0,5,0));
		mainPanel.add(namePanel);
	}
	
	private void initEmail() {
		emailLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		emailLabel.setForeground(new Color(27, 44, 99));
		emailField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		emailField.setForeground(new Color(27, 44, 99));
		emailField.setBackground(new Color(255, 224, 229));
		emailField.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		emailPanel.setBackground(Color.pink);
		emailPanel.add(emailLabel);
		emailPanel.add(emailField);
		emailPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, emailPanel.getMinimumSize().height));
		emailPanel.setBorder(new EmptyBorder(0,0,5,0));
		mainPanel.add(emailPanel);
	}
	
	private void initPass() {
		passLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		passLabel.setForeground(new Color(27, 44, 99));
		passField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		passField.setForeground(new Color(27, 44, 99));
		passField.setBackground(new Color(255, 224, 229));
		passField.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		passPanel.setBackground(Color.pink);
		passPanel.add(passLabel);
		passPanel.add(passField);
		passPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, passPanel.getMinimumSize().height));
		passPanel.setBorder(new EmptyBorder(0,0,5,0));
		mainPanel.add(passPanel);
	}
	
	private void initConPass() {
		conpassLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		conpassLabel.setForeground(new Color(27, 44, 99));
		conpassField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		conpassField.setForeground(new Color(27, 44, 99));
		conpassField.setBackground(new Color(255, 224, 229));
		conpassField.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		conpassPanel.setBackground(Color.pink);
		conpassPanel.add(conpassLabel);
		conpassPanel.add(conpassField);
		conpassPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, conpassPanel.getMinimumSize().height));
		conpassPanel.setBorder(new EmptyBorder(0,0,10,0));
		mainPanel.add(conpassPanel);
	}
	
	private void initGender() {
		genderLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		genderLabel.setForeground(new Color(27, 44, 99));
		maleButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		maleButton.setForeground(new Color(27, 44, 99));
		femaleButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		femaleButton.setForeground(new Color(27, 44, 99));
		maleButton.setBackground(Color.pink);
		femaleButton.setBackground(Color.pink);
		maleButton.setActionCommand("Male");
		femaleButton.setActionCommand("Female");
		genderButton.add(maleButton);
		genderButton.add(femaleButton);
		genderPanel.add(genderLabel);
		genderButton.setBackground(Color.pink);
		genderPanel.add(genderButton);
		genderPanel.setBackground(Color.pink);
		genderPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, genderPanel.getMinimumSize().height));
		mainPanel.add(genderPanel);
		gender.add(femaleButton);
		gender.add(maleButton);
	}
	
	private void initDob() {
		dobLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		dobLabel.setForeground(new Color(27, 44, 99));
		dd.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		dd.setForeground(new Color(27, 44, 99));
		dd.setBackground(new Color(255, 224, 229));
		dd.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		mm.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mm.setForeground(new Color(27, 44, 99));
		mm.setBackground(new Color(255, 224, 229));
		mm.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		yyyy.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		yyyy.setForeground(new Color(27, 44, 99));
		yyyy.setBackground(new Color(255, 224, 229));
		yyyy.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		dStrip.setBorder(new EmptyBorder(0, 5, 0, 5));
		dStrip.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mStrip.setBorder(new EmptyBorder(0, 5, 0, 5));
		mStrip.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		ddmmyyyy.setBackground(Color.pink);
		dobPanel.setBackground(Color.pink);
		dobPanel.setBorder(new EmptyBorder(5, 0, 5, 0));
		dobPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, dobPanel.getMinimumSize().height));
		dobPanel.add(dobLabel);
		ddmmyyyy.setLayout(new BoxLayout(ddmmyyyy, BoxLayout.X_AXIS));
		ddmmyyyy.add(dd);
		ddmmyyyy.add(dStrip);
		ddmmyyyy.add(mm);
		ddmmyyyy.add(mStrip);
		ddmmyyyy.add(yyyy);
		dobPanel.add(ddmmyyyy);
		mainPanel.add(dobPanel);
	}
	
	private void initPhone() {
		msgLabel.setVisible(false);
		msgLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		msgLabel.setForeground(Color.red);
		phoneLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		phoneLabel.setForeground(new Color(27, 44, 99));
		phoneField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		phoneField.setForeground(new Color(27, 44, 99));
		phoneField.setBackground(new Color(255, 224, 229));
		phoneField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent key) {
				if (key.getKeyChar() >= '0' && key.getKeyChar() <= '9') {
					msgLabel.setVisible(false);
				}
				else if (key.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					msgLabel.setVisible(false);
				}
				else {
					msgLabel.setVisible(true);
				}
			}
		});
		phoneField.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		phonePanel.setBackground(Color.pink);
		phoneValid.add(phoneField);
		phoneValid.add(msgLabel);
		phoneValid.setLayout(new BoxLayout(phoneValid, BoxLayout.X_AXIS));
		phoneValid.setBackground(new Color(255, 224, 229));
		phonePanel.add(phoneLabel);
		phonePanel.add(phoneValid);
		phonePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, phonePanel.getMinimumSize().height));
		phonePanel.setBorder(new EmptyBorder(0,0,5,0));
		mainPanel.add(phonePanel);
	}
	
	private void initAddress() {
		addressLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		addressLabel.setForeground(new Color(27, 44, 99));
		addressArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		addressArea.setForeground(new Color(27, 44, 99));
		addressArea.setBackground(new Color(255, 224, 229));
		addressArea.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		addressPanel.setBackground(Color.pink);
		addressPanel.add(addressLabel);
		addressPanel.add(addressArea);
		addressArea.setWrapStyleWord(true);
		addressArea.setLineWrap(true);
		addressPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 100));
		addressPanel.setBorder(new EmptyBorder(0,0,5,0));
		mainPanel.add(addressPanel);
	}
	
	private void initCheck() {
		termsCon.setFont(new Font("Segoe UI", Font.BOLD, 15));
		termsCon.setForeground(new Color(27, 44, 99));
		termsCon.setBackground(Color.pink);
		checkBox.add(termsCon);
		checkBox.setBackground(Color.pink);
		mainPanel.add(checkBox);
	}
	
	private void initRegButton() {
		regButton.setPreferredSize(new Dimension(150, 50));
		regButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		regButton.setForeground(new Color(27, 44, 99));
		regButton.setBackground(new Color(255, 217, 229));
		regButton.setBorder(null);
		regButton.addActionListener(this);
		buttonPanel.add(regButton);
		buttonPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
		buttonPanel.setBackground(Color.pink);
		mainPanel.add(buttonPanel);
	}
	
	private void initLoginButton() {
		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setOpaque(false);
		loginButton.setForeground(Color.BLUE);
		loginButton.setFont(new Font("Calibri", Font.ITALIC, 16));
		loginButton.addActionListener(this);
		loginPanel.setBackground(Color.pink);
		loginPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
		loginPanel.add(loginButton);
		mainPanel.add(loginPanel);
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
	
	private boolean checkNumeric(String value) {
		try {
			Integer.parseInt(value);
		}
		catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private boolean checkAlphanumeric(String value) {
		boolean number = false;
		boolean alphabet = false;
		boolean yey = false;
		for (int i = 0; i < value.length(); i++) {
			if (Character.isAlphabetic(value.charAt(i))) {
				alphabet = true;
			}
			if (Character.isDigit(value.charAt(i))) {
				number = true;
			}
		}
		if (number == true && alphabet == true) {
			yey = true;
		}
		return yey;
	}
	
	private void regSuccess() {
		String id = "U" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		while (UserModel.checkId(id) == true) {
			id = "U" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		}
		String name = nameField.getText();
		String email = emailField.getText();
		String pass = String.valueOf(passField.getPassword());
		String gen = gender.getSelection().getActionCommand();
		String phone = phoneField.getText();
		String address = addressArea.getText();
		String dob = yyyy.getText() + "-" + mm.getText() + "-" + dd.getText();
		String role = "User";
		
		UserModel.InsertUser(id, name, email, pass, gen, dob, phone, address, role);
	}
	
	private void validation() {
		if (nameField.getText().isEmpty()) {
			paneLayout("Username cannot be empty!");
		}
		else if (emailField.getText().isEmpty()) {
			paneLayout("Email cannot be empty!");
		}
		else if (passField.getText().isEmpty()) {
			paneLayout("Password cannot be empty!");
		}
		else if (gender.isSelected(null)) {
			paneLayout("Choose your gender!");
		}
		else if (dd.getText().isEmpty() || mm.getText().isEmpty() || yyyy.getText().isEmpty()) {
			paneLayout("Date of birth cannot be empty!");
		}
		else if (phoneField.getText().isEmpty()) {
			paneLayout("Phone number cannot be empty!");
		}
		else if (addressArea.getText().isEmpty()) {
			paneLayout("Address cannot be empty!");
		}
		else if (nameField.getText().length() < 5 || nameField.getText().length() > 15) {
			paneLayout("Username must be between 5 - 15 characters!");
		}
		else if (!emailField.getText().contains("@") || !emailField.getText().endsWith(".com") || emailField.getText().contains("@.") || emailField.getText().contains(" ")) {
			paneLayout("Input email in the right format!");
		}
		else if (msgLabel.isVisible() == true) {
			paneLayout("Phone number must be numeric!");
		}
		else if (phoneField.getText().length() < 10 || phoneField.getText().length() > 12) {
			paneLayout("Phone number must be between 10 - 12 digits!");
		}
		else if (!addressArea.getText().endsWith("Street")) {
			paneLayout("Address must end with 'Street'!");
		}
		else if (checkNumeric(dd.getText()) == false || checkNumeric(yyyy.getText()) == false || checkNumeric(yyyy.getText()) == false) {
			paneLayout("Wrong date format!");
		}
		else if (dd.getText().length() != 2 || mm.getText().length() != 2 || yyyy.getText().length() != 4) {
			paneLayout("Wrong date format!");
		}
		else if (checkAlphanumeric(String.valueOf(passField.getText())) == false) {
			paneLayout("Password must be alphanumeric!");
		}
		else if (!conpassField.getText().equals(passField.getText())) {
			paneLayout("Confirm Password is wrong!");
		}
		else if (UserModel.checkName(nameField.getText()) == true) {
			paneLayout("Username already exist!");
		}
		else if (UserModel.checkPhone(phoneField.getText()) == true) {
			paneLayout("Phone number already exist!");
		}
		else if (termsCon.isSelected() == false) {
			paneLayout("You must agree to terms and conditions!");
		}
		else {
			regSuccess();
			successPaneLayout("Register Success!");
			this.setVisible(false);
			new Login();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == regButton) {
			validation();
		}
		if (e.getSource() == loginButton) {
			this.setVisible(false);
			new Login();
		}
	}
}
