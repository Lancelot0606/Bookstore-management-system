package user;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connect.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7705732440064280070L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;

	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("Hi Story ���ע�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 450) / 2, (d.height - 600) / 2,450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lblNewLabel = new JLabel("*�û����");
		lblNewLabel.setBounds(63, 138, 72, 18);
		contentPane.add(lblNewLabel);
		lblNewLabel_1 = new JLabel("*�û�����");
		lblNewLabel_1.setBounds(63, 187, 72, 18);
		contentPane.add(lblNewLabel_1);
        lblNewLabel_2 = new JLabel("*�û�����");
		lblNewLabel_2.setBounds(63, 241, 72, 18);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_3 = new JLabel("*���֤��");
		lblNewLabel_3.setBounds(63, 298, 72, 18);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_4 = new JLabel(" ��ϵ�绰");
		lblNewLabel_4.setBounds(63, 350, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(172, 135, 184, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBounds(172, 184, 184, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_2 = new JTextField();
		textField_2.setBounds(172, 238, 184, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_3 = new JTextField();
		textField_3.setBounds(172, 295, 184, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_4 = new JTextField();
		textField_4.setBounds(172, 347, 184, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		lblNewLabel_7 = new JLabel("ע����*����ĿΪ����");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(203, 421, 153, 18);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_8 = new JLabel("�û�ע��");
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setFont(new Font("��Բ", Font.BOLD, 29));
		lblNewLabel_8.setBounds(160, 40, 153, 45);
		contentPane.add(lblNewLabel_8);
		
        btnNewButton = new JButton("ע��");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				   
				    try {
				        String sql="insert into [user] values('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"',0,0)";
				        
				        Statement stm=new Connect().Connects();
						stm.executeUpdate(sql);
						JOptionPane.showMessageDialog(null,"ע��ɹ���","״̬",1);
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
		       
        		
        	}
        });
		btnNewButton.setBounds(63, 461, 113, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("ȡ��");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(247, 461, 113, 27);
		contentPane.add(btnNewButton_1);
		
	}
}
