package Admin;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.sql.Statement;

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
import java.awt.event.ActionEvent;

public class newspaperAdd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7911107394955225904L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newspaperAdd frame = new newspaperAdd();
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
	public newspaperAdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 545) / 2, 500, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" 增加图书");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 40));
		lblNewLabel.setBounds(160, 20, 244, 86);
		JLabel lblNewLabel_1 = new JLabel("图书编号");
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 15));
		lblNewLabel_1.setBounds(110, 161, 72, 18);
		JLabel lblNewLabel_3 = new JLabel("图书名称");
		lblNewLabel_3.setFont(new Font("幼圆", Font.BOLD, 15));
		lblNewLabel_3.setBounds(110, 210, 72, 18);
		JLabel lblNewLabel_4 = new JLabel("图书单价");
		lblNewLabel_4.setFont(new Font("幼圆", Font.BOLD, 15));
		lblNewLabel_4.setBounds(110, 261, 72, 18);
		JLabel lblNewLabel_6 = new JLabel("图书作者");
		lblNewLabel_6.setFont(new Font("幼圆", Font.BOLD, 15));
		lblNewLabel_6.setBounds(110, 313, 72, 18);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(221, 158, 144, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBounds(221, 207, 144, 24);
		contentPane.add(textField_1);
		textField_2 = new JTextField();
		textField_2.setBounds(221, 258, 144, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_4 = new JTextField();
		textField_4.setBounds(221, 310, 144, 24);
		contentPane.add(textField_4);
		textField.setColumns(10);
		textField_1.setColumns(10);
		textField_2.setColumns(10);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("确认添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewspaper();
				dispose();
			}
		});
		btnNewButton.setBounds(95, 426, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出添加");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(260, 426, 113, 27);
		contentPane.add(btnNewButton_1);
		setVisible(true);

	}
	
	public void addNewspaper() {
		String s0=textField.getText();
		String s1=textField_1.getText();
		String s2=textField_2.getText();
		String s4=textField_4.getText();


		Statement stm1=new Connect().Connects();
				try {
					String sql1="insert into Book values('"+s0+"','"+s1+"','"+s2+"','"+s4+"',0)";
					stm1.executeUpdate(sql1);
					JOptionPane.showMessageDialog(null,"图书信息添加成功！！！","状态",1);
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
	}
}
