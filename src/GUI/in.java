package GUI;
import java.sql.*;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Admin.AdmUsers;
import connect.Connect;
import user.Register;
import user.ptUsers;
import user.vUsers;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Toolkit;

public class in extends JFrame {
	
	private static final long serialVersionUID = 904251504269503408L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_0;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField password;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					in frame = new in();
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
	public in() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setTitle("Hi Story 书店登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((d.width - 450) / 2, (d.height - 300) / 2, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_0 = new JLabel("账号");
		lblNewLabel_0.setBounds(120, 69, 57, 18);
		lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(120, 122, 57, 18);
		lblNewLabel_2 = new JLabel("Hi Story 书店");
		lblNewLabel_2.setFont(new Font("幼圆", Font.BOLD, 30));
		lblNewLabel_2.setBounds(120, 13, 276, 42);
		contentPane.add(lblNewLabel_0);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(175, 66, 148, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		password= new JPasswordField();
		password.setBounds(175, 119, 148, 24);
		contentPane.add(password);
		password.setColumns(10);

		ButtonGroup shenfen=new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("用户入口");
		rdbtnNewRadioButton.setBounds(100, 165, 98, 27);
		rdbtnNewRadioButton.setSelected(true);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("管理员入口");
		rdbtnNewRadioButton_1.setBounds(240, 165, 113, 27);
		contentPane.add(rdbtnNewRadioButton_1);
		
		shenfen.add(rdbtnNewRadioButton);
		shenfen.add(rdbtnNewRadioButton_1);
		
		btnNewButton = new JButton("登陆");
		btnNewButton.setBounds(110, 213, 80, 27);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
				String username=textField.getText();
		        char[] s=password.getPassword();
		        String pw=new String(s);
		        try {
		        	String sql="select * from [user] where UNum='"+username+"'";//执行的sql语句,在数据库里查找我们输的用户名
				    Statement stm=new Connect().Connects();
				    ResultSet rs=stm.executeQuery(sql);
					if(rs.next())
					{
						if(pw.equals(rs.getString("UPsword")))
					    {
						    if(rs.getBoolean("vip")==true) {
						    	setVisible(false);
							    new vUsers(username);
						    }
						    else {
						    	setVisible(false);
							    new ptUsers(username);
						    }
					    }
						else {
							JOptionPane.showMessageDialog(null,"账户或者密码错误，重新输入","状态",1);
							textField.setText("");
							password.setText("");;
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"账户或者密码错误，重新输入","状态",1);
						textField.setText("");
						password.setText("");;
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
               }
				if(rdbtnNewRadioButton_1.isSelected()) {
				String username=textField.getText();
		        char[] s=password.getPassword();
		        String pw=new String(s);
		        try {
		        	String sql="select * from Admin where AdID='"+username+"'";//执行的sql语句,在数据库里查找我们输的用户名
				    Statement stm=new Connect().Connects();
				    ResultSet rs=stm.executeQuery(sql);
					if(rs.next())
					{
						if(pw.equals(rs.getString("AdPsword")))
					    {
							setVisible(false);
							new AdmUsers();
					    }
						else {
							JOptionPane.showMessageDialog(null,"账户或者密码错误，重新输入","状态",1);
							textField.setText("");
							password.setText("");;
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"账户或者密码错误，重新输入","状态",1);
						textField.setText("");
						password.setText("");;
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
               }
			}
		});
		btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                   new Register();
			}
		});
		btnNewButton_1.setBounds(253, 213, 80, 27);
		contentPane.add(btnNewButton_1);
	}
}