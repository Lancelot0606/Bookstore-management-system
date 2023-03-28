package supplier;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class supplierDel extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6745969640843862177L;
	private JPanel contentPane;
	private JTextField textField;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supplierDel frame = new supplierDel();
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
	public supplierDel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 545) / 2, 500, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(" 删除供货商");
		label.setFont(new Font("幼圆", Font.BOLD, 40));
		label.setBounds(124, 0, 242, 57);
		contentPane.add(label);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 70, 482, 300);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(147, 387, 86, 24);
		contentPane.add(textField);
		
		TableMode.addColumn("供货商编号");
		TableMode.addColumn("供货商名称");
		TableMode.addColumn("供货商地址");
		TableMode.addColumn("供货商电话");
		DisplayData();
		
		JLabel label_1 = new JLabel("要删除的供货商号：");
		label_1.setBounds(10, 390, 142, 18);
		contentPane.add(label_1);
		
		JButton button = new JButton("选中");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RowsData();
			}
		});
		button.setBounds(296, 383, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("退出删除");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(296, 445, 113, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("确认删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataDel();
				DisplayData();
				JOptionPane.showMessageDialog(null,"供货商删除成功！","状态",1);
			}
		});
		button_2.setBounds(91, 445, 113, 27);
		contentPane.add(button_2);
		setVisible(true);
	}
	public void DisplayData() {
		try {
			TableMode.setRowCount(0);
			String sql="select * from Supplier";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	   String SupNum= rs.getString("SupNum");
				   String SupName = rs.getString("SupName");
				   String SupAddress = rs.getString("SupAddress");
				   String SupTel = rs.getString("SupTel");
				   

				   String[] str = {SupNum,SupName,SupAddress,SupTel};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			
	}
	
	public void DataDel() {
		try {
			TableMode.setRowCount(0);
			String s = textField.getText();
			String sql="delete from Supplier where SupNum='"+s+"'";
	        Statement stm=new Connect().Connects();
	        stm.executeUpdate(sql);
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
		textField.setText(s0);
	}
}
