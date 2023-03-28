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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userEdit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5748570197338857439L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);

	/**
	 * Create the frame.
	 */
	public userEdit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 700) / 2, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel(" 用户信息修改");
		label.setFont(new Font("幼圆", Font.BOLD, 40));
		label.setBounds(120, 0, 325, 65);
		contentPane.add(label);
		JLabel label_5 = new JLabel("联系电话");
		label_5.setBounds(44, 567, 72, 18);
		contentPane.add(label_5);
		JLabel lblNewLabel_1 = new JLabel("积分");
		lblNewLabel_1.setBounds(251, 567, 72, 18);
		contentPane.add(lblNewLabel_1);
		JLabel label_1 = new JLabel("用户账号");
		label_1.setBounds(44, 426, 72, 18);
		contentPane.add(label_1);
		JLabel label_2 = new JLabel("用户密码");
		label_2.setBounds(251, 426, 72, 18);
		contentPane.add(label_2);
		JLabel label_3 = new JLabel("身份证号");
		label_3.setBounds(251, 499, 72, 18);
		contentPane.add(label_3);
		JLabel label_4 = new JLabel("用户姓名");
		label_4.setBounds(44, 499, 72, 18);
		contentPane.add(label_4);
		

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(117, 423, 120, 24);
		contentPane.add(textField);
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(337, 423, 120, 24);
		contentPane.add(textField_1);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 493, 120, 24);
		contentPane.add(textField_2);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(337, 496, 120, 24);
		contentPane.add(textField_3);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(117, 564, 120, 24);
		contentPane.add(textField_4);
		textField_7 = new JTextField();
		textField_7.setBounds(337, 564, 120, 24);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 65, 482, 298);
		contentPane.add(scrollPane);
		TableMode.addColumn("用户账号");
		TableMode.addColumn("用户密码");
		TableMode.addColumn("用户姓名");
		TableMode.addColumn("身份证号");
		TableMode.addColumn("联系电话");
		TableMode.addColumn("积分");
		DisplayData();
		
		JButton button = new JButton("退出修改");
		button.setBounds(301, 613, 113, 27);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		
		JButton button_2 = new JButton("确认修改");
		button_2.setBounds(81, 613, 113, 27);
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveData();
				DisplayData();
				dispose();
			}
		});

		JButton button_1 = new JButton("选中");
		button_1.setBounds(337, 376, 113, 27);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RowsData();
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
				   String score = rs.getString("score");
				   String[] str = {Uid,Upassword,Uname,ID,telephone,score};
				   TableMode.addRow(str);
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
		String s2= (String)TableMode.getValueAt(row, 2);
		String s3= (String)TableMode.getValueAt(row, 3);
		String s4= (String)TableMode.getValueAt(row, 4);
		String s7= (String)TableMode.getValueAt(row, 5);
		textField.setText(s0);
		textField_1.setText(s1);
		textField_2.setText(s2);
		textField_3.setText(s3);
		textField_4.setText(s4);
		textField_7.setText(s7);
	}

	public void SaveData(){
		 try {
			    String s0 = textField.getText();
			    String s1 = textField_1.getText();
				String s2 = textField_2.getText();
				String s3 = textField_3.getText();
				String s4 = textField_4.getText();
				String s7 = textField_7.getText();
				String s="update [User]  set UNum='"+s0+"',UPsword='"+s1+"',UName='"+s2+"',IDcard='"+s3+"',Telephone='"+s4+"',score='"+s7+"' where UNum='"+s0+"'";
		        Statement stm=new Connect().Connects();
				stm.executeUpdate(s);
				JOptionPane.showMessageDialog(null,"用户信息修改成功！！！","状态",1);
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
	}
}
