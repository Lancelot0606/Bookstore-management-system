package user;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connect.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Exchange extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7592585676008707167L;
	private JPanel contentPane;
    private int score;
	/**
	 * Create the frame.
	 */
	public Exchange(String userId) {
		score=Score(userId);
		setTitle("���ֶһ�");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 550) / 2, (d.height - 540) / 2, 550,540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(48, 152, 80, 112);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_4 = new JLabel("��ӵ�л���  "+score);
		lblNewLabel_4.setBounds(31, 101, 456, 18);
		contentPane.add(lblNewLabel_4);
		JLabel lblNewLabel_2 = new JLabel("��Ա(���۹����Ż�)");
		lblNewLabel_2.setFont(new Font("��Բ", Font.BOLD, 20));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(60, 150, 200, 60);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_1 = new JLabel("���ֶһ�");
		lblNewLabel_1.setFont(new Font("��Բ", Font.BOLD, 30));
		lblNewLabel_1.setBounds(200, 13, 257, 77);
		contentPane.add(lblNewLabel_1);

		
		JButton btnNewButton = new JButton("600���� �һ�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(score>=600) {
					Change(userId,600,score);
				    score=score-600;
				    Changevip(userId);
					JOptionPane.showMessageDialog(null,"�һ�VIP��Ա�ɹ��������µ�½��","״̬",1);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"�Բ������Ļ��ֲ��㣬�޷��һ�","״̬",1);
				}
			}
		});
		btnNewButton.setBounds(360, 165, 113, 27);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("�˳�");
		btnNewButton_1.setBounds(216, 422, 113, 27);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setVisible(true); 
	}
	
	public int Score(String userId) {
		String sql="select * from [user] where UNum='"+userId+"'"  ;
        Statement stm=new Connect().Connects();
		try {
			 ResultSet rs = stm.executeQuery(sql);
			 rs.next();
			 int score= Integer.parseInt(rs.getString("score"));
			 return score;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return 0;
        }
	
	public void Change(String userId,int tariff,int score) {
		int a=score-tariff;
			String sql="update [user]  set score= '"+a+"' where UNum='"+userId+"'";
	        Statement stm=new Connect().Connects();
			try {
				stm.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"�һ��ɹ���ʣ�����"+a,"״̬",1);
		}
	public void Changevip(String userId) {
		    boolean a=true;
			String sql="update [user] set vip= '"+a+"' where UNum='"+userId+"'";
	        Statement stm=new Connect().Connects();
			try {
				stm.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	
	}
