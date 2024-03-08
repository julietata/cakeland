import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TransactionHistory extends JFrame implements ActionListener {
	
	Vector<String> rowHeader = new Vector();
	Vector<TransactionHeader> headerData = new Vector();
	Vector<String> rowDetail = new Vector();
	Vector<ShowDetail> detailData = new Vector();
	
	static String transId = null;
	static int totalPrice = 0;

	JPanel mainPanel = new JPanel();
	JPanel logoPanel = new JPanel();
	JLabel logoLabel = new JLabel("CakeLAnd");
	JPanel titlePanel = new JPanel();
	JLabel titleLabel = new JLabel("Transaction History");
	DefaultTableModel headerDTM;
	JTable headerList = new JTable();
	JScrollPane headerScroll = new JScrollPane();
	DefaultTableModel detailDTM;
	JTable detailList = new JTable();
	JScrollPane detailScroll = new JScrollPane();
	JPanel selectedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JLabel selectedLabel = new JLabel("Selected ID");
	JTextField selectedField = new JTextField();
	JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JLabel totalLabel = new JLabel("Total");
	JTextField totalValue = new JTextField();
	JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JButton backButton = new JButton("Back to Main Menu");
	
	public TransactionHistory() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(20,40,20,40));
		mainPanel.setBackground(Color.pink);
		setTitle("CakeLAnd");
		setSize(750, 700);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/logo.png"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		selectRow();
		initLogo();
		initTitle();
		initHeaderTable();
		initSelected();
		initDetailTable();
		initTotal();
		initButton();
		
		mainPanel.add(buttonPanel);
		add(mainPanel);
		setVisible(true);
	}
	
	private void initHeaderTable() {
		rowHeader.add("Transaction ID");
		rowHeader.add("Transaction Date");
		rowHeader.add("Pick Up Date");
		headerDTM = new DefaultTableModel(rowHeader, 0);
		headerList.setModel(headerDTM);
		headerList.setBackground(new Color(255, 224, 229));
		headerList.setForeground(new Color(140, 73, 86));
		headerList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		headerList.setRowHeight(25);
		headerList.getTableHeader().setPreferredSize(new Dimension(headerScroll.getWidth(), 30));
		headerList.getTableHeader().setBackground(new Color(250, 177, 202));
		headerList.getTableHeader().setForeground(new Color(140, 73, 86));
		headerList.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		headerScroll.setViewportView(headerList);
		headerTable();
		mainPanel.add(headerScroll);
	}
	
	private void initDetailTable() {
		rowDetail.add("Cake Name");
		rowDetail.add("Cake Size");
		rowDetail.add("Cake Shape");
		rowDetail.add("Cake Price");
		rowDetail.add("Quantity");
		rowDetail.add("SubTotal");
		detailDTM = new DefaultTableModel(rowDetail, 0);
		detailList.setModel(detailDTM);
		detailList.setBackground(new Color(255, 224, 229));
		detailList.setForeground(new Color(140, 73, 86));
		detailList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		detailList.setRowHeight(25);
		detailList.getTableHeader().setPreferredSize(new Dimension(detailScroll.getWidth(), 30));
		detailList.getTableHeader().setBackground(new Color(250, 177, 202));
		detailList.getTableHeader().setForeground(new Color(140, 73, 86));
		detailList.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
		detailScroll.setViewportView(detailList);
		mainPanel.add(detailScroll);
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
	
	private void initSelected() {
		selectedLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		selectedLabel.setForeground(new Color(27, 44, 99));
		selectedField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selectedField.setForeground(new Color(27, 44, 99));
		selectedField.setBackground(new Color(255, 224, 229));
		selectedField.setPreferredSize(new Dimension(120, 30));
		selectedField.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		selectedField.setEditable(false);
		selectedPanel.setBackground(Color.pink);
		selectedPanel.add(selectedLabel);
		selectedPanel.add(selectedField);
		selectedPanel.setBorder(new EmptyBorder(5, 0, 5, 0));
		mainPanel.add(selectedPanel);
	}
	
	private void initTotal() {
		totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		totalLabel.setForeground(new Color(27, 44, 99));
		totalValue.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		totalValue.setForeground(new Color(27, 44, 99));
		totalValue.setBackground(new Color(255, 224, 229));
		totalValue.setPreferredSize(new Dimension(150, 30));
		totalValue.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5, 5)));
		totalPanel.setBackground(Color.pink);
		totalPanel.add(totalLabel);
		totalPanel.add(totalValue);
		mainPanel.add(totalPanel);
	}
	
	private void initButton() {
		buttonPanel.setBackground(Color.pink);
		backButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		backButton.setBackground(new Color(255, 224, 229));
		backButton.setForeground(new Color(27, 44, 99));
		backButton.addActionListener(this);
		buttonPanel.add(backButton);
		mainPanel.add(buttonPanel);
	}
	
	private void headerTable() {
		headerDTM.setRowCount(0);
		headerData = TransactionModel.showHeader();
		for (int i = 0; i < headerData.size(); i++) {
			Object headers[] = new Object[] {
					headerData.get(i).getTransactionId(),
					headerData.get(i).getTransactionDate(),
					headerData.get(i).getPickUpDate()
			};
			headerDTM.addRow(headers);
		}
	}
	
	private void detailTable() {
		detailDTM.setRowCount(0);
		detailData = TransactionModel.showDetail(transId);
		for (int i = 0; i < detailData.size(); i++) {
			Object details[] = new Object[] {
					detailData.get(i).getCakeName(),
					detailData.get(i).getCakeSize(),
					detailData.get(i).getCakeShape(),
					detailData.get(i).getPrice(),
					detailData.get(i).getQty(),
					detailData.get(i).getSubtotal(),
			};
			totalPrice += detailData.get(i).getSubtotal();
			detailDTM.addRow(details);
		}
	}
	
	private void selectRow() {
		headerList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = headerList.getSelectedRow();
				transId = headerData.get(row).getTransactionId();
				selectedField.setText(transId);
				detailTable();
				totalValue.setText("Rp " + totalPrice);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			transId = null;
			totalPrice = 0;
			this.setVisible(false);
			new UserMain();
		}
	}
	
}
