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

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userFind extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2721075680163803343L;
	private JPanel contentPane;
	private JTextField textField;
	DefaultTableModel TableMode =new DefaultTableModel();
	private JTable table=new JTable(TableMode);

	/**
	 * Create the frame.
	 */
	public userFind() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 545) / 2, 500, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JLabel label = new JLabel(" 用户查询");
		label.setFont(new Font("幼圆", Font.BOLD, 40));
		label.setBounds(125, 0, 248, 67);
		contentPane.add(label);
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(14, 80, 145, 24);
		contentPane.add(textField);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 117, 482, 381);
		contentPane.add(scrollPane);
		TableMode.addColumn("用户账号");
		TableMode.addColumn("用户密码");
		TableMode.addColumn("用户姓名");
		TableMode.addColumn("身份证号");
		TableMode.addColumn("联系电话");
		TableMode.addColumn("积分");
		DisplayData();
		
		JButton button = new JButton("按编号");
		button.setBounds(198, 80, 129, 27);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()==0) {
					DisplayData();
				}
				else
				DisplayDataId();
			}
		});
		
		
		JButton button_1 = new JButton("按姓名");
		button_1.setBounds(341, 80, 130, 27);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()==0) {
					DisplayData();
				}
				else
				DisplayDataName();
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
				   String score = rs.getString("Score");
				   String[] str = {Uid,Upassword,Uname,ID,telephone,score};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			
	}
	
	public void DisplayDataName() {
		String s=textField.getText();
		TableMode.setRowCount(0);
		try {
			String sql="select * from [User] where UName='"+s+"'";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	   String Uid= rs.getString("UNum");
				   String Upassword = rs.getString("UPsword");
				   String Uname = rs.getString("UName");
				   String ID = rs.getString("IDcard");
				   String telephone = rs.getString("Telephone");
				   String score = rs.getString("Score");
				   String[] str = {Uid,Upassword,Uname,ID,telephone,score};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			
	}
	
	public void DisplayDataId() {
		String s=textField.getText();
		TableMode.setRowCount(0);
		try {
			String sql="select * from [User] where UNum='"+s+"'";
	        Statement stm=new Connect().Connects();
	        ResultSet rs=stm.executeQuery(sql);
	        while(rs.next()){ 
	        	   String Uid= rs.getString("UNum");
				   String Upassword = rs.getString("UPsword");
				   String Uname = rs.getString("UName");
				   String ID = rs.getString("IDcard");
				   String telephone = rs.getString("Telephone");
				   String score = rs.getString("Score");
				   String[] str = {Uid,Upassword,Uname,ID,telephone,score};
				   TableMode.addRow(str);
	        }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			
	}
}
