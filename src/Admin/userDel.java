package Admin;

import java.awt.Dimension;
import java.awt.EventQueue;
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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userDel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3844128689284797422L;
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
					userDel frame = new userDel();
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
	public userDel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 545) / 2, 500, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 83, 482, 300);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel(" 删除用户");
		label.setFont(new Font("幼圆", Font.BOLD, 40));
		label.setBounds(124, 13, 242, 57);
		contentPane.add(label);
		JLabel label_1 = new JLabel("要删除的用户编号：");
		label_1.setBounds(10, 403, 135, 18);
		contentPane.add(label_1);
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(147, 400, 174, 24);
		contentPane.add(textField);
		TableMode.addColumn("用户账号");
		TableMode.addColumn("用户密码");
		TableMode.addColumn("用户姓名");
		TableMode.addColumn("身份证号");
		TableMode.addColumn("联系电话");
		DisplayData();
		
		JButton button = new JButton("选中");
		button.setBounds(355, 396, 113, 27);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 RowsData();
			}
		});

		
		JButton button_1 = new JButton("退出删除");
		button_1.setBounds(296, 458, 113, 27);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		
		JButton button_2 = new JButton("确认删除");
		button_2.setBounds(91, 458, 113, 27);
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataDel();
				DisplayData();
				JOptionPane.showMessageDialog(null,"删除用户成功！！！","状态",1);
			}
		});
		setVisible(true);
	}
	public void DisplayData() {
		try {
			TableMode.setRowCount(0);
			String sql="select * from [User]";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	   String Uid= rs.getString("UNum");
				   String Upassword = rs.getString("UPsword");
				   String Uname = rs.getString("UName");
				   String ID = rs.getString("IDcard");
				   String telephone = rs.getString("Telephone");

				   String[] str = {Uid,Upassword,Uname,ID,telephone};
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
			String sql="delete from [User] where UNum='"+s+"'";
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
