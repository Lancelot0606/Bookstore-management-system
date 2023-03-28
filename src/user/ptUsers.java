package user;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class ptUsers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7819218310698340043L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ptUsers(String userId) {
		setTitle("Hi Story ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 1050) / 2, (d.height - 545) / 2, 1050, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true); 
		
		JLabel lblNewLabel = new JLabel("��ӭ����Hi Story���");
		lblNewLabel.setFont(new Font("��Բ", Font.PLAIN, 40));
		lblNewLabel.setBounds(3, 3, 800, 80);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel1 = new JLabel("�𾴵��û� "+userId+"  !");
		lblNewLabel1.setFont(new Font("��Բ", Font.PLAIN, 25));
		lblNewLabel1.setBounds(13, 40, 346, 80);
		contentPane.add(lblNewLabel1);
		JLabel lblNewLabel3 = new JLabel("����1Ԫ=1����");
		lblNewLabel3.setForeground(Color.RED);
		lblNewLabel3.setBackground(Color.WHITE);
		lblNewLabel3.setBounds(860, 442, 158, 18);
		contentPane.add(lblNewLabel3);
		
		JButton btnNewButton = new JButton("ͼ�鹺��");
		btnNewButton.setBounds(40, 374, 150, 60);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    new bkOrder(userId);
			}
		});
		JButton btnNewButton_1 = new JButton("������ѯ");
		btnNewButton_1.setBounds(300, 374, 150, 60);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FindOrder(userId);
			}
		});
		
		
		JButton btnNewButton_2 = new JButton("������Ϣ����");
		btnNewButton_2.setBounds(560, 374, 150, 60);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new msgManage(userId);
			}
		});
		
		JButton btnNewButton_3 = new JButton("���ֶһ�");
		btnNewButton_3.setBounds(820, 374, 150, 60);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Exchange(userId);
			}
		});
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_3);

	}

}
