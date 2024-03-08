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
import java.util.Random;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ManageCake extends JFrame implements ActionListener {
	
	String shape[] = {"Oval", "Rectangle"};
	String ovalSize[] = {"15 cm", "20 cm", "25 cm"};
	String rectSize[] = {"10 x 10 cm", "20 x 20 cm", "30 x 30 cm"};
	
	Vector<Cake> cakes = new Vector();
	Vector<String> rowHeader = new Vector();
	
	Random rand = new Random();
	
	public static String deletedId = null;

	JPanel mainPanel = new JPanel();
	JPanel logoPanel = new JPanel();
	JLabel logoLabel = new JLabel("CakeLAnd");
	JPanel titlePanel = new JPanel();
	JLabel titleLabel = new JLabel("Cake List");
	DefaultTableModel cakeDTM;
	JTable cakeList = new JTable();
	JScrollPane scroll = new JScrollPane();
	JPanel insPanel = new JPanel();
	JPanel textPanel = new JPanel();
	JPanel namePanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel nameLabel = new JLabel("Cake Name");
	JTextField nameField = new JTextField();
	JPanel pricePanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JLabel priceLabel = new JLabel("Cake Price");
	JTextField priceField = new JTextField();
	JPanel comboBoxPanel = new JPanel(new GridLayout(3, 2, 5, 5));
	JLabel ovalsizeLabel = new JLabel("Oval Size");
	JComboBox<String> ovalsizeCombo = new JComboBox(ovalSize);
	JLabel rectsizeLabel = new JLabel("Rectangle Size");
	JComboBox<String> rectsizeCombo = new JComboBox(rectSize);
	JLabel shapeLabel = new JLabel("Shape");
	JComboBox<String> shapeCombo = new JComboBox(shape);
	JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	JPanel addbuttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton addButton = new JButton("Add Cake");
	JPanel removebuttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JButton removeButton = new JButton("Remove Cake");
	JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JButton backButton = new JButton("Back to Main Menu");
	
	public ManageCake() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(10,40,10,40));
		mainPanel.setBackground(Color.pink);
		insPanel.setLayout(new BoxLayout(insPanel, BoxLayout.X_AXIS));
		insPanel.setBackground(Color.pink);
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		textPanel.setBorder(new EmptyBorder(10,10,10,30));
		textPanel.setBackground(Color.pink);
		buttonPanel.setBackground(Color.pink);
		buttonPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
		setTitle("CakeLAnd");
		setSize(700, 600);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.png"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		selectRow();
		initBackButton();
		initLogo();
		initTitle();
		initTable();
		initName();
		initPrice();
		initComboBox();
		initButton();
		
		insPanel.add(textPanel);
		insPanel.add(buttonPanel);
		mainPanel.add(insPanel);
		add(mainPanel);
		setVisible(true);
	}
	
	private void initTable() {
		rowHeader.add("Cake ID");
		rowHeader.add("Cake Name");
		rowHeader.add("Cake Price");
		rowHeader.add("Cake Shape");
		rowHeader.add("Cake Size");
		cakeDTM = new DefaultTableModel(rowHeader, 0);
		cakeList.setModel(cakeDTM);
		cakeList.setBackground(new Color(255, 224, 229));
		cakeList.setForeground(new Color(140, 73, 86));
		cakeList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cakeList.setRowHeight(25);
		cakeList.getTableHeader().setPreferredSize(new Dimension(scroll.getWidth(), 30));
		cakeList.getTableHeader().setBackground(new Color(250, 177, 202));
		cakeList.getTableHeader().setForeground(new Color(140, 73, 86));
		cakeList.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		scroll.setViewportView(cakeList);
		refreshTable();
		mainPanel.add(scroll);
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
		textPanel.add(namePanel);
	}
	
	private void initPrice() {
		priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		priceLabel.setForeground(new Color(27, 44, 99));
		priceField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		priceField.setForeground(new Color(27, 44, 99));
		priceField.setBackground(new Color(255, 224, 229));
		priceField.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		pricePanel.setBackground(Color.pink);
		pricePanel.add(priceLabel);
		pricePanel.add(priceField);
		pricePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, pricePanel.getMinimumSize().height));
		pricePanel.setBorder(new EmptyBorder(0,0,5,0));
		textPanel.add(pricePanel);
	}
	
	private void initComboBox() {
		shapeLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		shapeLabel.setForeground(new Color(27, 44, 99));
		ovalsizeLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ovalsizeLabel.setForeground(new Color(27, 44, 99));
		rectsizeLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		rectsizeLabel.setForeground(new Color(27, 44, 99));
		shapeCombo.setBackground(new Color(255, 224, 229));
		shapeCombo.setForeground(new Color(27, 44, 99));
		ovalsizeCombo.setBackground(new Color(255, 224, 229));
		ovalsizeCombo.setForeground(new Color(27, 44, 99));
		rectsizeCombo.setBackground(new Color(255, 224, 229));
		rectsizeCombo.setForeground(new Color(27, 44, 99));
		comboBoxPanel.add(shapeLabel);
		comboBoxPanel.add(shapeCombo);
		rectsizeCombo.setEnabled(false);
		shapeCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (shapeCombo.getSelectedIndex() == 1) {
					ovalsizeCombo.setEnabled(false);
					rectsizeCombo.setEnabled(true);
				}
				else {
					ovalsizeCombo.setEnabled(true);
					rectsizeCombo.setEnabled(false);
				}
			}
		});
		comboBoxPanel.add(ovalsizeLabel);
		comboBoxPanel.add(ovalsizeCombo);
		comboBoxPanel.add(rectsizeLabel);
		comboBoxPanel.add(rectsizeCombo);
		comboBoxPanel.setBackground(Color.pink);
		textPanel.add(comboBoxPanel);
	}
	
	private void initButton() {
		removeButton.setPreferredSize(new Dimension(150, 50));
		removeButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		removeButton.setForeground(new Color(27, 44, 99));
		removeButton.setBackground(new Color(255, 217, 229));
		removeButton.setBorder(null);
		removeButton.addActionListener(this);
		removebuttonPanel.add(removeButton);
		removebuttonPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
		removebuttonPanel.setBackground(Color.pink);
		buttonPanel.add(removeButton);
		addButton.setPreferredSize(new Dimension(150, 50));
		addButton.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		addButton.setForeground(new Color(27, 44, 99));
		addButton.setBackground(new Color(255, 217, 229));
		addButton.setBorder(null);
		addButton.addActionListener(this);
		addbuttonPanel.add(addButton);
		addbuttonPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
		addbuttonPanel.setBackground(Color.pink);
		buttonPanel.add(addButton);
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
	
	private void selectRow() {
		cakeList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = cakeList.getSelectedRow();
				deletedId = cakeList.getValueAt(row, 0).toString();
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
	
	private void refreshTable() {
		cakeDTM.setRowCount(0);
		cakes = CakeModel.getCakeList();
		for (int i = 0; i < cakes.size(); i++) {
			Object cakeDetail[] = new Object[] {
					cakes.get(i).getCakeID(),
					cakes.get(i).getCakeName(),
					cakes.get(i).getCakePrice(),
					cakes.get(i).getCakeShape(),
					cakes.get(i).getCakeSize()
			};
			cakeDTM.addRow(cakeDetail);
		}
	}
	
	private void inputSuccess() {
		String id = null;
		int price = 0;
		String shape = null;
		String size = null;
		String name = nameField.getText();
		if (shapeCombo.getSelectedIndex() == 0 && ovalsizeCombo.getSelectedIndex() == 0) {
			id = "COF" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
			price = Integer.parseInt(priceField.getText()) + (1000 * 15);
			shape = "Oval";
			size = "15 cm";
		}
		else if (shapeCombo.getSelectedIndex() == 0 && ovalsizeCombo.getSelectedIndex() == 1) {
			id = "CON" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
			price = Integer.parseInt(priceField.getText()) + (1000 * 20);
			shape = "Oval";
			size = "20 cm";
		}
		else if (shapeCombo.getSelectedIndex() == 0 && ovalsizeCombo.getSelectedIndex() == 2) {
			id = "COV" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
			price = Integer.parseInt(priceField.getText()) + (1000 * 25);
			shape = "Oval";
			size = "25 cm";
		}
		else if(shapeCombo.getSelectedIndex() == 1 && rectsizeCombo.getSelectedIndex() == 0) {
			id = "CRT" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
			price = Integer.parseInt(priceField.getText()) + (2000 * 10);
			shape = "Rectangle";
			size = "10 x 10 cm";
		}
		else if(shapeCombo.getSelectedIndex() == 1 && rectsizeCombo.getSelectedIndex() == 1) {
			id = "CRW" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
			price = Integer.parseInt(priceField.getText()) + (2000 * 20);
			shape = "Rectangle";
			size = "20 x 20 cm";
		}
		else if(shapeCombo.getSelectedIndex() == 1 && rectsizeCombo.getSelectedIndex() == 2) {
			id = "CRH" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
			price = Integer.parseInt(priceField.getText()) + (2000 * 30);
			shape = "Rectangle";
			size = "30 x 30 cm";
		}
		CakeModel.InsertCake(id, name, price, size, shape);
		refreshTable();
	}
	
	private void validation() {
		if (nameField.getText().isEmpty()) {
			paneLayout("Input the Cake Name!");
		}
		else if (priceField.getText().isEmpty()) {
			paneLayout("Input the Cake Price!");
		}
		else if (!nameField.getText().endsWith("Cake")) {
			paneLayout("Cake name must end with 'Cake'!");
		}
		else if (Integer.parseInt(priceField.getText()) < 100000 || Integer.parseInt(priceField.getText()) > 500000) {
			paneLayout("Cake price must be between Rp 100.000 - Rp 500.000!");
		}
		else {
			inputSuccess();
			successPaneLayout("Cake successfully inputted to the database!");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			validation();
		}
		if (e.getSource() == removeButton) {
			if (deletedId == null) {
				paneLayout("Select cake you want to remove!");
			}
			else {
				CakeModel.deleteCake();
				successPaneLayout("Cake Successfully Removed!");
				deletedId = null;
				refreshTable();
			}
		}
		if (e.getSource() == backButton) {
			this.setVisible(false);
			new AdminMain();
		}
	}
}
