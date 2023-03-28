package user;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connect.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class msgManage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3562814441882724257L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public msgManage(String userId) {
		setTitle("个人信息管理");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 1050) / 2, (d.height - 545) / 2, 1050, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(" 个人信息管理");
		label.setFont(new Font("幼圆", Font.BOLD, 40));
		label.setBounds(359, 45, 342, 71);
		contentPane.add(label);
		JLabel label_1 = new JLabel("*用户编号");
		label_1.setBounds(359, 157, 72, 18);
		JLabel label_2 = new JLabel("用户密码");
		label_2.setBounds(359, 309, 72, 18);
		JLabel label_3 = new JLabel("*用户姓名");
		label_3.setBounds(359, 210, 72, 18);
		JLabel label_4 = new JLabel("*身份证号");
		label_4.setBounds(359, 260, 72, 18);
		JLabel label_5 = new JLabel("联系电话");
		label_5.setBounds(362, 363, 72, 18);
		contentPane.add(label);
		contentPane.add(label_1);
		contentPane.add(label_2);
		contentPane.add(label_3);
		contentPane.add(label_4);
		contentPane.add(label_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(480, 154, 184, 24);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(480, 207, 184, 24);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(480, 257, 184, 24);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(480, 306, 184, 24);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(480, 360, 184, 24);
		contentPane.add(textField);
		contentPane.add(textField_1);
		contentPane.add(textField_2);
		contentPane.add(textField_3);
		contentPane.add(textField_4);
		textField.setEditable(false);
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		
		DisplayData(userId);
		
		JButton btnNewButton = new JButton("保存修改");
		btnNewButton.setBounds(469, 445, 113, 27);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveData(userId);
				dispose();
			}
		});

		
		setVisible(true); 
		
		
	}
	public void DisplayData(String userId){
		 try {
		        String sql="select * from [user] where UNum='"+userId+"'";
		        Statement stm=new Connect().Connects();
				ResultSet rs=stm.executeQuery(sql);
				rs.next();
				textField.setText(rs.getString("UNum"));
				textField_1.setText(rs.getString("UName"));
				textField_2.setText(rs.getString("IDcard"));
				textField_3.setText(rs.getString("Upsword"));
				textField_4.setText(rs.getString("Telephone"));
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
	}
	
	public void SaveData(String userId){
		 try {
				String s0 = textField_3.getText();
				String s1 = textField_4.getText();
				String s="update [user]  set Upsword='"+s0+"',Telephone='"+s1+"'where UNum='"+userId+"'";
		        Statement stm=new Connect().Connects();
				stm.executeUpdate(s);
				JOptionPane.showMessageDialog(null,"用户信息修改成功！！！","状态",1);
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
	}
}
