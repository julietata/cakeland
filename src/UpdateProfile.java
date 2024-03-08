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

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class UpdateProfile extends JFrame implements ActionListener {

	JPanel mainPanel = new JPanel();
	JPanel logoPanel = new JPanel();
	JLabel logoLabel = new JLabel("CakeLAnd");
	JPanel titlePanel = new JPanel();
	JLabel titleLabel = new JLabel("Change Profile");
	JPanel namePanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel nameLabel = new JLabel("Username");
	JTextField nameField = new JTextField();
	JPanel emailPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel emailLabel = new JLabel("Email");
	JTextField emailField = new JTextField();
	JPanel oldpassPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel oldpassLabel = new JLabel("Old Password");
	JPasswordField oldpassField = new JPasswordField();
	JPanel passPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel passLabel = new JLabel("New Password");
	JPasswordField passField = new JPasswordField();
	JPanel conpassPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel conpassLabel = new JLabel("Confirm New Password");
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
	JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton updateButton = new JButton("Save Change");
	
	public UpdateProfile() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(20,40,20,40));
		mainPanel.setBackground(Color.pink);
		setTitle("CakeLAnd");
		setSize(600, 700);
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
		initOldPass();
		initPass();
		initConPass();
		initUpdateButton();
		
		add(mainPanel);
		setVisible(true);
	}
	
	private void initLogo() {
		logoLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
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
		nameField.setText(Login.userLog.getUserName());
		nameField.setEditable(false);
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
		emailField.setText(Login.userLog.getUserEmail());
		emailPanel.setBackground(Color.pink);
		emailPanel.add(emailLabel);
		emailPanel.add(emailField);
		emailPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, emailPanel.getMinimumSize().height));
		emailPanel.setBorder(new EmptyBorder(0,0,5,0));
		mainPanel.add(emailPanel);
	}
	
	private void initOldPass() {
		oldpassLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		oldpassLabel.setForeground(new Color(27, 44, 99));
		oldpassField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		oldpassField.setForeground(new Color(27, 44, 99));
		oldpassField.setBackground(new Color(255, 224, 229));
		oldpassField.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		oldpassPanel.setBackground(Color.pink);
		oldpassPanel.add(oldpassLabel);
		oldpassPanel.add(oldpassField);
		oldpassPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, oldpassPanel.getMinimumSize().height));
		oldpassPanel.setBorder(new EmptyBorder(0,0,5,0));
		mainPanel.add(oldpassPanel);
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
		conpassPanel.setBorder(new EmptyBorder(0,0,5,0));
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
		
		if (Login.userLog.getUserGender().equals("Male")) {
			maleButton.setSelected(true);
		}
		else {
			femaleButton.setSelected(true);
		}
		maleButton.setEnabled(false);
		femaleButton.setEnabled(false);
		
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
		String[] dob = Login.userLog.getUserDOB().split("-");
		dobLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		dobLabel.setForeground(new Color(27, 44, 99));
		dd.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		dd.setForeground(new Color(27, 44, 99));
		dd.setBackground(new Color(255, 224, 229));
		dd.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		dd.setText(dob[2]);
		dd.setEditable(false);
		mm.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mm.setForeground(new Color(27, 44, 99));
		mm.setBackground(new Color(255, 224, 229));
		mm.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		mm.setText(dob[1]);
		mm.setEditable(false);
		yyyy.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		yyyy.setForeground(new Color(27, 44, 99));
		yyyy.setBackground(new Color(255, 224, 229));
		yyyy.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		yyyy.setText(dob[0]);
		yyyy.setEditable(false);
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
		phoneField.setText(Login.userLog.getPhoneNumber());
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
		addressArea.setText(Login.userLog.getUserAddress());
		addressPanel.setBackground(Color.pink);
		addressPanel.add(addressLabel);
		addressPanel.add(addressArea);
		addressArea.setWrapStyleWord(true);
		addressArea.setLineWrap(true);
		addressPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 100));
		addressPanel.setBorder(new EmptyBorder(0,0,5,0));
		mainPanel.add(addressPanel);
	}
	
	private void initUpdateButton() {
		updateButton.setPreferredSize(new Dimension(150, 50));
		updateButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		updateButton.setForeground(new Color(27, 44, 99));
		updateButton.setBackground(new Color(255, 217, 229));
		updateButton.setBorder(null);
		updateButton.addActionListener(this);
		buttonPanel.add(updateButton);
		buttonPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
		buttonPanel.setBackground(Color.pink);
		mainPanel.add(buttonPanel);
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
	
	private String validatePass() {
		if (!passField.getText().isEmpty()) {
			if (oldpassField.getText().isEmpty()) {
				return "Input your old password to confirm your identity!";
			}
			else if (!oldpassField.getText().equals(Login.userLog.getUserPass())) {
				return "Wrong old password!";
			}
			else if (checkAlphanumeric(String.valueOf(passField.getText())) == false) {
				return "Password must be alphanumeric!";
			}
			else if (!conpassField.getText().equals(passField.getText())) {
				return "Confirm Password is wrong!";
			}
		}
		return "";
	}
	
	private void changeSuccess() {
		String id = Login.userLog.getUserID();
		String name = nameField.getText();
		String email = emailField.getText();
		String pass = Login.userLog.getUserPass();
		if (!passField.getText().isEmpty()) {
			pass = String.valueOf(passField.getText());
		}
		String gen = Login.userLog.getUserGender();
		String phone = phoneField.getText();
		String address = addressArea.getText();
		String dob = Login.userLog.getUserDOB();
		String role = Login.userLog.getUserRole();
		
		UserModel.UpdateUser(id, name, email, pass, gen, dob, phone, address, role);
	}
	
	private void validation() {
		if (emailField.getText().isEmpty()) {
			paneLayout("Email cannot be empty!");
		}
		else if (phoneField.getText().isEmpty()) {
			paneLayout("Phone number cannot be empty!");
		}
		else if (addressArea.getText().isEmpty()) {
			paneLayout("Address cannot be empty!");
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
		else if (UserModel.checkName(nameField.getText()) == true && !nameField.getText().equals(Login.userLog.getUserName())) {
			paneLayout("Username already exist!");
		}
		else if (UserModel.checkPhone(phoneField.getText()) == true && !phoneField.getText().equals(Login.userLog.getPhoneNumber())) {
			paneLayout("Phone number already exist!");
		}
		else if (!validatePass().equals("")) {
			paneLayout(validatePass());
		}
		else {
			changeSuccess();
			successPaneLayout("Profile Updated!");
			this.setVisible(false);
			new Login();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateButton) {
			validation();
		}
	}
}
