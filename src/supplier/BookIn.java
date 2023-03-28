package supplier;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookIn extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7606533359594329353L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);
	JComboBox<Object> comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookIn frame = new BookIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookIn() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 1050) / 2, (d.height - 540) / 2, 1050,540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(343, 114, 689, 294);
		contentPane.add(scrollPane);
		
	    JLabel label = new JLabel(" 图书列表");
		label.setFont(new Font("幼圆", Font.PLAIN, 40));
		label.setBounds(572, 33, 249, 45);
		contentPane.add(label);
		JLabel label_1 = new JLabel("图书名称");
		label_1.setFont(new Font("幼圆", Font.BOLD, 15));
		label_1.setBounds(14, 124, 72, 18);
		contentPane.add(label_1);
		JLabel label_2 = new JLabel("图书编号");
		label_2.setFont(new Font("幼圆", Font.BOLD, 15));
		label_2.setBounds(14, 187, 72, 18);
		contentPane.add(label_2);
		JLabel label_4 = new JLabel("供货商选择");
		label_4.setFont(new Font("幼圆", Font.BOLD, 15));
		label_4.setBounds(14, 260, 83, 18);
		contentPane.add(label_4);
		JLabel label_6 = new JLabel("采购数量");
		label_6.setFont(new Font("幼圆", Font.BOLD, 15));
		label_6.setBounds(14, 320, 72, 18);
		contentPane.add(label_6);

		textField = new JTextField();
		textField.setText((String) null);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(155, 121, 154, 24);
		contentPane.add(textField);
		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(155, 184, 154, 24);
		contentPane.add(textField_1);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(155, 314, 154, 24);
		contentPane.add(textField_4);
		
		comboBox = new JComboBox<Object>();
		comboBox.setBounds(155, 256, 154, 24);
		contentPane.add(comboBox);
		getSup();
		
		TableMode.addColumn("图书编号");
		TableMode.addColumn("图书名称");
		TableMode.addColumn("图书库存");
		DisplayData();
		
		JButton button = new JButton("确认选中");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RowsData();
			}
		});
		button.setBounds(884, 432, 134, 40);
		contentPane.add(button);
		
		JButton button_1 = new JButton("采购");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InSup();
			}
		});
		button_1.setBounds(28, 432, 113, 40);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("取消");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setBounds(196, 432, 113, 40);
		contentPane.add(button_2);
		
		setVisible(true);
	}
	public void getSup(){
		String sql="select * from supplier";
		  Statement stm=new Connect().Connects();
				try {
					ResultSet rs = stm.executeQuery(sql);
					while(rs.next()) {
					comboBox.addItem(rs.getString("SupName"));
					}
					
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
	}
	
	public void DisplayData() {
		try {
			TableMode.setRowCount(0);
			String sql="select * from Book";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	   String Bkid= rs.getString("Bid");
				   String BkName = rs.getString("BName");
				   String Amount=rs.getString("Amount");
				   String[] str = {Bkid,BkName,Amount};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			
	}
	
	public void InSup(){
		Random random = new Random();
        Integer r = random.nextInt(900000000) + 100000000;
		String s0=textField_1.getText();
		String s4=textField_4.getText();
		String s2= (String)comboBox.getSelectedItem();
		
		Statement stm=new Connect().Connects();
		Statement stm1=new Connect().Connects();
				try {
					String sql="select SupNum from Supplier where SupName='"+s2+"'";
					ResultSet rs=stm.executeQuery(sql);
				     while(rs.next()){ 
				    String s=rs.getString("SupNum");
					String sql1="insert into Order_Sup values('"+r+"','"+s0+"','"+s+"','"+s4+"')";
					stm1.executeUpdate(sql1);
					
					JOptionPane.showMessageDialog(null,"购买成功，收到货后请及时结算入库！","状态",1);
				     }
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
	}
	
	public void RowsData() {
		int[] rows=table.getSelectedRows();
		if(rows.length == 0) return;
		int row = rows[0];
		String s0= (String)TableMode.getValueAt(row, 0);
		String s1= (String)TableMode.getValueAt(row, 1);
		textField.setText(s1);
		textField_1.setText(s0);
	}
	
}
