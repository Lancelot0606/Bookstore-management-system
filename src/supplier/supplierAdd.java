package supplier;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connect.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class supplierAdd extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7785046918573282086L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supplierAdd frame = new supplierAdd();
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
	public supplierAdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 500) / 2, (d.height - 545) / 2, 500, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(" 增加供货商");
		label.setFont(new Font("幼圆", Font.BOLD, 40));
		label.setBounds(125, 13, 244, 86);
		contentPane.add(label);
		JLabel label_1 = new JLabel("供货商编号");
		label_1.setFont(new Font("幼圆", Font.BOLD, 15));
		label_1.setBounds(99, 174, 95, 18);
		contentPane.add(label_1);
		JLabel label_2 = new JLabel("供货商名称");
		label_2.setFont(new Font("幼圆", Font.BOLD, 15));
		label_2.setBounds(99, 223, 95, 18);
		contentPane.add(label_2);
		JLabel label_3 = new JLabel("供货商地址");
		label_3.setFont(new Font("幼圆", Font.BOLD, 15));
		label_3.setBounds(99, 274, 95, 18);
		contentPane.add(label_3);
		JLabel label_4 = new JLabel("供货商电话");
		label_4.setFont(new Font("幼圆", Font.BOLD, 15));
		label_4.setBounds(99, 326, 95, 18);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(225, 171, 144, 24);
		contentPane.add(textField);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(225, 220, 144, 24);
		contentPane.add(textField_1);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(225, 271, 144, 24);
		contentPane.add(textField_2);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(225, 323, 144, 24);
		contentPane.add(textField_3);
		
		JButton button = new JButton("确认添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSup();
				dispose();
			}
		});
		button.setBounds(99, 439, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("退出添加");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(264, 439, 113, 27);
		contentPane.add(button_1);
		setVisible(true);
	}
	public void addSup() {
		String s0=textField.getText();
		String s1=textField_1.getText();
		String s2=textField_2.getText();
		String s3=textField_3.getText();

		Statement stm1=new Connect().Connects();
				try {
					String sql1="insert into Supplier values('"+s0+"','"+s1+"','"+s2+"','"+s3+"')";
					stm1.executeUpdate(sql1);
					JOptionPane.showMessageDialog(null,"供货商添加成功！","状态",1);
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
	}
}
