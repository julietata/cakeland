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
import javax.swing.JFormattedTextField;
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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class ViewAllMenu extends JFrame implements ActionListener {

	Vector<Cake> cakes = new Vector();
	Vector<String> rowHeader = new Vector();
	
	public static String selectedId = null;
	
	JPanel mainPanel = new JPanel();
	JPanel logoPanel = new JPanel();
	JLabel logoLabel = new JLabel("CakeLAnd");
	JPanel titlePanel = new JPanel();
	JLabel titleLabel = new JLabel("Cake List");
	JPanel secPanel = new JPanel();
	DefaultTableModel cakeDTM;
	JTable cakeList = new JTable();
	JScrollPane scroll = new JScrollPane();
	JPanel inputPanel = new JPanel();
	SpinnerModel sm = new SpinnerNumberModel(1, 1, 100, 1);
	JPanel spinner = new JPanel();
	JLabel qtyLabel = new JLabel("Quantity");
	JSpinner qty = new JSpinner(sm);
	JPanel button = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton addButton = new JButton("Add to Cart");
	JButton viewButton = new JButton("View Cart");
	JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JButton backButton = new JButton("Back to Main Menu");
	
	public ViewAllMenu() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(10,40,20,40));
		mainPanel.setBackground(Color.pink);
		secPanel.setLayout(new BoxLayout(secPanel, BoxLayout.X_AXIS));
		secPanel.setBackground(Color.pink);
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.setBorder(new EmptyBorder(20, 20, 20, 0));
		inputPanel.setBackground(Color.pink);
		setTitle("CakeLAnd");
		setSize(800, 450);
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
		rowHeader.add("Cake Price");
		rowHeader.add("Cake Shape");
		rowHeader.add("Cake Size");
		cakeDTM = new DefaultTableModel(rowHeader, 0);
		cakeList.setModel(cakeDTM);
		dataTable();
		cakeList.setBackground(new Color(255, 224, 229));
		cakeList.setForeground(new Color(140, 73, 86));
		cakeList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cakeList.setRowHeight(25);
		cakeList.getTableHeader().setPreferredSize(new Dimension(scroll.getWidth(), 30));
		cakeList.getTableHeader().setBackground(new Color(250, 177, 202));
		cakeList.getTableHeader().setForeground(new Color(140, 73, 86));
		cakeList.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		scroll.setViewportView(cakeList);
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
		addButton.setPreferredSize(new Dimension(150, 50));
		addButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		addButton.setForeground(new Color(27, 44, 99));
		addButton.setBackground(new Color(255, 217, 229));
		addButton.setBorder(null);
		addButton.addActionListener(this);
		viewButton.setPreferredSize(new Dimension(150, 50));
		viewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		viewButton.setForeground(new Color(27, 44, 99));
		viewButton.setBackground(new Color(255, 217, 229));
		viewButton.setBorder(null);
		viewButton.addActionListener(this);
		button.setBorder(new EmptyBorder(10, 0, 0, 0));
		button.setBackground(Color.pink);
		button.add(addButton);
		button.add(viewButton);
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
	
	private void dataTable() {
		cakeDTM.setRowCount(0);
		cakes = CakeModel.getCakeList();
		for (int i = 0; i < cakes.size(); i++) {
			Object cakeDetail[] = new Object[] {
					cakes.get(i).getCakeName(),
					cakes.get(i).getCakePrice(),
					cakes.get(i).getCakeShape(),
					cakes.get(i).getCakeSize()
			};
			cakeDTM.addRow(cakeDetail);
		}
	}
	
	private void selectRow() {
		cakeList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = cakeList.getSelectedRow();
				selectedId = CakeModel.getCakeList().get(row).getCakeID();
			}
		});
	}
	
	private void successAdd() {
		String userId = Login.userLog.getUserID();
		String cakeId = selectedId;
		int quantity = (Integer) qty.getValue();
		boolean checkCake = TransactionModel.check(selectedId);
		if (checkCake == false) {
			paneLayout("This cake is already in your cart! If you want to change the quantity, do it on the update page!");
		}
		else {
			TransactionModel.insertCart(userId, cakeId, quantity);
			successPaneLayout("Cake Successfully added to Cart!");
		}
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
		if (e.getSource() == addButton) {
			if (selectedId == null) {
				paneLayout("Select Cake to add!");
			}
			else {
				successAdd();
				selectedId = null;
			}
		}
		if (e.getSource() == viewButton) {
			selectedId = null;
			this.setVisible(false);
			new ManageCart();
		}
		if (e.getSource() == backButton) {
			this.setVisible(false);
			new UserMain();
		}
	}

}
