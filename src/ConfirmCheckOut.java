import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Random;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ConfirmCheckOut extends JFrame implements ActionListener {

	Vector<ShowCart> cartData = new Vector();
	Vector<String> rowHeader = new Vector();
	
	static int totalPrice = 0;
	static String pickUpDate = LocalDate.now().plusDays(3).toString();
	
	Random rand = new Random();
	
	JPanel mainPanel = new JPanel();
	JPanel logoPanel = new JPanel();
	JLabel logoLabel = new JLabel("CakeLAnd");
	JPanel titlePanel = new JPanel();
	JLabel titleLabel = new JLabel("Your Order");
	JPanel secPanel = new JPanel();
	DefaultTableModel cartDTM;
	JTable cartList = new JTable();
	JScrollPane scroll = new JScrollPane();
	JPanel inputPanel = new JPanel();
	JPanel textPanel = new JPanel(new GridLayout(2, 2, 5, 5));
	JLabel totalLabel = new JLabel("Total");
	JTextField totalValue = new JTextField();
	JLabel date = new JLabel("Pick Up Date");
	JTextField dateField = new JTextField();
	JPanel checkButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton checkOutButton = new JButton("Check Out");
	JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton backButton = new JButton("Back to Main Menu");
	
	public ConfirmCheckOut() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(20,40,20,40));
		mainPanel.setBackground(Color.pink);
		secPanel.setLayout(new BoxLayout(secPanel, BoxLayout.X_AXIS));
		secPanel.setBackground(Color.pink);
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.setBorder(new EmptyBorder(20, 20, 20, 0));
		inputPanel.setBackground(Color.pink);
		setTitle("CakeLAnd");
		setSize(900, 450);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.png"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		initLogo();
		initTitle();
		initTable();
		initText();
		initButton();

		secPanel.add(inputPanel);
		mainPanel.add(secPanel);
		add(mainPanel);
		setVisible(true);
	}
	
	private void initTable() {
		rowHeader.add("Cake Name");
		rowHeader.add("Cake Shape");
		rowHeader.add("Cake Size");
		rowHeader.add("Cake Price");
		rowHeader.add("Quantity");
		cartDTM = new DefaultTableModel(rowHeader, 0);
		dataTable();
		cartList.setModel(cartDTM);
		cartList.setBackground(new Color(255, 224, 229));
		cartList.setForeground(new Color(140, 73, 86));
		cartList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cartList.setRowHeight(25);
		cartList.getTableHeader().setPreferredSize(new Dimension(scroll.getWidth(), 30));
		cartList.getTableHeader().setBackground(new Color(250, 177, 202));
		cartList.getTableHeader().setForeground(new Color(140, 73, 86));
		cartList.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		scroll.setViewportView(cartList);
		secPanel.add(scroll);
	}
	
	private void initLogo() {
		logoLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		logoLabel.setForeground(new Color(130, 70, 77));
		logoPanel.add(logoLabel);
		logoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, logoPanel.getMinimumSize().height));
		logoPanel.setBackground(Color.pink);
		mainPanel.add(logoPanel);
	}
	
	private void initTitle() {
		titleLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		titleLabel.setForeground(new Color(27, 44, 99));
		titlePanel.add(titleLabel);
		titlePanel.setBackground(Color.pink);
		titlePanel.setBorder(new EmptyBorder(0,0,10,0));
		titlePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, titlePanel.getMinimumSize().height));
		mainPanel.add(titlePanel);
	}
	
	private void initText() {
		textPanel.setBackground(Color.pink);
		totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		totalLabel.setForeground(new Color(27, 44, 99));
		totalValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
		totalValue.setForeground(new Color(27, 44, 99));
		totalValue.setBackground(new Color(255, 224, 229));
		totalValue.setText("Rp " + totalPrice);
		totalValue.setEditable(false);
		date.setFont(new Font("Segoe UI", Font.BOLD, 18));
		date.setForeground(new Color(27, 44, 99));
		dateField.setFont(new Font("Segoe UI", Font.BOLD, 18));
		dateField.setForeground(new Color(27, 44, 99));
		dateField.setBackground(new Color(255, 224, 229));
		dateField.setText(pickUpDate);
		dateField.setEditable(false);
		textPanel.add(totalLabel);
		textPanel.add(totalValue);
		textPanel.add(date);
		textPanel.add(dateField);
		textPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
		inputPanel.add(textPanel);
	}
	
	private void initButton() {
		checkOutButton.setPreferredSize(new Dimension(150, 50));
		checkOutButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		checkOutButton.setForeground(new Color(27, 44, 99));
		checkOutButton.setBackground(new Color(255, 217, 229));
		checkOutButton.setBorder(null);
		checkOutButton.addActionListener(this);
		backButton.setPreferredSize(new Dimension(220, 50));
		backButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		backButton.setForeground(new Color(27, 44, 99));
		backButton.setBackground(new Color(255, 217, 229));
		backButton.setBorder(null);
		backButton.addActionListener(this);
		checkButton.setBackground(Color.pink);
		backPanel.setBackground(Color.pink);
		checkButton.add(checkOutButton);
		backPanel.add(backButton);
		inputPanel.add(checkButton);
		inputPanel.add(backPanel);
	}
	
	private void dataTable() {
		cartDTM.setRowCount(0);
		cartData = TransactionModel.showCart();
		for (int i = 0; i < cartData.size(); i++) {
			Object carts[] = new Object[] {
					cartData.get(i).getCakeName(),
					cartData.get(i).getCakeShape(),
					cartData.get(i).getCakeSize(),
					cartData.get(i).getPrice(),
					cartData.get(i).getQuantity(),
			};
			cartDTM.addRow(carts);
			totalPrice += (cartData.get(i).getPrice() * cartData.get(i).getQuantity());
		}
	}
	
	private void insertTransaction() {
		String id = "T" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		while (TransactionModel.checkId(id) == true) {
			id = "T" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		}
		String user = Login.userLog.getUserID();
		String date = LocalDate.now().toString();
		String pickDate = pickUpDate;
		
		TransactionModel.insertTransHeader(id, user, date, pickDate);
		
		for (int i = 0; i < cartData.size(); i++) {
			TransactionModel.insertTransDetail(id, cartData.get(i).getCakeId(), cartData.get(i).getQuantity());
		}
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkOutButton) {
			insertTransaction();
			successPaneLayout("Transaction Successful! Remember to pick up your order! :)");
			TransactionModel.deleteCheckOut();
			totalPrice = 0;
			this.setVisible(false);
			new UserMain();
		}
		if (e.getSource() == backButton) {
			totalPrice = 0;
			this.setVisible(false);
			new UserMain();
		}
	}
}
