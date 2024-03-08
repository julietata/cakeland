import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ManageCart extends JFrame implements ActionListener {

	Vector<ShowCart> cartData = new Vector();
	Vector<String> rowHeader = new Vector();
	
	public static String selectId = null;
	
	JPanel mainPanel = new JPanel();
	JPanel logoPanel = new JPanel();
	JLabel logoLabel = new JLabel("CakeLAnd");
	JPanel titlePanel = new JPanel();
	JLabel titleLabel = new JLabel("Your Cart");
	JPanel secPanel = new JPanel();
	DefaultTableModel cartDTM;
	JTable cartList = new JTable();
	JScrollPane scroll = new JScrollPane();
	JPanel inputPanel = new JPanel();
	SpinnerModel sm = new SpinnerNumberModel(1, 1, 100, 1);
	JPanel spinner = new JPanel();
	JLabel qtyLabel = new JLabel("Quantity");
	JSpinner qty = new JSpinner(sm);
	JPanel button = new JPanel(new GridLayout(4, 1, 5, 5));
	JButton removeButton = new JButton("Remove From Cart");
	JButton updateButton = new JButton("Update Cake Order");
	JButton checkOut = new JButton("Check Out");
	JButton viewMenu = new JButton("View All Menu");
	JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JButton backButton = new JButton("Back to Main Menu");
	
	public ManageCart() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(10,40,20,40));
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
		
		selectRow();
		initBackButton();
		initLogo();
		initTitle();
		initTable();
		initSpinner();
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
		cartList.setModel(cartDTM);
		refreshTable();
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
	
	private void initSpinner() {
		spinner.setLayout(new BoxLayout(spinner, BoxLayout.X_AXIS));
		spinner.setBackground(Color.pink);
		qtyLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		qtyLabel.setForeground(new Color(27, 44, 99));
		qtyLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
		qty.setMaximumSize(new Dimension(120, 80));
		qty.getEditor().getComponent(0).setBackground(new Color(255, 217, 229));
		qty.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		qty.getEditor().getComponent(0).setForeground(new Color(27, 44, 99));
		spinner.add(qtyLabel);
		spinner.add(qty);
		inputPanel.add(spinner);
	}
	
	private void initButton() {
		removeButton.setPreferredSize(new Dimension(150, 50));
		removeButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		removeButton.setForeground(new Color(27, 44, 99));
		removeButton.setBackground(new Color(255, 217, 229));
		removeButton.setBorder(null);
		removeButton.addActionListener(this);
		updateButton.setPreferredSize(new Dimension(150, 50));
		updateButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		updateButton.setForeground(new Color(27, 44, 99));
		updateButton.setBackground(new Color(255, 217, 229));
		updateButton.setBorder(null);
		updateButton.addActionListener(this);
		checkOut.setPreferredSize(new Dimension(150, 50));
		checkOut.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		checkOut.setForeground(new Color(27, 44, 99));
		checkOut.setBackground(new Color(255, 217, 229));
		checkOut.setBorder(null);
		checkOut.addActionListener(this);
		viewMenu.setPreferredSize(new Dimension(150, 50));
		viewMenu.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		viewMenu.setForeground(new Color(27, 44, 99));
		viewMenu.setBackground(new Color(255, 217, 229));
		viewMenu.setBorder(null);
		viewMenu.addActionListener(this);
		button.setBackground(Color.pink);
		button.add(removeButton);
		button.add(updateButton);
		button.add(checkOut);
		button.add(viewMenu);
		button.setBorder(new EmptyBorder(20, 0, 0, 0));
		inputPanel.add(button);
	}
	
	private void initBackButton() {
		backPanel.setBackground(Color.pink);
		backButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		backButton.setBackground(new Color(255, 224, 229));
		backButton.setForeground(new Color(27, 44, 99));
		backButton.addActionListener(this);
		backPanel.add(backButton);
		mainPanel.add(backPanel);
	}
	
	private void refreshTable() {
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
		}
	}
	
	private void selectRow() {
		cartList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = cartList.getSelectedRow();
				selectId = TransactionModel.showCart().get(row).getCakeId();
			}
		});
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == removeButton) {
			if (selectId == null) {
				paneLayout("Select cake you want to cancel!");
			}
			else {
				TransactionModel.deleteCart();
				refreshTable();
				successPaneLayout("Cake successfully remove from your cart!");
				selectId = null;
			}
		}
		if (e.getSource() == updateButton) {
			if (selectId == null) {
				paneLayout("Select cake you want to update order!");
			}
			else {
				TransactionModel.updateCart((Integer) qty.getValue());
				refreshTable();
				successPaneLayout("Cake Successfully Updated!");
				selectId = null;
			}
		}
		if (e.getSource() == checkOut) {
			boolean check = TransactionModel.checkCart();
			if (check == false) {
				paneLayout("Your cart is empty!");
			}
			else {
				this.setVisible(false);
				new ConfirmCheckOut();
			}
		}
		if (e.getSource() == viewMenu) {
			selectId = null;
			this.setVisible(false);
			new ViewAllMenu();
		}
		if (e.getSource() == backButton) {
			this.setVisible(false);
			new UserMain();
		}
	}

}
