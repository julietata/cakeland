import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UserMain extends JFrame implements ActionListener {
	
	JFrame mainFrame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel logoPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	JLabel helloLabel = new JLabel("Hello " + Login.userLog.getUserName() + "!");
	JLabel logoLabel = new JLabel("Welcome to CakeLAnd");
	JMenuBar menuBar = new JMenuBar();
	JMenu user = new JMenu("Manage Account");
	JMenuItem profile = new JMenuItem("Profile");
	JMenuItem logout = new JMenuItem("Logout");
	JMenu transaction = new JMenu("Transaction");
	JMenuItem view = new JMenuItem("View All Menu");
	JMenuItem cart = new JMenuItem("Manage Cart");
	JMenuItem trans = new JMenuItem("View Transaction History");
	
	public UserMain() {
		
		mainFrame.setTitle("CakeLAnd");
		mainFrame.setSize(550, 300);
		mainFrame.setResizable(false);
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.png"));
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		
		Menu();
		initLogo();
		
		mainPanel.setBackground(Color.pink);
		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
	}
	
	private void Menu() {
		menuBar.setBackground(new Color(245, 198, 211));
		user.setForeground(new Color(27, 44, 99));
		transaction.setForeground(new Color(27, 44, 99));
		profile.setBackground(new Color(255, 217, 229));
		logout.setBackground(new Color(255, 217, 229));
		view.setBackground(new Color(255, 217, 229));
		cart.setBackground(new Color(255, 217, 229));
		trans.setBackground(new Color(255, 217, 229));
		user.add(profile);
		profile.addActionListener(this);
		user.add(logout);
		logout.addActionListener(this);
		transaction.add(view);
		view.addActionListener(this);
		transaction.add(cart);
		cart.addActionListener(this);
		transaction.add(trans);
		trans.addActionListener(this);
		menuBar.add(user);
		menuBar.add(transaction);
		mainFrame.setJMenuBar(menuBar);
	}
	
	private void initLogo() {
		helloLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		helloLabel.setForeground(new Color(27, 44, 99));
		logoLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
		logoLabel.setForeground(new Color(130, 70, 77));
		logoPanel.add(helloLabel);
		logoPanel.add(logoLabel);
		logoPanel.setBackground(Color.pink);
		logoPanel.setBorder(new EmptyBorder(50,0,0,0));
		mainPanel.add(logoPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logout) {
			mainFrame.setVisible(false);
			new Login();
		}
		if (e.getSource() == profile) {
			mainFrame.setVisible(false);
			new UpdateProfile();
		}
		if (e.getSource() == view) {
			mainFrame.setVisible(false);
			new ViewAllMenu();
		}
		if (e.getSource() == cart) {
			mainFrame.setVisible(false);
			new ManageCart();
		}
		if (e.getSource() == trans) {
			mainFrame.setVisible(false);
			new TransactionHistory();
		}
	}
}
