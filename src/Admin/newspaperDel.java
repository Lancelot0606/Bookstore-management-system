package Admin;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.Connect;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class newspaperDel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1148137607229298025L;
	private JPanel contentPane;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public newspaperDel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 545) / 2, 500, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("要删除的图书编号：");
		lblNewLabel_1.setBounds(10, 403, 142, 18);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(147, 400, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 83, 482, 300);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("New button");
		scrollPane.setColumnHeaderView(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(" 删除图书");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 40));
		lblNewLabel.setBounds(124, 13, 242, 57);
		contentPane.add(lblNewLabel);
		
		TableMode.addColumn("图书编号");
		TableMode.addColumn("图书名称");
		TableMode.addColumn("图书单价");
		TableMode.addColumn("图书作者");
		DisplayData();
		
		
		JButton btnNewButton_3 = new JButton("选中");
		btnNewButton_3.setBounds(296, 396, 113, 27);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RowsData();
			}
		});

		
		JButton btnNewButton_1 = new JButton("确认删除");
		btnNewButton_1.setBounds(91, 458, 113, 27);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataDel();
				DisplayData();
				JOptionPane.showMessageDialog(null,"图书删除成功！！！","状态",1);
			}
		});
		
		JButton btnNewButton_2 = new JButton("退出删除");
		btnNewButton_2.setBounds(296, 458, 113, 27);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
		
		
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
				   String Price = rs.getString("Price");
				   String Author=rs.getString("Author");
				   String[] str = {Bkid,BkName,Price,Author};
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
			String sql="delete from Book where Bid='"+s+"'";
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
