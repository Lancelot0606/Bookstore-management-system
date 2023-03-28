package user;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vUsers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8780286257438184759L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public vUsers(String userId) {
		setTitle("Hi Story ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 1050) / 2, (d.height - 545) / 2, 1050, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel2 = new JLabel("��ӭ����Hi Story���");
		lblNewLabel2.setFont(new Font("��Բ", Font.PLAIN, 40));
		lblNewLabel2.setBounds(3, 3, 800, 80);
		contentPane.add(lblNewLabel2);
		JLabel lblNewLabel1 = new JLabel("�𾴵Ļ�Ա�û� "+userId+"  !");
		lblNewLabel1.setFont(new Font("��Բ", Font.PLAIN, 25));
		lblNewLabel1.setBounds(13, 40, 346, 80);
		contentPane.add(lblNewLabel1);
		JLabel lblNewLabel = new JLabel("��Ա������������Ż�");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(50, 442, 158, 18);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel3 = new JLabel("����1Ԫ=1����");
		lblNewLabel3.setForeground(Color.RED);
		lblNewLabel3.setBackground(Color.WHITE);
		lblNewLabel3.setBounds(860, 442, 158, 18);
		contentPane.add(lblNewLabel3);
		
		JButton btnNewButton = new JButton("ͼ�鹺��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new vbkOrder(userId);
			}
		});
		btnNewButton.setBounds(40, 369, 150, 60);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("������ѯ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FindOrder(userId);
			}
		});
		btnNewButton_1.setBounds(300, 369, 150, 60);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("��Ϣ����");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new msgManage(userId);
			}
		});
		btnNewButton_2.setBounds(560, 369, 150, 60);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("��Ա���ֶһ�");
		 btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new vExchange(userId);
			}
		});
		btnNewButton_3.setBounds(820, 369, 150, 60);
		contentPane.add(btnNewButton_3);
		
	}

}
